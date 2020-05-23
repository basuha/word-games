package words.secondary;

import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Междометия
 * Примеры: ах, о, прочь, цыц, ура, ой
 */
@Entity
@DiscriminatorValue(Word.INTERJECTION)
public class Interjection extends Word {

    public Interjection() {
        partOfSpeech = INTERJECTION;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Interjection (Междометие)";
    }
}
