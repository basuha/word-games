package words.primary;

import utilities.Word;
import words.attributes.primary.*;

import javax.persistence.*;

/**
 * Существительное
 */
@Entity
@DiscriminatorValue(Word.NOUN)
public class Noun extends Word {

    @Enumerated
    private Plural plural;

    @Enumerated
    private Gender gender;

    @Enumerated
    private WordCase wordCase;

    @Enumerated
    private Animate animate;

    public Noun() {
        partOfSpeech = NOUN;
        changeable = true;
    }

    public Plural getPlural() {
        return plural;
    }

    public Gender getGender() {
        return gender;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public Animate getAnimate() {
        return animate;
    }


    public Noun setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Noun setGender(Gender gender) {
//        if (gender == Gender.N_A) {
//            this.gender = gender;
//            this.plural = Plural.PLURAL;
//        } else {
//            this.gender = gender;
//            this.plural = Plural.SINGULAR;
//        }
        this.gender = gender;
        return this;
    }

    public Noun setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    public Noun setAnimate(Animate animate) {
        this.animate = animate;
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
