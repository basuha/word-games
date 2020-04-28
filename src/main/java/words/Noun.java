package words;

import utilities.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(Type.NOUN)
public class Noun extends Word{

    @Column (name = "plural")
    private Boolean plural;

    @Column (name = "gender")
    private String gender;

    @Column (name = "wcase")
    private String wCase;

    @Column (name = "soul")
    private Boolean soul;

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    public static class Gender {
        public static final String MALE = "муж";
        public static final String FEMALE = "жен";
        public static final String NEUTER = "ср";
        public static final String COMMON = "общ";
    }

    private static class Wcase {
        public static final String NOMINATIVE = "им";
        public static final String GENITIVE = "род";
        public static final String DATIVE = "дат";
        public static final String ACCUSATIVE = "вин";
        public static final String INSTRUMENTAL = "тв";
        public static final String PREPOSITIONAL = "пр";
        public static final String VOCATIVE = "зват";
        public static final String PARTITIVE = "парт";
        public static final String LOCATIVE = "мест";
        public static final String COUNTING = "счет";
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

    public String getwCase() {
        return wCase;
    }

    public void setwCase(String wCase) {
        this.wCase = wCase;
    }

    public Boolean getSoul() {
        return soul;
    }

    public void setSoul(Boolean soul) {
        this.soul = soul;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Noun{" +
                "plural=" + plural +
                ", gender=" + gender +
                ", wCase='" + wCase + '\'' +
                ", soul=" + soul +
                '}';
    }
}
