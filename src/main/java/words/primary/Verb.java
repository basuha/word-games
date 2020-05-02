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

    {
        partOfSpeech = PartOfSpeech.VERB;
    }

    @Column (name = "infinitive")
    private String infinitive;

    @Column (name = "reflexive")
    private String reflexive;

    @Column (name = "transitive")
    private String transitive;

    @Column (name = "plural")
    private String plural;

    @Column (name = "gender")
    private String gender;

    @Column (name = "perfect")
    private String perfect;

    @Column (name = "face")
    private String face;

    @Column (name = "kind")
    private String kind;

    @Column (name = "time")
    private String time;

    @Column (name = "voice")
    private String voice;


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


    public Verb setParam(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Verb setParam(Gender gender) {
        this.gender = gender.toString();
        return this;
    }

    public Verb setParam(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public Verb setParam(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public Verb setParam(String face) {
        this.face = face;
        return this;
    }

    public Verb setParam(Kind kind) {
        this.kind = kind.toString();
        return this;
    }

    public Verb setParam(Time time) {
        this.time = time.toString();
        return this;
    }

    public Verb setParam(Infinitive infinitive) {
        this.infinitive = infinitive.toString();
        return this;
    }

    public Verb setParam(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }

    public Verb setParam(Voice voice) {
        this.voice = voice.toString();
        return this;
    }


    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
