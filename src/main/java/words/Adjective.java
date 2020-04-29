package words;

import com.sun.istack.Nullable;
import org.antlr.v4.runtime.misc.NotNull;
import utilities.Type;

import javax.persistence.*;
import java.util.List;

//прилагательное
@Entity
@DiscriminatorValue(Type.ADJECTIVE)
public class Adjective extends Word {

//TODO: статический блок с зависимостями

    @Column(name = "short")
    private Boolean shortF;

    @Column(name = "plural")
    private Boolean plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "type_sub")
    private String subType;

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
    public enum SubType {

        /** неизменяемое */
        IMMUTABLE ("неизм"),

        /** изменяемое */
        MUTABLE (null);

        private final String value;

        SubType (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    /**
     * Род прилагательного
     * <li>{@link #MALE} - мужской</li>
     * <li>{@link #FEMALE} - женский</li>
     * <li>{@link #NEUTER} - средний</li>
     * <li>{@link #PLURAL_FORM} - множественная форма (без рода)</li>
     */
    public enum Gender {

        /** мужской */
        MALE ("муж"),

        /** женский */
        FEMALE ("жен"),

        /** средний */
        NEUTER ("ср"),

        /** множественная форма (без рода) */
        PLURAL_FORM (null);

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Падеж прилагательного:
     * <li>{@link #NOMINATIVE} - именитильный (кто?, что?)</li>
     * <li>{@link #GENITIVE} - родительный (кого?, чего?)</li>
     * <li>{@link #DATIVE} - дательный (кому?, чему?)</li>
     * <li>{@link #ACCUSATIVE} - винительный (кого?, что?)</li>
     * <li>{@link #INSTRUMENTAL} - творительный (кем?, чем?)</li>
     * <li>{@link #PREPOSITIONAL} - предложный (о ком?, о чем?)</li>
     */
    public enum WCase {

        /** именитильный (кто?, что?) */
        NOMINATIVE ("им"),

        /** родительный (кого?, чего?) */
        GENITIVE ("род"),

        /** дательный (кому?, чему?) */
        DATIVE ("дат"),

        /** винительный (кого?, что?) */
        ACCUSATIVE ("вин"),

        /** творительный (кем?, чем?) */
        INSTRUMENTAL ("тв"),

        /** предложный (о ком?, о чем?) */
        PREPOSITIONAL ("пр");

        private final String value;

        WCase (String value) {
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        if (subType == SubType.IMMUTABLE) {
            this.gender = null;
            this.plural = null;
            this.wCase = null;
            this.comp = null;
            this.shortF = false;
        } else {
            this.subType = subType.toString();
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
                ", subType='" + subType + '\'' +
                ", wCase='" + wCase + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}
