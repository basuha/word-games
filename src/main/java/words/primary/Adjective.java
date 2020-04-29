package words.primary;

import com.sun.istack.Nullable;
import words.Word;
import words.attributes.Gender;
import words.attributes.WCase;

import javax.persistence.*;
import java.util.List;

/**
 * Прилагательное
 */
@Entity
@DiscriminatorValue(utilities.Type.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short", nullable = false)
    private Boolean shortF;

    @Nullable
    @Column(name = "plural")
    private Boolean plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "type_sub")
    private String type;

    @Nullable
    @Column(name = "wcase")
    private String wCase;

    @Nullable
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
        MUTABLE (null);

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    /** Сравнительные формы прилагательного:
     * <li>{@link #COMPARATIVE} - сравнительная форма</li>
     * <li>{@link #SUPER} - превосходная форма</li>
     */
    public enum Comp {

        /** сравнительная форма */
        COMPARATIVE ("сравн"),

        /** превосходная форма*/
        SUPER ("прев");

        private final String value;

        Comp (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public Boolean getShortF() {
        return shortF;
    }

    public void setShortF(Boolean shortF) {
        this.shortF = shortF;
    }

    public Boolean getPlural() {
        return plural;
    }

    public void setPlural(Boolean plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == Gender.PLURAL_FORM) {
            this.gender = null;
            this.plural = true;
        } else {
            this.gender = gender.toString();
            this.plural = false;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(Type type) {
        if (type == Type.IMMUTABLE) {
            this.gender = null;
            this.plural = null;
            this.wCase = null;
            this.comp = null;
            this.shortF = false;
        } else {
            this.type = type.value;
        }
    }

    public String getwCase() {
        return wCase;
    }

    public void setwCase(WCase wCase) {
        this.wCase = wCase.toString();
    }

    public String getComp() {
        return comp;
    }

    public void setComp(Comp comp) {
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
