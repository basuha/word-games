package words.primary;

import com.sun.istack.Nullable;
import utilities.Type;
import words.Word;
import words.attributes.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(Type.VERB)
public class Verb extends Word {

    @Column (name = "inf", nullable = false)
    private Boolean inf;

    @Column (name = "vozv", nullable = false)
    private Boolean refl;

    @Column (name = "transit", nullable = false)
    private String transit;

    @Nullable
    @Column (name = "plural")
    private Boolean plural;

    @Nullable
    @Column (name = "gender")
    private String gender;

    @Nullable
    @Column (name = "perfect")
    private Boolean perfect;

    @Nullable
    @Column (name = "face")
    private String face;

    @Nullable
    @Column (name = "kind")
    private String kind;

    @Nullable
    @Column (name = "time")
    private String time;

    @Nullable
    @Column (name = "nakl")
    private String voice;

    public Boolean getPlural() {
        return plural;
    }

    public void setPlural(Boolean plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender.toString();
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(Transit transit) {
        this.transit = transit.toString();
    }

    public Boolean getPerfect() {
        return perfect;
    }

    public void setPerfect(Boolean perfect) {
        this.perfect = perfect;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind.toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time.toString();
    }

    public Boolean getInf() {
        return inf;
    }

    public void setInf(Boolean inf) {
        this.inf = inf;
    }

    public Boolean getRefl() {
        return refl;
    }

    public void setRefl(Boolean refl) {
        this.refl = refl;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice.toString();
    }


    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
