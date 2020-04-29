package words;

import utilities.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Междометия
 * Примеры: ах, о, прочь, цыц, ура, ой
 */
@Entity
@DiscriminatorValue(Type.INTERJECTION)
public class Interjection extends Word {

    {
        super.codeParent = 0;
    }

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    @Override
    public String getInfo() {
        return super.getInfo()
                + " Interjection (Междометие)";
    }
}
