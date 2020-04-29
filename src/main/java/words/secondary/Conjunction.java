package words.secondary;

import utilities.Type;
import words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Союз
 * Примеры: а, и, но, или, также
 */
@Entity
@DiscriminatorValue(Type.CONJUNCTION)
public class Conjunction extends Word {

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
                + " Conjunction (Союз)";
    }
}
