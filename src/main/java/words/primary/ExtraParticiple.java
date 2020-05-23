package words.primary;

import utilities.PartOfSpeech;
import utilities.Word;
import words.attributes.secondary.Perfect;
import words.attributes.secondary.Reflexive;
import words.attributes.primary.Time;
import words.attributes.secondary.Transitive;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Деепричастие
 * Примеры: решив, передав, прочитав
 */
@Entity
@DiscriminatorValue(PartOfSpeech.EXTRA_PARTICIPLE)
public class ExtraParticiple extends Word {

    @Enumerated
    private Transitive transitive;

    @Enumerated
    private Perfect perfect;

    @Enumerated
    private Time time;

    @Enumerated
    private Reflexive reflexive;

    public ExtraParticiple() {
        partOfSpeech = EXTRA_PARTICIPLE;
        changeable = true;
    }

    public Transitive getTransitive() {
        return transitive;
    }

    public Perfect getPerfect() {
        return perfect;
    }

    public Time getTime() {
        return time;
    }

    public Reflexive getReflexive() {
        return reflexive;
    }

    public ExtraParticiple setTransitive(Transitive transitive) {
        this.transitive = transitive;
        return this;
    }

    public ExtraParticiple setPerfect(Perfect perfect) {
        this.perfect = perfect;
        return this;
    }

    public ExtraParticiple setTime(Time time) {
        this.time = time;
        return this;
    }

    public ExtraParticiple setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive;
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
