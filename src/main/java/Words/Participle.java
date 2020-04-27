package Words;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(Type.PARTICIPLE)
public class Participle extends Word {

    @Column(name = "plural")
    private Boolean plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "wcase")
    private String wCase;

    @Column(name = "transit")
    private String transit;

    @Column(name = "perfect")
    private Boolean perfect;

    @Column(name = "kind")
    private String kind;

    @Column (name = "time")
    private String time;

    @Column (name = "vozv")
    private Boolean reflexive;

    @Column (name = "nakl")
    private String voice;

    @Column (name = "short")
    private String shortF;

    public Boolean getPlural() {
        return plural;
    }

    public void setPlural(Boolean plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getwCase() {
        return wCase;
    }

    public void setwCase(String wCase) {
        this.wCase = wCase;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public Boolean getPerfect() {
        return perfect;
    }

    public void setPerfect(Boolean perfect) {
        this.perfect = perfect;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getReflexive() {
        return reflexive;
    }

    public void setReflexive(Boolean reflexive) {
        this.reflexive = reflexive;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getShortF() {
        return shortF;
    }

    public void setShortF(String shortF) {
        this.shortF = shortF;
    }

    @Override
    public void reload() {

    }

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
