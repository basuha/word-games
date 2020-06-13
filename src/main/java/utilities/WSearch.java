package utilities;

import org.hibernate.Session;
import words.attributes.primary.*;
import words.attributes.secondary.*;
import words.primary.*;
import words.secondary.Particle;
import words.secondary.Pretext;
import words.secondary.Pronoun;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WSearch extends WDummy implements IWord {

    private Random random = new Random();
    protected List<IWord> wordsList = new ArrayList<>();
    private List<IWord> resultSet = new ArrayList<>();
    private final Byte[] hexCode = new Byte[17];
    protected IWord word;

    /** максимальное кол-во слов в выборке из БД */
    private final int MAX_RESULTS = 10000;

    /**
     * коэфицент определения корня слова (>1.0)
     * 1.0 = все слово - корень
     * 2.0 = половина слова - корень
     */
    private final double ROOT_DETECT_COEF = 1.5;

    /**
     * коэфицент подмешивания редких слов (0.0 - 1.0)
     * 0.0 = все слова редкие
     * 1.0 = все слова частые
     */
    private final double COMMON_WORDS_COEF = 0.0;

    /** частоупотребимые слова из файла */
    private static ArrayList<String> commonWords = new ArrayList<>();

    /** имя файла с частыми словами */
    private static final String COMMON_WORDS_FILE = "rusCommonWords.txt";

    /** имя основной таблицы */
    private static final String TABLE = "words_test";

    private boolean isPrimary;

    /** Индексы аттрибутов для HEX кода */
    protected static final int PART_OF_SPEECH_INDEX = 0;
    protected static final int WORD_CASE_INDEX = 1;
    protected static final int GENDER_INDEX = 2;
    protected static final int PLURAL_INDEX = 3;
    protected static final int TYPE_INDEX = 4;
    protected static final int TIME_INDEX = 5;
    protected static final int ADVERB_TYPE_INDEX = 6;
    protected static final int TRANSITIVE_INDEX = 7;
    protected static final int ANIMATE_INDEX = 8;
    protected static final int VOICE_INDEX = 9;
    protected static final int PERFECT_INDEX = 10;
    protected static final int KIND_INDEX = 11;
    protected static final int COMPARATIVE_INDEX = 12;
    protected static final int INFINITIVE_INDEX = 13;
    protected static final int FACE_INDEX = 14;
    protected static final int REFLEXIVE_INDEX = 15;
    protected static final int SHORT_FORM_INDEX = 16;

    static {
        //парсинг частоупотребляемых слов из txt файла
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(COMMON_WORDS_FILE));
            String temp;
            do {
                temp = reader.readLine();
                if (temp == null) break;
                commonWords.add(temp);
            } while (true);
        } catch (IOException e) {
            System.out.println("файл не найден");
        }
    }

    public WSearch() {
    }

    public WSearch(String hexCode) {
        hexInit(hexCode);
    }

    public WSearch(IWord word) {
        this.word = word;
        init();
    }

    private byte toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: "+ hexChar);
        }
        return (byte) digit;
    }

    private void hexInit(String hex)  {
        for (int i = 0; i < hex.length(); i++) {
            this.hexCode[i] = toDigit(hex.charAt(i));
        }

        switch (hexCode[PART_OF_SPEECH_INDEX]){
            case 0 -> partOfSpeech = null;
            case 1 -> partOfSpeech = "1";
            case 2 -> partOfSpeech = ADJECTIVE;
            case 3 -> partOfSpeech = ADVERB;
            case 4 -> partOfSpeech = EXTRA_PARTICIPLE;
            case 5 -> partOfSpeech = NOUN;
            case 6 -> partOfSpeech = NUMERAL;
            case 7 -> partOfSpeech = PARTICIPLE;
            case 8 -> partOfSpeech = VERB;
            case 9 -> partOfSpeech = CONJUNCTION;
            case 10 -> partOfSpeech = INTERJECTION;
            case 11 -> partOfSpeech = PARENTHESIS;
            case 12 -> partOfSpeech = PARTICLE;
            case 13 -> partOfSpeech = PREDICATE;
            case 14 -> partOfSpeech = PRETEXT;
            case 15 -> partOfSpeech = PRONOUN;
        }

        if (hexCode[ADVERB_TYPE_INDEX] != null) {
            switch (hexCode[ADVERB_TYPE_INDEX]) {
                case 0 -> adverbType = AdverbType.NULL;
                case 1 -> adverbType = AdverbType.N_A;
                case 2 -> adverbType = AdverbType.QUALITATIVE;
                case 3 -> adverbType = AdverbType.METHOD;
                case 4 -> adverbType = AdverbType.EXTENT;
                case 5 -> adverbType = AdverbType.PLACE;
                case 6 -> adverbType = AdverbType.DIRECTION;
                case 7 -> adverbType = AdverbType.TIMING;
                case 8 -> adverbType = AdverbType.PURPOSE;
                case 9 -> adverbType = AdverbType.REASON;
            }
        }

        if (hexCode[ANIMATE_INDEX] != null) {
            switch (hexCode[ANIMATE_INDEX]) {
                case 0 -> animate = Animate.NULL;
                case 1 -> animate = Animate.N_A;
                case 2 -> animate = Animate.ANIMATE;
                case 3 -> animate = Animate.INANIMATE;
            }
        }

        if (hexCode[GENDER_INDEX] != null) {
            switch (hexCode[GENDER_INDEX]) {
                case 0 -> gender = Gender.NULL;
                case 1 -> gender = Gender.N_A;
                case 2 -> gender = Gender.MALE;
                case 3 -> gender = Gender.FEMALE;
                case 4 -> gender = Gender.NEUTER;
                case 5 -> gender = Gender.COMMON;
            }
        }

        if (hexCode[KIND_INDEX] != null) {
            switch (hexCode[KIND_INDEX]) {
                case 0 -> kind = Kind.NULL;
                case 1 -> kind = Kind.N_A;
                case 2 -> kind = Kind.FIRST;
                case 3 -> kind = Kind.SECOND;
            }
        }

        if (hexCode[PLURAL_INDEX] != null) {
            switch (hexCode[PLURAL_INDEX]) {
                case 0 -> plural = Plural.NULL;
                case 1 -> plural = Plural.N_A;
                case 2 -> plural = Plural.PLURAL;
                case 3 -> plural = Plural.SINGULAR;
            }
        }

        if (hexCode[TIME_INDEX] != null) {
            switch (hexCode[TIME_INDEX]) {
                case 0 -> time = Time.NULL;
                case 1 -> time = Time.N_A;
                case 2 -> time = Time.PAST;
                case 3 -> time = Time.PRESENT;
                case 4 -> time = Time.FUTURE;
            }
        }

        if (hexCode[TYPE_INDEX] != null) {
            switch (hexCode[TYPE_INDEX]) {
                case 0 -> type = Type.NULL;
                case 1 -> type = Type.N_A;
                case 2 -> type = Type.IMMUTABLE_ADJECTIVE;
                case 3 -> type = Type.MUTABLE_ADJECTIVE;
                case 4 -> type = Type.EXTENSIVE_ADVERB;
                case 5 -> type = Type.DEFINITE_ADVERB;
                case 6 -> type = Type.QUESTION_ADVERB;
                case 7 -> type = Type.ORDINAL_NUMERAL;
                case 8 -> type = Type.QUANTITATIVE_NUMERAL;
                case 9 -> type = Type.COLLECTIVE_NUMERAL;
                case 10 -> type = Type.INDEFINITE_NUMERAL;
            }
        }

        if (hexCode[WORD_CASE_INDEX] != null) {
            switch (hexCode[WORD_CASE_INDEX]) {
                case 0 -> wordCase = WordCase.NULL;
                case 1 -> wordCase = WordCase.N_A;
                case 2 -> wordCase = WordCase.NOMINATIVE;
                case 3 -> wordCase = WordCase.GENITIVE;
                case 4 -> wordCase = WordCase.DATIVE;
                case 5 -> wordCase = WordCase.ACCUSATIVE;
                case 6 -> wordCase = WordCase.INSTRUMENTAL;
                case 7 -> wordCase = WordCase.PREPOSITIONAL;
                case 8 -> wordCase = WordCase.VOCATIVE;
                case 9 -> wordCase = WordCase.PARTITIVE;
                case 10 -> wordCase = WordCase.LOCATIVE;
                case 11 -> wordCase = WordCase.COUNTING;
            }
        }

        if (hexCode[COMPARATIVE_INDEX] != null) {
            switch (hexCode[COMPARATIVE_INDEX]) {
                case 0 -> comparative = Comparative.NULL;
                case 1 -> comparative = Comparative.N_A;
                case 2 -> comparative = Comparative.COMPARATIVE;
                case 3 -> comparative = Comparative.SUPER;
            }
        }

        if (hexCode[FACE_INDEX] != null) {
            switch (hexCode[FACE_INDEX]) {
                case 0 -> face = Face.NULL;
                case 1 -> face = Face.N_A;
                case 2 -> face = Face.FIRST;
                case 3 -> face = Face.SECOND;
                case 4 -> face = Face.THIRD;
                case 5 -> face = Face.ANONYMOUS;

            }
        }

        if (hexCode[INFINITIVE_INDEX] != null) {
            switch (hexCode[INFINITIVE_INDEX]) {
                case 0 -> infinitive = Infinitive.NULL;
                case 1 -> infinitive = Infinitive.N_A;
                case 2 -> infinitive = Infinitive.INFINITIVE;
                case 3 -> infinitive = Infinitive.NOT;
            }
        }

        if (hexCode[PERFECT_INDEX] != null) {
            switch (hexCode[PERFECT_INDEX]) {
                case 0 -> perfect = Perfect.NULL;
                case 1 -> perfect = Perfect.N_A;
                case 2 -> perfect = Perfect.PERFECT;
                case 3 -> perfect = Perfect.NOT_PERFECT;
            }
        }

        if (hexCode[REFLEXIVE_INDEX] != null) {
            switch (hexCode[REFLEXIVE_INDEX]) {
                case 0 -> reflexive = Reflexive.NULL;
                case 1 -> reflexive = Reflexive.N_A;
                case 2 -> reflexive = Reflexive.REFLEXIVE;
                case 3 -> reflexive = Reflexive.NOT_REFLEXIVE;
            }
        }

        if (hexCode[SHORT_FORM_INDEX] != null) {
            switch (hexCode[SHORT_FORM_INDEX]) {
                case 0 -> shortF = ShortF.NULL;
                case 1 -> shortF = ShortF.N_A;
                case 2 -> shortF = ShortF.SHORT;
            }
        }

        if (hexCode[TRANSITIVE_INDEX] != null) {
            switch (hexCode[TRANSITIVE_INDEX]) {
                case 0 -> transitive = Transitive.NULL;
                case 1 -> transitive = Transitive.N_A;
                case 2 -> transitive = Transitive.TRANSITIVE;
                case 3 -> transitive = Transitive.INTRANSITIVE;
                case 4 -> transitive = Transitive.TRANS_INTRANS;
            }
        }

        if (hexCode[VOICE_INDEX] != null) {
            switch (hexCode[VOICE_INDEX]) {
                case 0 -> voice = Voice.NULL;
                case 1 -> voice = Voice.N_A;
                case 2 -> voice = Voice.ACTIVE;
                case 3 -> voice = Voice.PASSIVE;
            }
        }
    }

    protected void init(){
        partOfSpeech = word.getPartOfSpeech();
        comparative = word.getComparative();
        gender = word.getGender();
        plural = word.getPlural();
        shortF = word.getShortF();
        type = word.getType();
        wordCase = word.getWordCase();
        adverbType = word.getAdverbType();
        transitive = word.getTransitive();
        perfect = word.getPerfect();
        time = word.getTime();
        reflexive = word.getReflexive();
        animate = word.getAnimate();
        face = word.getFace();
        infinitive = word.getInfinitive();
        kind = word.getKind();
        perfect = word.getPerfect();
        voice = word.getVoice();
    }

    private boolean isCommon(IWord word) {
        String wordWord = word.getWord();
        int wordLength = wordWord.length();
        int rootLength = (int) (wordLength / ROOT_DETECT_COEF);
        String wordRoot = wordWord.substring(0, rootLength); //определение корня слова
        for (String temp : commonWords) {
            if (temp.contains(wordRoot) || random.nextDouble() > COMMON_WORDS_COEF) {
                return true;
            }
        }
        return false;
    }

    protected void getResultSet() {  //подмешиваем частые слова в выборку для уменьшения "экзотичности" рандомизатора
        for (IWord w : wordsList) {
            if (isCommon(w)) {
                resultSet.add(w);
            }
        }
    }

    public static Word getRandom() {
        return Word.findById(new Random().nextInt(Word.getMaxID()));
    }

    public IWord getSingleWord() {
        if (resultSet.size() > 0) {
            return resultSet.get(random.nextInt(resultSet.size() - 1));
        }
        return null;
    }

    public List<IWord> getList() {
        return resultSet;
    }

}
