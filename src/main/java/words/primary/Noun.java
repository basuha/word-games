package words.primary;

import com.sun.istack.Nullable;
import utilities.Type;
import words.Word;

import javax.persistence.*;
import java.util.List;

/**
 * Существительное
 */
@Entity
@DiscriminatorValue(Type.NOUN)
public class Noun extends Word {

    @Column (name = "plural", nullable = false)
    private Boolean plural;

    @Nullable
    @Column (name = "gender")
    private String gender;

    @Nullable
    @Column (name = "wcase")
    private String wCase;

    @Nullable
    @Column (name = "soul")
    private Boolean soul;

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    /**
     * Род существительного
     * <li>{@link #MALE} - мужской</li>
     * <li>{@link #FEMALE} - женский</li>
     * <li>{@link #NEUTER} - средний</li>
     * <li>{@link #COMMON} - общий</li>
     * <li>{@link #PLURAL_FORM} - множественная форма (без рода)</li>
     */
    public enum Gender {

        /** мужской */
        MALE ("муж"),

        /** женский */
        FEMALE ("жен"),

        /** средний */
        NEUTER ("ср"),

        /** общий */
        COMMON ("общ"),

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
     * Падеж существительного:
     * <li>{@link #NOMINATIVE} - именитильный (кто?, что?)</li>
     * <li>{@link #GENITIVE} - родительный (кого?, чего?)</li>
     * <li>{@link #DATIVE} - дательный (кому?, чему?)</li>
     * <li>{@link #ACCUSATIVE} - винительный (кого?, что?)</li>
     * <li>{@link #INSTRUMENTAL} - творительный (кем?, чем?)</li>
     * <li>{@link #PREPOSITIONAL} - предложный (о ком?, о чем?)</li>
     * <li>{@link #VOCATIVE} - звательный </li>
     * <li>{@link #PARTITIVE} - частичный </li>
     * <li>{@link #LOCATIVE} - локатив </li>
     * <li>{@link #COUNTING} - счетный </li>
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
        PREPOSITIONAL ("пр"),

        /** звательный */
        VOCATIVE ("зват"),

        /** частичный */
        PARTITIVE ("парт"),

        /** локатив */
        LOCATIVE ("мест"),

        /** счетный */
        COUNTING ("счет");

        private final String value;

        WCase (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
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

    public Boolean getSoul() {
        return soul;
    }

    public void setSoul(Boolean soul) {
        this.soul = soul;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Noun (Существительное) {" +
                "plural=" + plural +
                ", gender=" + gender +
                ", wCase='" + wCase + '\'' +
                ", soul=" + soul +
                '}';
    }
}
