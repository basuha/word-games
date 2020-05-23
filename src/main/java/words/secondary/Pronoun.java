package words.secondary;

import utilities.PartOfSpeech;
import utilities.Word;
import words.attributes.primary.Gender;
import words.attributes.primary.Plural;
import words.attributes.primary.WordCase;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Местоимение
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRONOUN)
public class Pronoun extends Word {

    @Enumerated
    private Plural plural;

    @Enumerated
    private Gender gender;

    @Enumerated
    private WordCase wordCase;

    public Pronoun() {
        partOfSpeech = PRONOUN;
        changeable = false;
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

    public Pronoun setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Pronoun setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Pronoun setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun (Местоимение){" +
                "plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wordCase + '\'' +
                '}';
    }

}
