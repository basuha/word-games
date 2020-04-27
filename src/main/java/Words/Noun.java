package Words;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
    public void reload() {

    }

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

    public static class Comp {
        public static final String COMPARATIVE = "сравн";
        public static final String SUPER = "прев";
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
}
