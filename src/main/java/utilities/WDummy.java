package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

public class WDummy extends Word {

    protected AdverbType adverbType;
    protected Animate animate;
    protected Comparative comparative;
    protected Face face;
    protected Gender gender;
    protected Infinitive infinitive;
    protected Kind kind;
    protected Perfect perfect;
    protected Plural plural;
    protected Reflexive reflexive;
    protected ShortF shortF;
    protected Time time;
    protected Transitive transitive;
    protected Type type;
    protected Voice voice;
    protected WordCase wordCase;

    public WDummy() {
    }

    public WDummy(String word) {
        this.word = word;
    }

    public AdverbType getAdverbType() {
        return adverbType;
    }

    public void setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType;
    }

    public Animate getAnimate() {
        return animate;
    }

    public void setAnimate(Animate animate) {
        this.animate = animate;
    }

    public Comparative getComparative() {
        return comparative;
    }

    public void setComparative(Comparative comparative) {
        this.comparative = comparative;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Infinitive getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Perfect getPerfect() {
        return perfect;
    }

    public void setPerfect(Perfect perfect) {
        this.perfect = perfect;
    }

    public Plural getPlural() {
        return plural;
    }

    public void setPlural(Plural plural) {
        this.plural = plural;
    }

    public Reflexive getReflexive() {
        return reflexive;
    }

    public void setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive;
    }

    public ShortF getShortF() {
        return shortF;
    }

    public void setShortF(ShortF shortF) {
        this.shortF = shortF;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Transitive getTransitive() {
        return transitive;
    }

    public void setTransitive(Transitive transitive) {
        this.transitive = transitive;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public void setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
    }
}
