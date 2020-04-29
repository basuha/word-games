package words.secondary;

import com.sun.istack.Nullable;
import utilities.Type;
import words.Word;
import words.attributes.Gender;
import words.attributes.WCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Местоимение
 */
@Entity
@DiscriminatorValue(Type.PRONOUN)
public class Pronoun extends Word {

    @Nullable
    @Column(name = "plural")
    private Boolean plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "wcase")
    private String wCase;

    /**
     * Местоимение-существительное
     */
    @Entity
    @DiscriminatorValue(Type.PRONOUN_NOUN)
    public static class Noun extends Pronoun {
        @Override
        public String getInfo() {
            return super.getInfo() +
                    " Pronoun-noun(Местоимение-сущ)";
        }
    }

    /**
     * Местоимение-прилагательное
     */
    @Entity
    @DiscriminatorValue(Type.PRONOUN_ADJECTIVE)
    public static class Adjective extends Pronoun {
        @Override
        public String getInfo() {
            return super.getInfo() +
                    " Pronoun-adjective(Местоимение-прл)";
        }
    }

    /**
     * Местоимение-наречие
     */
    @Entity
    @DiscriminatorValue(Type.PRONOUN_ADVERB)
    public static class Adverb extends Pronoun {
        @Override
        public String getInfo() {
            return super.getInfo() +
                    " Pronoun-adverb(Местоимение-наречие)";
        }
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

    public String getwCase() {
        return wCase;
    }

    public void setwCase(WCase wCase) {
        this.wCase = wCase.toString();
    }

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun (Местоимение){" +
                "plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wCase + '\'' +
                '}';
    }

}
