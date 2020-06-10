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

    @Override
    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public AdverbType getAdverbType() {
        return adverbType;
    }

    public WDummy setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType;
        return this;
    }

    public Animate getAnimate() {
        return animate;
    }

    public WDummy setAnimate(Animate animate) {
        this.animate = animate;
        return this;
    }

    public Comparative getComparative() {
        return comparative;
    }

    public WDummy setComparative(Comparative comparative) {
        this.comparative = comparative;
        return this;
    }

    public Face getFace() {
        return face;
    }

    public WDummy setFace(Face face) {
        this.face = face;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public WDummy setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Infinitive getInfinitive() {
        return infinitive;
    }

    public WDummy setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive;
        return this;
    }

    public Kind getKind() {
        return kind;
    }

    public WDummy setKind(Kind kind) {
        this.kind = kind;
        return this;
    }

    public Perfect getPerfect() {
        return perfect;
    }

    public WDummy setPerfect(Perfect perfect) {
        this.perfect = perfect;
        return this;
    }

    public Plural getPlural() {
        return plural;
    }

    public WDummy setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Reflexive getReflexive() {
        return reflexive;
    }

    public WDummy setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive;
        return this;
    }

    public ShortF getShortF() {
        return shortF;
    }

    public WDummy setShortF(ShortF shortF) {
        this.shortF = shortF;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public WDummy setTime(Time time) {
        this.time = time;
        return this;
    }

    public Transitive getTransitive() {
        return transitive;
    }

    public WDummy setTransitive(Transitive transitive) {
        this.transitive = transitive;
        return this;
    }

    public Type getType() {
        return type;
    }

    public WDummy setType(Type type) {
        this.type = type;
        return this;
    }

    public Voice getVoice() {
        return voice;
    }

    public WDummy setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public WDummy setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }
}
