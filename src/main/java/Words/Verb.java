package Words;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(Type.VERB)
public class Verb extends Word{

    @Column (name = "plural")
    private Boolean plural;

    @Column (name = "gender")
    private String gender;

    @Column (name = "transit")
    private String transit;

    @Column (name = "perfect")
    private Boolean perfect;

    @Column (name = "face")
    private String face;

    @Column (name = "kind")
    private String kind;

    @Column (name = "time")
    private String time;

    @Column (name = "inf")
    private Boolean inf;

    @Column (name = "vozv")
    private Boolean refl;

    @Column (name = "nakl")
    private String voice;

    private static class Gender {
        public static final String MALE = "муж";
        public static final String FEMALE = "жен";
        public static final String NEUTER = "ср";
    }

    private static class Transit {
        public static final String TRANSITIVE = "перех";
        public static final String INTRANSITIVE = "непер";
        public static final String TRANS_INTRANS = "пер/не";
    }

    private static class Face {
        public static final String FIRST = "1-е";
        public static final String SECOND = "2-е";
        public static final String THIRD = "3-е";
        public static final String ANONYMOUS = "безл";
    }

    private static class Kind {
        public static final String FIRST = "1вид";
        public static final String SECOND = "2вид";
    }

    private static class Time {
        public static final String PAST = "прош";
        public static final String PRESENT = "наст";
        public static final String FUTURE = "буд";
    }

    private static class Voice {
        public static final String ACTIVE = "пов";
        public static final String PASSIVE = "страд";
    }

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

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
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

    public void setVoice(String voice) {
        this.voice = voice;
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
