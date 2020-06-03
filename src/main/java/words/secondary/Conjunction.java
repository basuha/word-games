package words.secondary;

import utilities.Word;
import words.attributes.primary.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Союз
 * Примеры: а, и, но, или, также
 */
@Entity
@DiscriminatorValue(Word.CONJUNCTION)
public class Conjunction extends Word {

    public Conjunction() {
        partOfSpeech = PartOfSpeech.CONJUNCTION;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Conjunction (Союз)";
    }
}
