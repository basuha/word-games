package words;

import com.sun.istack.Nullable;
import org.antlr.v4.runtime.misc.NotNull;
import utilities.Type;

import javax.persistence.*;
import java.util.List;

//прилагательное
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

    public enum SubType {

        IMMUTABLE ("неизм"),
        MUTABLE ("null");

        private final String value;

        SubType (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public enum Gender {

        MALE ("муж"),
        FEMALE ("жен"),
        NEUTER ("ср"),
        PLURAL_FORM ("null");

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

    public String getGender() {
        return gender;
    }

    /**
     * Род прилагательного (мужской, женский, средний)
     * либо множественное число (без рода)
     * @param gender род прилагательного
     */
    public void setGender(Gender gender) {
        this.gender = gender.toString();
        this.plural = gender == Gender.PLURAL_FORM;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType.toString();
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
