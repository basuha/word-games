package words;

import org.hibernate.Session;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import utilities.HibernateUtil;
import words.primary.*;
import words.secondary.*;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "words_test")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "part_of_speech")
public class Word implements Serializable {

    @Transient
    protected boolean changeable;

    @Id
    @Column(name = "IID", nullable = false)
    protected Integer IID;

    @Column(name = "word", nullable = false)
    protected String word;

    @Column(name = "code", nullable = false)
    protected Integer code;

    @Column(name = "part_of_speech", insertable = false, updatable = false, nullable = false)
    protected String partOfSpeech;

    @Column(name = "code_parent", nullable = false)
    protected Integer codeParent;

    @Transient
    protected List<Word> cognates = new ArrayList<>();

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

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
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
        if (cognates.isEmpty()) {
            findCognates();
        }
        return cognates;
    }

    private void findCognates() {
        for (int i = 1;;i++) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Word WHERE IID = :IID");
            query.setParameter("IID", this.IID + i);
            Word word = (Word) query.getSingleResult();
            session.close();
            if (word.getCodeParent() == 0) {
                break;
            }
            cognates.add(word);
        }

        if (this.codeParent != 0) {
            for (int j = 1;;j++) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("FROM Word WHERE IID = :IID");
                query.setParameter("IID", this.IID - j);
                Word word = (Word) query.getSingleResult();
                session.close();
                if (word.getCodeParent() == 0) {
                    cognates.add(word);
                    break;
                }
                cognates.add(word);
            }
        }
    }

    public static Word findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Word word = session.get(Word.class, id);
        session.close();
        return word;
    }

    @Override
    public String toString() {
         return this.word;
    }
}
