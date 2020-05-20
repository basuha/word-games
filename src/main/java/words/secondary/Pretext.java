package words.secondary;

import utilities.PartOfSpeech;
import utilities.Word;
import words.attributes.WordCase;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Предлог
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRETEXT)
public class Pretext extends Word {

    public Pretext() {
        partOfSpeech = PartOfSpeech.PRETEXT;
        changeable = false;
    }

    private String wordCase;

    public String getWordCase() {
        return wordCase;
    }

    public Pretext setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Pretext (Предлог){" +
                "wCase='" + wordCase + '\'' +
                '}';
    }
}
