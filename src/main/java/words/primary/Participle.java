package words.primary;

import utilities.Word;
import words.attributes.primary.*;
import words.attributes.secondary.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;


/**
 * Причастие
 */
@Entity
@DiscriminatorValue(Word.PARTICIPLE)
public class Participle extends Word {

    @Enumerated
    private Plural plural;

    @Enumerated
    private Transitive transitive;

    @Enumerated
    private Time time;

    @Enumerated
    private Reflexive reflexive;

    @Enumerated
    private Gender gender;

    @Enumerated
    private WordCase wordCase;

    @Enumerated
    private Perfect perfect;

    @Enumerated
    private Kind kind;

    @Enumerated
    private Voice voice;

    @Enumerated
    private ShortF shortF;

    public Participle() {
        partOfSpeech = PARTICIPLE;
        changeable = true;
    }

    public Plural getPlural() {
        return plural;
    }

    public Transitive getTransitive() {
        return transitive;
    }

    public Time getTime() {
        return time;
    }

    public Reflexive getReflexive() {
        return reflexive;
    }

    public Gender getGender() {
        return gender;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public Perfect getPerfect() {
        return perfect;
    }

    public Kind getKind() {
        return kind;
    }

    public Voice getVoice() {
        return voice;
    }

    public ShortF getShortF() {
        return shortF;
    }


    public Participle setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Participle setTransitive(Transitive transitive) {
        this.transitive = transitive;
        return this;
    }

    public Participle setTime(Time time) {
        this.time = time;
        return this;
    }

    public Participle setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive;
        return this;
    }

    public Participle setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender;
            this.plural = Plural.PLURAL;
        } else {
            this.gender = gender;
            this.plural = Plural.SINGULAR;
        }
        return this;
    }

    public Participle setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    public Participle setPerfect(Perfect perfect) {
        this.perfect = perfect;
        return this;
    }

    public Participle setKind(Kind kind) {
        this.kind = kind;
        return this;
    }

    public Participle setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public Participle setShort(ShortF shortF) {
        this.shortF = shortF;
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
