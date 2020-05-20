package utilities;

import org.hibernate.Session;
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

    public WRandom() {
    }

    public WRandom(Word word) {
        this.word = word;
        switch (word.getPartOfSpeech()) {

            case PartOfSpeech.ADJECTIVE:

                Adjective adjective = (Adjective) word;
                this.comparative = adjective.getComparative();
                this.gender = adjective.getGender();
                this.plural = adjective.getPlural();
                this.shortF = adjective.getShortF();
                this.type = adjective.getType();
                this.wordCase = adjective.getWordCase();
                isPrimary = true;
                break;

            case PartOfSpeech.ADVERB:

                Adverb adverb = (Adverb) word;
                this.type = adverb.getType();
                this.adverbType = adverb.getAdverbType();
                this.comparative = adverb.getComparative();
                isPrimary = true;
                break;

            case PartOfSpeech.EXTRA_PARTICIPLE:

                ExtraParticiple extraParticiple = (ExtraParticiple) word;
                this.transitive = extraParticiple.getTransitive();
                this.perfect = extraParticiple.getPerfect();
                this.time = extraParticiple.getTime();
                this.reflexive = extraParticiple.getReflexive();
                isPrimary = true;
                break;

            case PartOfSpeech.NOUN:

                Noun noun = (Noun) word;
                this.plural = noun.getPlural();
                this.gender = noun.getGender();
                this.wordCase = noun.getWordCase();
                this.animate = noun.getAnimate();
                isPrimary = true;
                break;

            case PartOfSpeech.NUMERAL:

                Numeral numeral = (Numeral) word;
                this.plural = numeral.getPlural();
                this.gender = numeral.getGender();
                this.wordCase = numeral.getWordCase();
                this.type = numeral.getType();
                isPrimary = false;
                break;

            case PartOfSpeech.PARTICIPLE:

                Participle participle = (Participle) word;
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

            case PartOfSpeech.VERB:

                Verb verb = (Verb) word;
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

            case PartOfSpeech.PRETEXT:

                Pretext pretext = (Pretext) word;
                this.wordCase = pretext.getWordCase();
                isPrimary = false;
                break;

            case PartOfSpeech.PRONOUN:
            case PartOfSpeech.PRON_ADJ:
            case PartOfSpeech.PRON_ADV:
            case PartOfSpeech.PRON_NOUN:

                Pronoun pronoun = (Pronoun) word;
                this.wordCase = pronoun.getWordCase();
                this.gender = pronoun.getGender();
                this.plural = pronoun.getPlural();
                isPrimary = false;
                break;
        }
        run();
    }

    private String buildQuery(int lowID, int hiID) {
        StringBuilder hql = new StringBuilder();
        hql.append("FROM ")
                .append(word.getPartOfSpeech())
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

    @SuppressWarnings("unchecked assignment")
    public void run() {

        final int NUMBER_OF_THREADS = 5;
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
            executorService.awaitTermination(1, TimeUnit.MINUTES);
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
