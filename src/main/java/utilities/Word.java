package utilities;

import org.hibernate.Session;
import words.attributes.primary.PartOfSpeech;
import words.primary.*;
import words.secondary.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Родительский класс всех частей речи
 * @see Adjective
 * @see Verb
 * @see Noun
 * @see Adverb
 * @see Participle
 * @see Particle
 * @see Parenthesis
 * @see Numeral
 * @see Interjection
 * @see ExtraParticiple
 * @see Pronoun
 * @see Pretext
 * @see Predicate
 * @see Conjunction
 */
@Entity
@Table(name = "words")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "partOfSpeech")
public class Word {

    @Transient public static final String ADJECTIVE = "Adjective";
    @Transient public static final String ADVERB = "Adverb";
    @Transient public static final String EXTRA_PARTICIPLE = "ExtraParticiple";
    @Transient public static final String NOUN = "Noun";
    @Transient public static final String NUMERAL = "Numeral";
    @Transient public static final String PARTICIPLE = "Participle";
    @Transient public static final String VERB = "Verb";

    @Transient public static final String CONJUNCTION = "Conjunction";
    @Transient public static final String INTERJECTION = "Interjection";
    @Transient public static final String PARENTHESIS = "Parenthesis";
    @Transient public static final String PARTICLE = "Particle";
    @Transient public static final String PREDICATE = "Predicate";
    @Transient public static final String PRETEXT = "Pretext";
    @Transient public static final String PRON_ADJ = "PronAdj";
    @Transient public static final String PRON_ADV = "PronAdv";
    @Transient public static final String PRON_NOUN = "PronNoun";
    @Transient public static final String PRONOUN = "Pronoun";

    @Id
    protected Integer IID;

    protected String word;
    protected Integer code;
    protected Integer codeParent;

    @Column(insertable = false, updatable = false, nullable = false)
    @Enumerated
    protected PartOfSpeech partOfSpeech;

    @Transient
    protected boolean changeable;

    @Transient
    protected static int MAX_ID;

    @Transient
    protected List<Word> cognates = new ArrayList<>();

    @Transient
    protected int hexCode;

    @Transient
    protected Field[] wAttributes;

    public Word() {
    }
//
//    public Word(String word) {
//        this.word = word;
//    }

    {
        wAttributes = this.getClass().getDeclaredFields();
        for (Field f : wAttributes)
            f.setAccessible(true);
    }

    public static int getMaxID() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //определение максимального ID в базе словаря
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("SELECT max(IID) FROM Word");
                MAX_ID = (Integer) query.getSingleResult();
                session.close();
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return MAX_ID;
    }

    public Integer getIID() {
        return IID;
    }

    public void setIID(Integer IID) {
        this.IID = IID;
    }

    public String getWord() {
        return word;
    }

    public Word setWord(String word) {
        this.word = word;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public Integer getCodeParent() {
        return codeParent;
    }

    public void setCodeParent(Integer codeParent) {
        this.codeParent = codeParent;
    }

    public boolean isChangeable() {
        return changeable;
    }

    public String getInfo() {
        return "Word{" +
                "IID=" + IID +
                ", word='" + word + '\'' +
                ", code=" + code +
                ", codeParent=" + codeParent +
                '}';
    }

    public List<Word> getCognates() {
        findCognates();
        return cognates;
    }

    private void findCognates() {

        if (cognates.isEmpty() && IID != null) {
            for (int i = 1; ; i++) {
                Word word = Word.findById(this.IID + i);
                if (word.getCodeParent() == 0) {
                    break;
                }
                cognates.add(word);
            }

            if (this.codeParent != 0) {
                for (int j = 1; ; j++) {
                    Word word = Word.findById(this.IID - j);
                    cognates.add(word);
                    if (word.getCodeParent() == 0) {
                        break;
                    }
                }
            }
        }
    }

    public static Word findById(Integer id) {
        final Word[] word = {new Word()};

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Session session = HibernateUtil.getSessionFactory().openSession();
                word[0] = session.get(Word.class, id);
                session.close();

            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return word[0];
    }

    public static List<Word> find(String word) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Word.class);
        Root<Word> root = cq.from(Word.class);
        cq.select(root).where(cb.like(root.get("word"), word));
        Query query = session.createQuery(cq);
        List<Word> wordList = query.getResultList();

        session.close();
        return wordList;
    }

    public BigDecimal getHexCode() {
        WordToHex wordToHex = new WordToHex(this);
        Thread thread = new Thread(wordToHex);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return wordToHex.getHexOut();
    }

    public Field[] getWAttributes() {
        return wAttributes;
    }

    @Override
    public String toString() {
         return this.word;
    }
}
