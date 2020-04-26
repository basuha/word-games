package Words;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Type.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short")
    private Boolean shortF;

    @Column(name = "plural")
    private Boolean plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "type_sub")
    private String subType;

    @Column(name = "wcase")
    private String wCase;

    @Column(name = "comp")
    private String comp;

    public static class SubType {
        public static final String IMMUTABLE = "неизм";
    }

    public static class Gender {
        public static final String MALE = "муж";
        public static final String FEMALE = "жен";
        public static final String NEUTER = "ср";
    }

    public static class WCase {
        public static final String NOMINATIVE = "им";
        public static final String GENITIVE = "род";
        public static final String DATIVE = "дат";
        public static final String ACCUSATIVE = "вин";
        public static final String INSTRUMENTAL = "тв";
        public static final String PREPOSITIONAL = "пр";
    }

    public static class Comp {
        public static final String COMPARATIVE = "сравн";
        public static final String SUPER = "прев";
    }

    public Boolean getShortF() {
        return shortF;
    }

    public void setShortF(Boolean shortF) {
        this.shortF = shortF;
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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getwCase() {
        return wCase;
    }

    public void setwCase(String wCase) {
        this.wCase = wCase;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return getWord();
    }
}
