package words;

import utilities.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(Type.PARTICLE)
public class Particle extends Word {

    @Override
    public void addCognate(Word cognate) {

    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
