package words;

import com.sun.istack.Nullable;
import utilities.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(Type.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short")
    private Boolean shortF;

    @Column(name = "plural")
    private Boolean plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "type_sub")
    private String subType;

    @Column(name = "wcase")
    private String wCase;

    @Nullable
    @Column(name = "comp")
    private String comp;

    @Override
    public void addCognate(Word cognate) {
        this.cognates.add(cognate);
    }

    @Override
    public List<Word> getCognates() {
        return cognates;
    }

    public static class SubType {
        public static final String IMMUTABLE = "неизм";
    }

    public enum Gender {

        MALE ("муж"),
        FEMALE ("жен"),
        NEUTER ("ср"),
        NULL ("null");

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum WCase {

        NOMINATIVE ("им"),
        GENITIVE ("род"),
        DATIVE ("дат"),
        ACCUSATIVE ("вин"),
        INSTRUMENTAL ("тв"),
        PREPOSITIONAL ("пр");

        private final String value;

        WCase (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Comp {

        COMPARATIVE ("сравн"),
        SUPER ("прев");

        private final String value;

        Comp (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
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

    public void setGender(Gender gender) {
        this.gender = gender.toString();
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

    public void setwCase(WCase wCase) {
        this.wCase = wCase.toString();
    }

    public String getComp() {
        return comp;
    }

    public void setComp(Comp comp) {
        this.comp = comp.toString();
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "{" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + subType + '\'' +
                ", wCase='" + wCase + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}
