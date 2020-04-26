package Words;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "words_test")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Word {

    @Id
    protected Integer IID;

    @Column
    protected String word;

    @Column
    protected Integer code;

    @Column(name = "type", insertable = false, updatable = false)
    protected String type;

    @Column(name = "code_parent")
    protected Integer codeParent;

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
