package words.primary;

import utilities.PartOfSpeech;
import words.Word;
import words.attributes.Perfect;
import words.attributes.Reflexive;
import words.attributes.Time;
import words.attributes.Transitive;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Деепричастие
 * Примеры: решив, передав, прочитав
 */
@Entity
@DiscriminatorValue(PartOfSpeech.EXTRA_PARTICIPLE)
public class ExtraParticiple extends Word {

    @Column(name = "transitive")
    private String transitive;

    @Column(name = "perfect")
    private String perfect;

    @Column(name = "time")
    private String time;

    @Column(name = "reflexive")
    private String reflexive;

    public ExtraParticiple() {
        partOfSpeech = PartOfSpeech.EXTRA_PARTICIPLE;
        changeable = true;
    }

    public String getTransitive() {
        return transitive;
    }

    public String getPerfect() {
        return perfect;
    }

    public String getTime() {
        return time;
    }

    public String getReflexive() {
        return reflexive;
    }

    public ExtraParticiple setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public ExtraParticiple setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public ExtraParticiple setTime(Time.Participle time) {
        this.time = time.toString();
        return this;
    }

    public ExtraParticiple setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }


    @Override
    public String getInfo() {
        return super.getInfo()
                + " ExtraParticiple (Деепричастие) {" +
                "transit='" + transitive + '\'' +
                ", perfect=" + perfect +
                ", time='" + time + '\'' +
                ", reflexive=" + reflexive +
                '}';
    }
}
