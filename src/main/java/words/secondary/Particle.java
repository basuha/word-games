package words.secondary;

import utilities.Word;
import words.attributes.primary.PartOfSpeech;

import javax.persistence.*;

/**
 * Частица
 */
@Entity
@DiscriminatorValue(Word.PARTICLE)
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
