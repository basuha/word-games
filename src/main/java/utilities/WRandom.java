package utilities;

import org.hibernate.Session;
import words.attributes.primary.*;
import words.attributes.secondary.*;
import words.primary.*;
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

public class WRandom extends WDummy {

    private Word word;
    private Random random = new Random();
    private List<Word> wordsList = new ArrayList<>();
    private List<Word> resultSet = new ArrayList<>();
    private final Byte[] hexCode = new Byte[17];

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
    private final double COMMON_WORDS_COEF = 0.1;

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

    public WRandom() {
    }

    public WRandom(String hexCode) {
        for (int i = 0; i < hexCode.length(); i++) {
            this.hexCode[i] = toDigit(hexCode.charAt(i));
        }
        hexInit();
        run();
    }

    public WRandom(Word word) {
        init(word);
        run();
    }

    private byte toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: "+ hexChar);
        }
        return (byte) digit;
    }

    private void hexInit()  {

        switch (hexCode[PART_OF_SPEECH_INDEX]){
            case 0 -> partOfSpeech = null;
            case 1 -> partOfSpeech = ADJECTIVE;
            case 2 -> partOfSpeech = ADVERB;
            case 3 -> partOfSpeech = EXTRA_PARTICIPLE;
            case 4 -> partOfSpeech = NOUN;
            case 5 -> partOfSpeech = NUMERAL;
            case 6 -> partOfSpeech = PARTICIPLE;
            case 7 -> partOfSpeech = VERB;
            case 8 -> partOfSpeech = CONJUNCTION;
            case 9 -> partOfSpeech = INTERJECTION;
            case 0xA -> partOfSpeech = PARENTHESIS;
            case 0xB -> partOfSpeech = PARTICLE;
            case 0xC -> partOfSpeech = PREDICATE;
            case 0xD -> partOfSpeech = PRETEXT;
            case 0xE -> partOfSpeech = PRONOUN;
        }

        if (hexCode[ADVERB_TYPE_INDEX] != null) {
            switch (hexCode[ADVERB_TYPE_INDEX]) {
                case 0 -> adverbType = null;
                case 1 -> adverbType = AdverbType.QUALITATIVE;
                case 2 -> adverbType = AdverbType.METHOD;
                case 3 -> adverbType = AdverbType.EXTENT;
                case 4 -> adverbType = AdverbType.PLACE;
                case 5 -> adverbType = AdverbType.DIRECTION;
                case 6 -> adverbType = AdverbType.TIMING;
                case 7 -> adverbType = AdverbType.PURPOSE;
                case 8 -> adverbType = AdverbType.REASON;
            }
        }

        if (hexCode[ANIMATE_INDEX] != null) {
            switch (hexCode[ANIMATE_INDEX]) {
                case 0 -> animate = null;
                case 1 -> animate = Animate.ANIMATE;
                case 2 -> animate = Animate.INANIMATE;
                case 0xF -> animate = Animate.N_A;
            }
        }

        if (hexCode[GENDER_INDEX] != null) {
            switch (hexCode[GENDER_INDEX]) {
                case 0 -> gender = null;
                case 1 -> gender = Gender.MALE;
                case 2 -> gender = Gender.FEMALE;
                case 3 -> gender = Gender.NEUTER;
                case 4 -> gender = Gender.COMMON;
                case 0xF -> gender = Gender.N_A;
            }
        }

        if (hexCode[KIND_INDEX] != null) {
            switch (hexCode[KIND_INDEX]) {
                case 0 -> kind = null;
                case 1 -> kind = Kind.FIRST;
                case 2 -> kind = Kind.SECOND;
                case 0xF -> kind = Kind.N_A;
            }
        }

        if (hexCode[PLURAL_INDEX] != null) {
            switch (hexCode[PLURAL_INDEX]) {
                case 0 -> plural = null;
                case 1 -> plural = Plural.PLURAL;
                case 2 -> plural = Plural.SINGULAR;
                case 0xF -> plural = Plural.N_A;
            }
        }

        if (hexCode[TIME_INDEX] != null) {
            switch (hexCode[TIME_INDEX]) {
                case 0 -> time = null;
                case 1 -> time = Time.PAST;
                case 2 -> time = Time.PRESENT;
                case 3 -> time = Time.FUTURE;
            }
        }

        if (hexCode[TYPE_INDEX] != null) {
            switch (hexCode[TYPE_INDEX]) {
                case 0 -> type = null;
                case 1 -> type = Type.IMMUTABLE_ADJECTIVE;
                case 2 -> type = Type.MUTABLE_ADJECTIVE;
                case 3 -> type = Type.EXTENSIVE_ADVERB;
                case 4 -> type = Type.DEFINITE_ADVERB;
                case 5 -> type = Type.QUESTION_ADVERB;
                case 6 -> type = Type.ORDINAL_NUMERAL;
                case 7 -> type = Type.QUANTITATIVE_NUMERAL;
                case 8 -> type = Type.COLLECTIVE_NUMERAL;
                case 9 -> type = Type.INDEFINITE_NUMERAL;
            }
        }

        if (hexCode[WORD_CASE_INDEX] != null) {
            switch (hexCode[WORD_CASE_INDEX]) {
                case 0 -> wordCase = null;
                case 1 -> wordCase = WordCase.NOMINATIVE;
                case 2 -> wordCase = WordCase.GENITIVE;
                case 3 -> wordCase = WordCase.DATIVE;
                case 4 -> wordCase = WordCase.ACCUSATIVE;
                case 5 -> wordCase = WordCase.INSTRUMENTAL;
                case 6 -> wordCase = WordCase.PREPOSITIONAL;
                case 7 -> wordCase = WordCase.VOCATIVE;
                case 8 -> wordCase = WordCase.PARTITIVE;
                case 9 -> wordCase = WordCase.LOCATIVE;
                case 0xA -> wordCase = WordCase.COUNTING;
                case 0xF -> wordCase = WordCase.N_A;
            }
        }

        if (hexCode[COMPARATIVE_INDEX] != null) {
            switch (hexCode[COMPARATIVE_INDEX]) {
                case 0 -> comparative = null;
                case 1 -> comparative = Comparative.COMPARATIVE;
                case 2 -> comparative = Comparative.SUPER;
                case 0xF -> comparative = Comparative.N_A;
            }
        }

        if (hexCode[FACE_INDEX] != null) {
            switch (hexCode[FACE_INDEX]) {
                case 0 -> face = null;
                case 1 -> face = Face.FIRST;
                case 2 -> face = Face.SECOND;
                case 3 -> face = Face.THIRD;
                case 4 -> face = Face.ANONYMOUS;

            }
        }

        if (hexCode[INFINITIVE_INDEX] != null) {
            switch (hexCode[INFINITIVE_INDEX]) {
                case 0 -> infinitive = null;
                case 1 -> infinitive = Infinitive.INFINITIVE;
                case 2 -> infinitive = Infinitive.NOT;
                case 0xF -> infinitive = Infinitive.N_A;
            }
        }

        if (hexCode[PERFECT_INDEX] != null) {
            switch (hexCode[PERFECT_INDEX]) {
                case 0 -> perfect = null;
                case 1 -> perfect = Perfect.PERFECT;
                case 2 -> perfect = Perfect.NOT_PERFECT;
                case 3 -> perfect = Perfect.N_A;
            }
        }

        if (hexCode[REFLEXIVE_INDEX] != null) {
            switch (hexCode[REFLEXIVE_INDEX]) {
                case 0 -> reflexive = null;
                case 1 -> reflexive = Reflexive.REFLEXIVE;
                case 2 -> reflexive = Reflexive.NOT_REFLEXIVE;
                case 0xF -> reflexive = Reflexive.N_A;
            }
        }

        if (hexCode[SHORT_FORM_INDEX] != null) {
            switch (hexCode[SHORT_FORM_INDEX]) {
                case 0 -> shortF = null;
                case 1 -> shortF = ShortF.SHORT;
                case 2 -> shortF = ShortF.NOT_SHORT;
            }
        }

        if (hexCode[TRANSITIVE_INDEX] != null) {
            switch (hexCode[TRANSITIVE_INDEX]) {
                case 0 -> transitive = null;
                case 1 -> transitive = Transitive.TRANSITIVE;
                case 2 -> transitive = Transitive.INTRANSITIVE;
                case 3 -> transitive = Transitive.TRANS_INTRANS;
            }
        }

        if (hexCode[VOICE_INDEX] != null) {
            switch (hexCode[VOICE_INDEX]) {
                case 0 -> voice = null;
                case 1 -> voice = Voice.ACTIVE;
                case 2 -> voice = Voice.PASSIVE;
                case 0xF -> voice = Voice.N_A;
            }
        }
    }

    private String buildQuery(int lowID, int hiID) {
        StringBuilder hql = new StringBuilder();
        hql.append("FROM ")
                .append(partOfSpeech)
                .append(" WHERE")
                .append(" IID > ").append(lowID)
                .append(" AND")
                .append(" IID < ").append(hiID);

        if (shortF != null) {
            hql.append(" AND")
                    .append(" shortF = ")
                    .append("'")
                    .append(shortF)
                    .append("'");
        }

        if (plural != null) {
            hql.append(" AND")
                    .append(" plural = ")
                    .append("'")
                    .append(plural)
                    .append("'");
        }

        if (gender != null) {
            hql.append(" AND")
                    .append(" gender = ")
                    .append("'")
                    .append(gender)
                    .append("'");
        }

        if (type != null) {
            hql.append(" AND")
                    .append(" type = ")
                    .append("'")
                    .append(type)
                    .append("'");
        }

        if (wordCase != null) {
            hql.append(" AND")
                    .append(" wordCase = ")
                    .append("'")
                    .append(wordCase)
                    .append("'");
        }

        if (comparative != null) {
            hql.append(" AND")
                    .append(" comparative = ")
                    .append("'")
                    .append(comparative)
                    .append("'");
        }

        if (animate != null) {
            hql.append(" AND")
                    .append(" animate = ")
                    .append("'")
                    .append(animate)
                    .append("'");
        }

        if (adverbType != null) {
            hql.append(" AND")
                    .append(" adverbType = ")
                    .append("'")
                    .append(adverbType)
                    .append("'");
        }

        if (face != null) {
            hql.append(" AND")
                    .append(" face = ")
                    .append("'")
                    .append(face)
                    .append("'");
        }

        if (infinitive != null) {
            hql.append(" AND")
                    .append(" infinitive = ")
                    .append("'")
                    .append(infinitive)
                    .append("'");
        }

        if (kind != null) {
            hql.append(" AND")
                    .append(" kind = ")
                    .append("'")
                    .append(kind)
                    .append("'");
        }

        if (perfect != null) {
            hql.append(" AND")
                    .append(" perfect = ")
                    .append("'")
                    .append(perfect)
                    .append("'");
        }

        if (reflexive != null) {
            hql.append(" AND")
                    .append(" reflexive = ")
                    .append("'")
                    .append(reflexive)
                    .append("'");
        }

        if (time != null) {
            hql.append(" AND")
                    .append(" time = ")
                    .append("'")
                    .append(time)
                    .append("'");
        }

        if (transitive != null) {
            hql.append(" AND")
                    .append(" transitive = ")
                    .append("'")
                    .append(transitive)
                    .append("'");
        }

        if (voice != null) {
            hql.append(" AND")
                    .append(" voice = ")
                    .append("'")
                    .append(voice)
                    .append("'");
        }
        return hql.toString();
    }

    protected void init(Word word){
        this.word = word;
        switch (word.getPartOfSpeech()) {

            case ADJECTIVE:

                Adjective adjective = (Adjective) word;
                this.partOfSpeech = ADJECTIVE;
                this.comparative = adjective.getComparative();
                this.gender = adjective.getGender();
                this.plural = adjective.getPlural();
                this.shortF = adjective.getShortF();
                this.type = adjective.getType();
                this.wordCase = adjective.getWordCase();
                isPrimary = true;
                break;

            case ADVERB:

                Adverb adverb = (Adverb) word;
                this.partOfSpeech = ADVERB;
                this.type = adverb.getType();
                this.adverbType = adverb.getAdverbType();
                this.comparative = adverb.getComparative();
                isPrimary = true;
                break;

            case EXTRA_PARTICIPLE:

                ExtraParticiple extraParticiple = (ExtraParticiple) word;
                this.partOfSpeech = EXTRA_PARTICIPLE;
                this.transitive = extraParticiple.getTransitive();
                this.perfect = extraParticiple.getPerfect();
                this.time = extraParticiple.getTime();
                this.reflexive = extraParticiple.getReflexive();
                isPrimary = true;
                break;

            case NOUN:

                Noun noun = (Noun) word;
                this.partOfSpeech = NOUN;
                this.plural = noun.getPlural();
                this.gender = noun.getGender();
                this.wordCase = noun.getWordCase();
                this.animate = noun.getAnimate();
                isPrimary = true;
                break;

            case NUMERAL:

                Numeral numeral = (Numeral) word;
                this.partOfSpeech = NUMERAL;
                this.plural = numeral.getPlural();
                this.gender = numeral.getGender();
                this.wordCase = numeral.getWordCase();
                this.type = numeral.getType();
                isPrimary = false;
                break;

            case PARTICIPLE:

                Participle participle = (Participle) word;
                this.partOfSpeech = PARTICIPLE;
                this.gender = participle.getGender();
                this.kind = participle.getKind();
                this.plural = participle.getPlural();
                this.reflexive = participle.getReflexive();
                this.shortF = participle.getShortF();
                this.time = participle.getTime();
                this.transitive = participle.getTransitive();
                this.voice = participle.getVoice();
                this.wordCase = participle.getWordCase();
                isPrimary = true;
                break;

            case VERB:

                Verb verb = (Verb) word;
                this.partOfSpeech = VERB;
                this.face = verb.getFace();
                this.gender = verb.getGender();
                this.infinitive = verb.getInfinitive();
                this.kind = verb.getKind();
                this.perfect = verb.getPerfect();
                this.plural = verb.getPlural();
                this.reflexive = verb.getReflexive();
                this.time = verb.getTime();
                this.transitive = verb.getTransitive();
                this.voice = verb.getVoice();
                isPrimary = true;
                break;

            case PRETEXT:

                Pretext pretext = (Pretext) word;
                this.partOfSpeech = PRETEXT;
                this.wordCase = pretext.getWordCase();
                isPrimary = false;
                break;

            case PRONOUN:
            case PRON_ADJ:
            case PRON_ADV:
            case PRON_NOUN:

                Pronoun pronoun = (Pronoun) word;
                this.partOfSpeech = PRONOUN;
                this.wordCase = pronoun.getWordCase();
                this.gender = pronoun.getGender();
                this.plural = pronoun.getPlural();
                isPrimary = false;
                break;
        }
    }

    @SuppressWarnings("unchecked assignment")
    public void run() {

        final int NUMBER_OF_THREADS = 10;
        final int ONE_THREAD_INTERVAL = Word.getMaxID() / NUMBER_OF_THREADS;

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0, interval = 0, nextInterval = interval + ONE_THREAD_INTERVAL;
             i < NUMBER_OF_THREADS;
             i++, interval = nextInterval, nextInterval += ONE_THREAD_INTERVAL) {

            int finalInterval = interval;
            int finalNextInterval = nextInterval;

            executorService.submit(() -> {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery(buildQuery(finalInterval, finalNextInterval));
                wordsList.addAll(query.getResultList());
                session.close();
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getResultSet();
    }

    private boolean isCommon(Word word) {
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

    private void getResultSet() {  //подмешиваем частые слова в выборку для уменьшения "экзотичности" рандомизатора
        for (Word w : wordsList) {
            if (isCommon(w)) {
                resultSet.add(w);
            }
        }
    }

    public static Word get() {
        return Word.findById(new Random().nextInt(Word.getMaxID()));
    }

    public Word getSingleWord() {
        if (resultSet.size() > 0) {
            return resultSet.get(random.nextInt(resultSet.size() - 1));
        }
        return null;
    }

    public List<Word> getList() {
        return resultSet;
    }

}
