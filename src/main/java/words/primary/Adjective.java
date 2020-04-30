package words.primary;

import com.sun.istack.Nullable;
import utilities.Type;
import words.Word;
import words.attributes.*;
import words.attributes.Short;

import javax.persistence.*;
import java.util.List;

/**
 * Прилагательное
 */
@Entity
@DiscriminatorValue(Type.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short")
    private String shortF;

    @Column(name = "plural")
    private String plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "type_sub")
    private String type;

    @Column(name = "wcase")
    private String wCase;

    @Column(name = "comp")
    private String comp;

    @Override
    public void addCognate(Word cognate) {
        this.cognates.add(cognate);
    }

    @Override
    public List<Word> getCognates() {
        return cognates;
    }


    /**
     * Подтип прилагательного:
     * <li>{@link #IMMUTABLE} - неизменяемое</li>
     * <li>{@link #MUTABLE} - изменяемое</li>
     */
    public enum Type {

        /** неизменяемое */
        IMMUTABLE ("неизм"),

        /** изменяемое */
        MUTABLE ("изм");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public String getShortF() {
        return shortF;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getwCase() {
        return wCase;
    }

    public String getComp() {
        return comp;
    }

    public void setParam(Short shortF) {
        this.shortF = shortF.toString();
    }

    public void setParam(Plural plural) {
        this.plural = plural.toString();
    }

    public void setParam(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = null; //TODO:this
            this.plural = "plural";
        } else {
            this.gender = gender.toString();
            this.plural = "singular";
        }
    }

    public void setParam(Type type) {
        if (type == Type.IMMUTABLE) {
            this.gender = "n/a";
            this.plural = "n/a";
            this.wCase = "n/a";
            this.comp = "n/a";
            this.shortF = "not_short";
        } else {
            this.type = type.toString();
        }
    }

    public void setParam(WCase wCase) {
        this.wCase = wCase.toString();
    }

    public void setParam(Comp comp) {
        this.comp = comp.toString();
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "{" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + type + '\'' +
                ", wCase='" + wCase + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}
