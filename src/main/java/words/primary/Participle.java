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

    {
        partOfSpeech = PartOfSpeech.PARTICIPLE;
    }

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


    public void setParam(Plural plural) {
        this.plural = plural.toString();
    }

    public void setParam(Transitive transitive) {
        this.transitive = transitive.toString();
    }

    public void setParam(Time.Participle time) {
        this.time = time.toString();
    }

    public void setParam(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
    }

    public void setParam(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender.toString();
            this.plural = Plural.PLURAL.toString();
        } else {
            this.gender = gender.toString();
            this.plural = Plural.SINGULAR.toString();
        }
    }

    public void setParam(WordCase wordCase) {
        this.wordCase = wordCase.toString();
    }

    public void setParam(Boolean perfect) {
        this.perfect = perfect.toString();
    }

    public void setParam(Kind.Participle kind) {
        this.kind = kind.toString();
    }

    public void setParam(Voice.Participle voice) {
        this.voice = voice.toString();
    }

    public void setParam(Short shortF) {
        this.shortF = shortF.toString();
    }


    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
