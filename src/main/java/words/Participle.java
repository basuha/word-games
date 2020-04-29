package words;

import utilities.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Причастие
 */
@Entity
@DiscriminatorValue(Type.PARTICIPLE)
public class Participle extends Word {

    @Column (name = "plural", nullable = false)
    private Boolean plural;

    @Column (name = "transit", nullable = false)
    private String transit;

    @Column (name = "time", nullable = false)
    private String time;

    @Column (name = "vozv", nullable = false)
    private Boolean reflexive;

    @Column (name = "gender")
    private String gender;

    @Column (name = "wcase")
    private String wCase;

    @Column (name = "perfect")
    private Boolean perfect;

    @Column (name = "kind")
    private String kind;

    @Column (name = "nakl")
    private String passiveVoice;

    @Column (name = "short")
    private Boolean shortF;

    /**
     * Род причастия
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
     * Падеж причастия:
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

    /**
     * Признак переходности причастия
     */
    public enum Transit {

        TRANSITIVE ("перех"),
        INTRANSITIVE ("непер"),
        TRANS_INTRANS ("пер/не");

        private final String value;

        Transit(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Вид причастия
     * Второй или NULL
     */
    public enum Kind {

        SECOND ("2вид"),
        NULL(null); //TODO уточнить название

        private final String value;

        Kind (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Признак времени причастия
     */
    public enum Time {

        PAST("прош"),
        PRESENT("наст");

        private final String value;

        Time(String value) {
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

    public String getTransit() {
        return transit;
    }

    public void setTransit(Transit transit) {
        this.transit = transit.value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time.value;
    }

    public Boolean getReflexive() {
        return reflexive;
    }

    public void setReflexive(Boolean reflexive) {
        this.reflexive = reflexive;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == Gender.PLURAL_FORM) {
            this.gender = null;
            this.plural = true;
        } else {
            this.gender = gender.value;
            this.plural = false;
        }
    }


    public String getwCase() {
        return wCase;
    }

    public void setwCase(WCase wCase) {
        this.wCase = wCase.value;
    }

    public Boolean getPerfect() {
        return perfect;
    }

    public void setPerfect(Boolean perfect) {
        this.perfect = perfect;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind.value;
    }

    public Boolean getPassiveVoice() {
        return passiveVoice.equals("страд");
    }

    public void setPassiveVoice(Boolean passiveVoice) {
        if (passiveVoice) {
            this.passiveVoice = "страд";
        } else {
            this.passiveVoice = null;
        }
    }

    public Boolean getShortF() {
        return shortF;
    }

    public void setShortF(Boolean shortF) {
        this.shortF = shortF;
    }

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
