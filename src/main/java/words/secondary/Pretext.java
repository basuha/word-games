package words.secondary;

import utilities.PartOfSpeech;
import utilities.Word;
import words.attributes.primary.WordCase;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Предлог
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRETEXT)
public class Pretext extends Word {

    @Enumerated
    private WordCase wordCase;

    public Pretext() {
        partOfSpeech = PRETEXT;
        changeable = false;
    }


    public WordCase getWordCase() {
        return wordCase;
    }

    public Pretext setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Pretext (Предлог){" +
                "wCase='" + wordCase + '\'' +
                '}';
    }
}
