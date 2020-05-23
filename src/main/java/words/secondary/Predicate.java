package words.secondary;

import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Предикатив
 */
@Entity
@DiscriminatorValue(Word.PREDICATE)
public class Predicate extends Word {

    public Predicate() {
        partOfSpeech = PREDICATE;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Predicate (Предикатив)";
    }
}
