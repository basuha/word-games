package words;

import words.primary.*;
import words.secondary.*;

import javax.persistence.*;
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
@DiscriminatorColumn(name = "type")
public abstract class Word {

    @Id
    @Column(name = "IID", nullable = false)
    protected Integer IID;

    @Column(name = "word", nullable = false)
    protected String word;

    @Column(name = "code", nullable = false)
    protected Integer code;

    @Column(name = "type", insertable = false, updatable = false, nullable = false)
    protected String type;

    @Column(name = "code_parent", nullable = false)
    protected Integer codeParent;

    @Transient
    protected List<Word> cognates = new ArrayList<>();

    public abstract void addCognate(Word cognate);
    public abstract List<Word> getCognates();

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

    public String getInfo() {
        return "Word{" +
                "IID=" + IID +
                ", word='" + word + '\'' +
                ", code=" + code +
                ", codeParent=" + codeParent +
                '}';
    }

    @Override
    public String toString() {
        return this.word;
    }
}
