package words.primary;

import utilities.PartOfSpeech;
import words.Word;
import words.attributes.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(PartOfSpeech.VERB)
public class Verb extends Word {
    private String infinitive;
    private String reflexive;
    private String transitive;
    private String plural;
    private String gender;
    private String perfect;
    private String face;
    private String kind;
    private String time;
    private String voice;

    public Verb() {
        partOfSpeech = PartOfSpeech.PARTICIPLE;
        changeable = true;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public String getTransitive() {
        return transitive;
    }

    public String getPerfect() {
        return perfect;
    }

    public String getFace() {
        return face;
    }

    public String getKind() {
        return kind;
    }

    public String getTime() {
        return time;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public String getReflexive() {
        return reflexive;
    }

    public String getVoice() {
        return voice;
    }


    public Verb setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Verb setGender(Gender gender) {
        this.gender = gender.toString();
        return this;
    }

    public Verb setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public Verb setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public Verb setFace(Face face) {
        this.face = face.toString();
        return this;
    }

    public Verb setKind(Kind kind) {
        this.kind = kind.toString();
        return this;
    }

    public Verb setTime(Time time) {
        this.time = time.toString();
        return this;
    }

    public Verb setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive.toString();
        return this;
    }

    public Verb setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }

    public Verb setVoice(Voice voice) {
        this.voice = voice.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Verb(Глагол){" +
                "infinitive='" + infinitive + '\'' +
                ", reflexive='" + reflexive + '\'' +
                ", transitive='" + transitive + '\'' +
                ", plural='" + plural + '\'' +
                ", gender='" + gender + '\'' +
                ", perfect='" + perfect + '\'' +
                ", face='" + face + '\'' +
                ", kind='" + kind + '\'' +
                ", time='" + time + '\'' +
                ", voice='" + voice + '\'' +
                '}';
    }
}
