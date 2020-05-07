package words.primary;

import utilities.PartOfSpeech;
import words.Word;
import words.attributes.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.lang.Short;
import java.util.List;

/**
 * Причастие
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PARTICIPLE)
public class Participle extends Word {

    @Column (name = "plural")
    private String plural;

    @Column (name = "transitive")
    private String transitive;

    @Column (name = "time")
    private String time;

    @Column (name = "reflexive")
    private String reflexive;

    @Column (name = "gender")
    private String gender;

    @Column (name = "word_case")
    private String wordCase;

    @Column (name = "perfect")
    private String perfect;

    @Column (name = "kind")
    private String kind;

    @Column (name = "voice")
    private String voice;

    @Column (name = "short")
    private String shortF;

    public Participle() {
        partOfSpeech = PartOfSpeech.PARTICIPLE;
        changeable = true;
    }

    public String getPlural() {
        return plural;
    }

    public String getTransitive() {
        return transitive;
    }

    public String getTime() {
        return time;
    }

    public String getReflexive() {
        return reflexive;
    }

    public String getGender() {
        return gender;
    }

    public String getWordCase() {
        return wordCase;
    }

    public String getPerfect() {
        return perfect;
    }

    public String getKind() {
        return kind;
    }

    public String getVoice() {
        return voice;
    }

    public String getShortF() {
        return shortF;
    }


    public Participle setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Participle setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
        return this;
    }

    public Participle setTime(Time.Participle time) {
        this.time = time.toString();
        return this;
    }

    public Participle setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
        return this;
    }

    public Participle setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender.toString();
            this.plural = Plural.PLURAL.toString();
        } else {
            this.gender = gender.toString();
            this.plural = Plural.SINGULAR.toString();
        }
        return this;
    }

    public Participle setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    public Participle setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
        return this;
    }

    public Participle setKind(Kind.Participle kind) {
        this.kind = kind.toString();
        return this;
    }

    public Participle setVoice(Voice.Participle voice) {
        this.voice = voice.toString();
        return this;
    }

    public Participle setShort(Short shortF) {
        this.shortF = shortF.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Participle (Причастие){" +
                "plural='" + plural + '\'' +
                ", transitive='" + transitive + '\'' +
                ", time='" + time + '\'' +
                ", reflexive='" + reflexive + '\'' +
                ", gender='" + gender + '\'' +
                ", wordCase='" + wordCase + '\'' +
                ", perfect='" + perfect + '\'' +
                ", kind='" + kind + '\'' +
                ", voice='" + voice + '\'' +
                ", shortF='" + shortF + '\'' +
                '}';
    }
}
