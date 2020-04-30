package words.primary;

import utilities.Type;
import words.Word;
import words.attributes.Gender;
import words.attributes.Time;
import words.attributes.Transit;
import words.attributes.WCase;

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
        this.transit = transit.toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(Time.Participle time) {
        this.time = time.toString();
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
        if (gender == Gender.N_A) {
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
