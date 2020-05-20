package utilities;

import words.attributes.*;

public class WDummy extends Word {

    protected String adverbType;
    protected String animate;
    protected String comparative;
    protected String face;
    protected String gender;
    protected String infinitive;
    protected String kind;
    protected String perfect;
    protected String plural;
    protected String reflexive;
    protected String shortF;
    protected String time;
    protected String transitive;
    protected String type;
    protected String voice;
    protected String wordCase;

    public String getAdverbType() {
        return adverbType;
    }

    public void setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType.toString();
    }

    public String getAnimate() {
        return animate;
    }

    public void setAnimate(Animate animate) {
        this.animate = animate.toString();
    }

    public String getComparative() {
        return comparative;
    }

    public void setComparative(Comparative comparative) {
        this.comparative = comparative.toString();
    }

    public String getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face.toString();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender.toString();
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(Infinitive infinitive) {
        this.infinitive = infinitive.toString();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind.toString();
    }

    public String getPerfect() {
        return perfect;
    }

    public void setPerfect(Perfect perfect) {
        this.perfect = perfect.toString();
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(Plural plural) {
        this.plural = plural.toString();
    }

    public String getReflexive() {
        return reflexive;
    }

    public void setReflexive(Reflexive reflexive) {
        this.reflexive = reflexive.toString();
    }

    public String getShortF() {
        return shortF;
    }

    public void setShortF(ShortF shortF) {
        this.shortF = shortF.toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time.toString();
    }

    public String getTransitive() {
        return transitive;
    }

    public void setTransitive(Transitive transitive) {
        this.transitive = transitive.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(Type.Adjective type) {
        this.type = type.toString();
    }
    public void setType(Type.Adverb type) {
        this.type = type.toString();
    }
    public void setType(Type.Numeral type) {
        this.type = type.toString();
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice.toString();
    }

    public String getWordCase() {
        return wordCase;
    }

    public void setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
    }
}
