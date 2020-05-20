package words.secondary;

import utilities.PartOfSpeech;
import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Междометия
 * Примеры: ах, о, прочь, цыц, ура, ой
 */
@Entity
@DiscriminatorValue(PartOfSpeech.INTERJECTION)
public class Interjection extends Word {

    public Interjection() {
        partOfSpeech = PartOfSpeech.INTERJECTION;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Interjection (Междометие)";
    }
}
