package words.secondary;

import utilities.PartOfSpeech;
import words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Предикатив
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PREDICATE)
public class Predicate extends Word {

    {
        partOfSpeech = PartOfSpeech.PREDICATE;
        changeable = false;
        super.codeParent = 0;
    }


    @Override
    public String getInfo() {
        return super.getInfo() +
                " Predicate (Предикатив)";
    }
}
