package words;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import utilities.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Деепричастие
 * Примеры: решив, передав, прочитав
 */
@Entity
@DiscriminatorValue(Type.EXTRA_PARTICIPLE)
public class ExtraParticiple extends Word{

    @Column(name = "transit", nullable = false)
    private String transit;

    @Column(name = "perfect", nullable = false)
    private Boolean perfect;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "vozv", nullable = false)
    private Boolean reflexive;

    /**
     * Признак переходности деепричастия
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
     * Признак времени деепричастия
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

    public String getTransit() {
        return transit;
    }

    public void setTransit(Transit transit) {
        this.transit = transit.toString();
    }

    public Boolean getPerfect() {
        return perfect;
    }

    public void setPerfect(Boolean perfect) {
        this.perfect = perfect;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time.toString();
    }

    public Boolean getReflexive() {
        return reflexive;
    }

    public void setReflexive(Boolean reflexive) {
        this.reflexive = reflexive;
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
        return super.getInfo()
                + " ExtraParticiple (Деепричастие) {" +
                "transit='" + transit + '\'' +
                ", perfect=" + perfect +
                ", time='" + time + '\'' +
                ", reflexive=" + reflexive +
                '}';
    }
}
