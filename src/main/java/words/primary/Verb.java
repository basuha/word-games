package words.primary;

import utilities.Word;
import words.attributes.primary.Gender;
import words.attributes.primary.Kind;
import words.attributes.primary.Plural;
import words.attributes.primary.Time;
import words.attributes.secondary.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(Word.VERB)
public class Verb extends Word {

    @Enumerated
    private Infinitive infinitive;

    @Enumerated
    private Reflexive reflexive;

    @Enumerated
    private Transitive transitive;

    @Enumerated
    private Plural plural;

    @Enumerated
    private Gender gender;

    @Enumerated
    private Perfect perfect;

    @Enumerated
    private Face face;

    @Enumerated
    private Kind kind;

    @Enumerated
    private Time time;

    @Enumerated
    private Voice voice;

    public Verb() {
        partOfSpeech = PARTICIPLE;
        changeable = true;
    }

    public Plural getPlural() {
        return plural;
    }

    public Gender getGender() {
        return gender;
    }

    public Transitive getTransitive() {
        return transitive;
    }

    public Perfect getPerfect() {
        return perfect;
    }

    public Face getFace() {
        return face;
    }

    public Kind getKind() {
        return kind;
    }

    public Time getTime() {
        return time;
    }

    public Infinitive getInfinitive() {
        return infinitive;
    }

    public Reflexive getReflexive() {
        return reflexive;
    }

    public Voice getVoice() {
        return voice;
    }


    public Verb setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Verb setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Verb setTransitive(Transitive transitive) {
        this.transitive = transitive;
        return this;
    }

    public Verb setPerfect(Perfect perfect) {
        this.perfect = perfect;
        return this;
    }

    public Verb setFace(Face face) {
        this.face = face;
        return this;
    }

    public Verb setKind(Kind kind) {
        this.kind = kind;
        return this;
    }

    public Verb setTime(Time time) {
        this.time = time;
        return this;
    }

    public Verb setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive;
        return this;
    }

    public Verb setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive;
        return this;
    }

    public Verb setVoice(Voice voice) {
        this.voice = voice;
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
