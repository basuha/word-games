package words.primary;

import com.sun.istack.Nullable;
import utilities.PartOfSpeech;
import words.Word;
import words.attributes.Animate;
import words.attributes.Gender;
import words.attributes.Plural;
import words.attributes.WordCase;

import javax.persistence.*;
import java.util.List;

/**
 * Существительное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.NOUN)
public class Noun extends Word {

    @Column (name = "plural")
    private String plural;

    @Nullable
    @Column (name = "gender")
    private String gender;

    @Nullable
    @Column (name = "word_case")
    private String wordCase;

    @Nullable
    @Column (name = "animate")
    private String animate;

    public Noun() {
        partOfSpeech = PartOfSpeech.NOUN;
        changeable = true;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }

    public String getWordCase() {
        return wordCase;
    }

    public String getAnimate() {
        return animate;
    }


    public Noun setPlural(Plural plural) {
        this.plural = plural.toString();
        return this;
    }

    public Noun setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender.toString();
            this.plural = Plural.PLURAL.toString();
        } else {
            this.gender = gender.toString();
            this.plural = Plural.SINGULAR.toString();
        }
        return this;
    }

    public Noun setWordCase(WordCase.Noun wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    public Noun setAnimate(Animate animate) {
        this.animate = animate.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Noun (Существительное) {" +
                "plural=" + plural +
                ", gender=" + gender +
                ", wCase='" + wordCase + '\'' +
                ", soul=" + animate +
                '}';
    }
}
