package words;

import utilities.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(Type.INTERJECTION)
public class Interjection extends Word {

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
