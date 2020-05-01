package utilities;

import org.hibernate.Session;
import words.Word;
import words.primary.*;
import words.secondary.Pretext;
import words.secondary.Pronoun;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {

    private String adverbType;
    private String animate;
    private String comparative;
    private String face;
    private String gender;
    private String infinitive;
    private String kind;
    private String perfect;
    private String plural;
    private String reflexive;
    private String shortF;
    private String time;
    private String transitive;
    private String type;
    private String voice;
    private String wordCase;

    private Word word;
    private Random random = new Random();
    private List<Word> wordsList = new ArrayList<>();
    private List<Word> resultSet = new ArrayList<>();

    /** максимальное кол-во слов в выборке из БД */
    private final int MAX_RESULTS = 10000;

    /**
     * коэфицент определения корня слова (>1.0)
     * 1.0 = все слово корень
     * 2.0 = половина слова корень
     */
    private final double ROOT_DETECT_COEF = 1.1;

    /**
     * коэфицент подмешивания редких слов (0.0 - 1.0)
     * 0.0 = все слова редкие
     * 1.0 = все слова частые
     */
    private final double COMMON_WORDS_COEF = 1;

    /** частоупотребимые слова из файла */
    private static ArrayList<String> commonWords = new ArrayList<>();

    /** имя файла с частыми словами */
    private static final String COMMON_WORDS_FILE = "rusCommonWords.txt";

    /** максимальный ID в базе */
    private static final int MAX_ID;

    /** имя основной таблицы */
    private static final String TABLE = "words_test";

    private boolean IS_PRIMARY;

    static {
        //определение максимального ID в базе словаря
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT max(IID) FROM " + TABLE);
        MAX_ID = (Integer) query.getSingleResult();
        session.close();

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

    public RandomWord(Word word) {
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
                IS_PRIMARY = true;
                break;

            case PartOfSpeech.ADVERB:

                Adverb adverb = (Adverb) word;
                this.type = adverb.getType();
                this.adverbType = adverb.getAdverbType();
                this.comparative = adverb.getComparative();
                IS_PRIMARY = true;
                break;

            case PartOfSpeech.EXTRA_PARTICIPLE:

                ExtraParticiple extraParticiple = (ExtraParticiple) word;
                this.transitive = extraParticiple.getTransitive();
                this.perfect = extraParticiple.getPerfect();
                this.time = extraParticiple.getTime();
                this.reflexive = extraParticiple.getReflexive();
                IS_PRIMARY = true;
                break;

            case PartOfSpeech.NOUN:

                Noun noun = (Noun) word;
                this.plural = noun.getPlural();
                this.gender = noun.getGender();
                this.wordCase = noun.getWordCase();
                this.animate = noun.getAnimate();
                IS_PRIMARY = true;
                break;

            case PartOfSpeech.NUMERAL:

                Numeral numeral = (Numeral) word;
                this.plural = numeral.getPlural();
                this.gender = numeral.getGender();
                this.wordCase = numeral.getWordCase();
                this.type = numeral.getType();
                IS_PRIMARY = false;
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
                IS_PRIMARY = true;
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
                IS_PRIMARY = true;
                break;

            case PartOfSpeech.PRETEXT:

                Pretext pretext = (Pretext) word;
                this.wordCase = pretext.getWordCase();
                IS_PRIMARY = false;
                break;

            case PartOfSpeech.PRONOUN:
            case PartOfSpeech.PRON_ADJ:
            case PartOfSpeech.PRON_ADV:
            case PartOfSpeech.PRON_NOUN:

                Pronoun pronoun = (Pronoun) word;
                this.wordCase = pronoun.getWordCase();
                this.gender = pronoun.getGender();
                this.plural = pronoun.getPlural();
                IS_PRIMARY = false;
                break;
        }
        this.wordsList = getRandomWords();
    }

    @SuppressWarnings("unchecked assignment")
    private List<Word> getRandomWords() {

        StringBuilder hql = new StringBuilder();
        int attribCount = 0;
        hql.append("FROM ")
                .append(word.getPartOfSpeech())
                .append(" WHERE")
                .append(" IID > ")
                .append(random.nextInt(MAX_ID))
                .append(" AND ");

        if (shortF != null) {
            hql.append(" short = ")
                    .append("'").append(shortF).append("'");
            attribCount++;
        }

        if (plural != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" plural = ").append("'").append(plural).append("'");
            attribCount++;
        }

        if (gender != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" gender = ").append("'").append(gender).append("'");
            attribCount++;
        }

        if (type != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" type = ").append("'").append(type).append("'");
            attribCount++;
        }

        if (wordCase != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" word_case = ").append("'").append(wordCase).append("'");
            attribCount++;
        }

        if (comparative != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" comparative = ").append("'").append(comparative).append("'");
            attribCount++;
        }

        if (animate != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" animate = ").append("'").append(animate).append("'");
            attribCount++;
        }

        if (adverbType != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" adverb_type = ").append("'").append(adverbType).append("'");
            attribCount++;
        }

        if (face != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" face = ").append("'").append(face).append("'");
            attribCount++;
        }

        if (infinitive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" infinitive = ").append("'").append(infinitive).append("'");
            attribCount++;
        }

        if (kind != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" kind = ").append("'").append(kind).append("'");
            attribCount++;
        }

        if (perfect != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" perfect = ").append("'").append(perfect).append("'");
            attribCount++;
        }

        if (reflexive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" reflexive = ").append("'").append(reflexive).append("'");
            attribCount++;
        }

        if (time != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" time = ").append("'").append(time).append("'");
            attribCount++;
        }

        if (transitive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" transitive = ").append("'").append(transitive).append("'");
            attribCount++;
        }

        if (voice != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" voice = ").append("'").append(voice).append("'");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        wordsList = session
                .createQuery(hql.toString())
//                .setMaxResults(MAX_RESULTS)
                .getResultList();
        session.close();

        getResultSet();
        return wordsList;
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

    public Word get() {
        return resultSet.get(random.nextInt(resultSet.size() - 1));
    }

    public List<Word> getList() {
        return resultSet;
    }
}
