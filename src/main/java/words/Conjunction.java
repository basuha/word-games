package words;

import utilities.Type;

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
    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
