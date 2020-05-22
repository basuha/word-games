package utilities;

import org.hibernate.Session;
import words.attributes.*;
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
    private final Byte[] hexCode = new Byte[14];

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

    private void hexInit() {
        switch (hexCode[0]){
            case 0:
                setPartOfSpeech(null);
                break;
            case 1:
                setPartOfSpeech(ADJECTIVE);
                break;
            case 2:
                setPartOfSpeech(ADVERB);
                break;
            case 3:
                setPartOfSpeech(EXTRA_PARTICIPLE);
                break;
            case 4:
                setPartOfSpeech(NOUN);
                break;
            case 5:
                setPartOfSpeech(NUMERAL);
                break;
            case 6:
                setPartOfSpeech(PARTICIPLE);
                break;
            case 7:
                setPartOfSpeech(VERB);
                break;
            case 8:
                setPartOfSpeech(CONJUNCTION);
                break;
            case 9:
                setPartOfSpeech(INTERJECTION);
                break;
            case 0xA:
                setPartOfSpeech(PARENTHESIS);
                break;
            case 0xB:
                setPartOfSpeech(PARTICLE);
                break;
            case 0xC:
                setPartOfSpeech(PREDICATE);
                break;
            case 0xD:
                setPartOfSpeech(PRETEXT);
                break;
            case 0xE:
                setPartOfSpeech(PRONOUN);
                break;
        }

        if (hexCode[1] != null) {
            switch (hexCode[1]) {
                case 0:
                    wordCase = null;
                    break;
                case 1:
                    setWordCase(WordCase.NOMINATIVE);
                    break;
                case 2:
                    setWordCase(WordCase.GENITIVE);
                    break;
                case 3:
                    setWordCase(WordCase.DATIVE);
                    break;
                case 4:
                    setWordCase(WordCase.ACCUSATIVE);
                    break;
                case 5:
                    setWordCase(WordCase.INSTRUMENTAL);
                    break;
                case 6:
                    setWordCase(WordCase.PREPOSITIONAL);
                    break;
                case 7:
                    setWordCase(WordCase.VOCATIVE);
                    break;
                case 8:
                    setWordCase(WordCase.PARTITIVE);
                    break;
                case 9:
                    setWordCase(WordCase.LOCATIVE);
                    break;
                case 0xA:
                    setWordCase(WordCase.COUNTING);
                    break;
                case 0xF:
                    setWordCase(WordCase.N_A);
                    break;

            }
        }
        if (hexCode[2] != null) {
            switch (hexCode[2]) {
                case 0:
                    gender = null;
                    break;
                case 1:
                    setGender(Gender.MALE);
                    break;
                case 2:
                    setGender(Gender.FEMALE);
                    break;
                case 3:
                    setGender(Gender.NEUTER);
                    break;
                case 4:
                    setGender(Gender.COMMON);
                    break;
                case 0xF:
                    setGender(Gender.N_A);
                    break;
            }
        }
        if (hexCode[3] != null) {
            switch (hexCode[3]) {
                case 0:
                    plural = null;
                    break;
                case 1:
                    setPlural(Plural.PLURAL);
                    break;
                case 2:
                    setPlural(Plural.SINGULAR);
                    break;
                case 0xF:
                    setPlural(Plural.N_A);
                    break;

            }
        }
        if (hexCode[4] != null) {
            switch (hexCode[4]) {
                case 0:
                    type = null;
                    break;
            }
            switch (partOfSpeech) {
                case ADJECTIVE:
                    switch (hexCode[4]) {
                        case 1:
                            setType(Type.Adjective.IMMUTABLE);
                            break;
                        case 2:
                            setType(Type.Adjective.MUTABLE);
                            break;
                    }
                    break;
                case ADVERB:
                    switch (hexCode[4]) {
                        case 1:
                            setType(Type.Adverb.EXTENSIVE);
                            break;
                        case 2:
                            setType(Type.Adverb.DEFINITE);
                            break;
                        case 3:
                            setType(Type.Adverb.QUESTION);
                            break;
                    }
                    break;
                case NUMERAL:
                    switch (hexCode[4]) {
                        case 1:
                            setType(Type.Numeral.ORDINAL);
                            break;
                        case 2:
                            setType(Type.Numeral.QUANTITATIVE);
                            break;
                        case 3:
                            setType(Type.Numeral.COLLECTIVE);
                            break;
                        case 4:
                            setType(Type.Numeral.INDEFINITE);
                            break;
                    }
                    break;
            }
        }
        if (hexCode[5] != null) {
            switch (hexCode[5]) {
                case 0:
                    time = null;
                    break;
                case 1:
                    setTime(Time.PAST);
                    break;
                case 2:
                    setTime(Time.PRESENT);
                    break;
                case 3:
                    setTime(Time.FUTURE);
                    break;
            }
        }
        if (hexCode[6] != null) {
            switch (hexCode[6]) {
                case 0:
                    adverbType = null;
                    break;
                case 1:
                    setAdverbType(AdverbType.QUALITATIVE);
                    break;
                case 2:
                    setAdverbType(AdverbType.METHOD);
                    break;
                case 3:
                    setAdverbType(AdverbType.EXTENT);
                    break;
                case 4:
                    setAdverbType(AdverbType.PLACE);
                    break;
                case 5:
                    setAdverbType(AdverbType.DIRECTION);
                    break;
                case 6:
                    setAdverbType(AdverbType.TIMING);
                    break;
                case 7:
                    setAdverbType(AdverbType.PURPOSE);
                    break;
                case 8:
                    setAdverbType(AdverbType.REASON);
                    break;
            }
        }
        if (hexCode[7] != null) {
            switch (hexCode[7]) {
                case 0:
                    transitive = null;
                    break;
                case 1:
                    setTransitive(Transitive.TRANSITIVE);
                    break;
                case 2:
                    setTransitive(Transitive.INTRANSITIVE);
                    break;
                case 3:
                    setTransitive(Transitive.TRANS_INTRANS);
                    break;
            }
        }
        if (hexCode[8] != null) {
            switch (hexCode[8]) {
                case 0:
                    animate = null;
                    break;
                case 1:
                    setAnimate(Animate.ANIMATE);
                    break;
                case 2:
                    setAnimate(Animate.INANIMATE);
                    break;
                case 0xF:
                    setAnimate(Animate.N_A);
                    break;
            }
        }
        if (hexCode[9] != null) {
            switch (hexCode[9]) {
                case 0:
                    voice = null;
                    break;
                case 1:
                    setVoice(Voice.ACTIVE);
                    break;
                case 2:
                    setVoice(Voice.PASSIVE);
                    break;
                case 0xF:
                    voice = "n/a";
                    break;
            }
        }
        if (hexCode[10] != null) {
            switch (hexCode[10]) {
                case 0:
                    perfect = null;
                    break;
                case 1:
                    setPerfect(Perfect.PERFECT);
                    break;
                case 2:
                    setPerfect(Perfect.NOT_PERFECT);
                    break;
                case 3:
                    setPerfect(Perfect.N_A);
                    break;
            }
        }
        if (hexCode[11] != null) {
            switch (hexCode[11]) {
                case 0:
                    kind = null;
                    break;
                case 1:
                    setKind(Kind.FIRST);
                    break;
                case 2:
                    setKind(Kind.SECOND);
                    break;
                case 0xF:
                    kind = "n/a";
                    break;
            }
        }
        if (hexCode[12] != null) {
            switch (hexCode[12]) {
                case 0:
                    comparative = null;
                    break;
                case 1:
                    setComparative(Comparative.COMPARATIVE);
                    break;
                case 2:
                    setComparative(Comparative.SUPER);
                    break;
                case 0xF:
                    setComparative(Comparative.N_A);
                    break;
            }
        }
        if (hexCode[13] != null) {
            switch (hexCode[13]) {
                case 0:
                    infinitive = null;
                    break;
                case 1:
                    setInfinitive(Infinitive.INFINITIVE);
                    break;
                case 2:
                    setInfinitive(Infinitive.NOT);
                    break;
                case 0xF:
                    setInfinitive(Infinitive.N_A);
                    break;
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

    private void init(Word word){
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
