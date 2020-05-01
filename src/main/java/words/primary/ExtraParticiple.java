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

    {
        partOfSpeech = PartOfSpeech.EXTRA_PARTICIPLE;
    }

    @Column(name = "transitive")
    private String transitive;

    @Column(name = "perfect")
    private String perfect;

    @Column(name = "time")
    private String time;

    @Column(name = "reflexive")
    private String reflexive;

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

    public void setParam(Transitive transitive) {
        this.transitive = transitive.toString();
    }

    public void setParam(Perfect perfect) {
        this.perfect = perfect.toString();
    }

    public void setParam(Time.Participle time) {
        this.time = time.toString();
    }

    public void setParam(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
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
                "transit='" + transitive + '\'' +
                ", perfect=" + perfect +
                ", time='" + time + '\'' +
                ", reflexive=" + reflexive +
                '}';
    }
}
