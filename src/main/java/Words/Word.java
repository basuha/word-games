package Words;

import org.hibernate.Session;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "words_test")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Word extends HibernateUtil {

    @Id
    protected Integer IID;

    @Column(name = "word")
    protected String word;

    @Column(name = "code")
    protected Integer code;

    @Column(name = "type", insertable = false, updatable = false)
    protected String type;

    @Column(name = "code_parent")
    protected Integer codeParent;

//    public void reload() {
//        Session session = getSessionFactory().openSession();
//        String hql = "FROM Word WHERE code = :c and codeParent = :cp";
//        Query query = session.createQuery(hql);
//        query.setParameter("c", this.code);
//        query.setParameter("cp", this.codeParent);
//        Word word = (Word) query.getSingleResult();
//        this.word = word.getWord();
//        session.close();
//    }

    public Integer getIID() {
        return IID;
    }

    public void setIID(Integer IID) {
        this.IID = IID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCodeParent() {
        return codeParent;
    }

    public void setCodeParent(Integer codeParent) {
        this.codeParent = codeParent;
    }

    @Override
    public String toString() {
        return "Word{" +
                "IID=" + IID +
                ", word='" + word + '\'' +
                ", code=" + code +
                ", type='" + type + '\'' +
                ", codeParent=" + codeParent +
                '}';
    }
}