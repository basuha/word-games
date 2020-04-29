package words;

import com.sun.istack.Nullable;
import utilities.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Числительные
 */
@Entity
@DiscriminatorValue(Type.NUMERAL)
public class Numeral extends Word{

    @Column(name = "type_sub", nullable = false)
    private String type;

    @Nullable
    @Column(name = "plural")
    private Boolean plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Column(name = "wcase", nullable = false)
    private String wCase;

    /**
     * Подтип числительного:
     * <li>{@link #ORDINAL} - неизменяемое</li>
     * <li>{@link #QUANTITATIVE} - количественное</li>
     * <li>{@link #COLLECTIVE} - собирательное</li>
     * <li>{@link #INDEFINITE} - неопределенное</li>
     */
    public enum Type {

        /** порядковое */
        ORDINAL ("поряд"),

        /** количественное */
        QUANTITATIVE ("кол"),

        /** собирательное */
        COLLECTIVE ("собир"),

        /** неопределенное */
        INDEFINITE ("неопр");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Род числительного
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
     * Падеж числительного:
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

    @Override
    public String getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type.toString();
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

    public String getwCase() {
        return wCase;
    }

    public void setwCase(WCase wCase) {
        this.wCase = wCase.toString();
    }

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Numeral (Числительное) {" +
                "type='" + type + '\'' +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wCase + '\'' +
                '}';
    }
}
