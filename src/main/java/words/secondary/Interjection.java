package words.secondary;

import utilities.PartOfSpeech;
import words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

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
