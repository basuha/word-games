package words.primary;

import utilities.Word;
import words.attributes.primary.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Числительные
 */
@Entity
@DiscriminatorValue(Word.NUMERAL)
public class Numeral extends Word {

    @Enumerated
    private Type type;

    @Enumerated
    private Plural plural;

    @Enumerated
    private Gender gender;

    @Enumerated
    private WordCase wordCase;

    public Numeral() {
        partOfSpeech = NUMERAL;
        changeable = true;
    }

    public Type getType() {
        return type;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public Plural getPlural() {
        return plural;
    }

    public Gender getGender() {
        return gender;
    }


    public Numeral setType(Type type) {
        this.type = type;
        return this;
    }

    public Numeral setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Numeral setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender;
            this.plural = Plural.PLURAL;
        } else {
            this.gender = gender;
            this.plural = Plural.SINGULAR;
        }
        return this;
    }

    public Numeral setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Numeral (Числительное) {" +
                "type='" + type + '\'' +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wordCase + '\'' +
                '}';
    }
}
