package words.secondary;

import utilities.Word;

import javax.persistence.*;

/**
 * Частица
 */
@Entity
@DiscriminatorValue(Word.PARTICLE)
public class Particle extends Word {

    public Particle() {
        partOfSpeech = PARTICLE;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Particle (Частица)";
    }
}
