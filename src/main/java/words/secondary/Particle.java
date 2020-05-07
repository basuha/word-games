package words.secondary;

import utilities.PartOfSpeech;
import words.Word;

import javax.persistence.*;
import java.util.List;

/**
 * Частица
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PARTICLE)
public class Particle extends Word {

    public Particle() {
        partOfSpeech = PartOfSpeech.PARTICLE;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Particle (Частица)";
    }
}
