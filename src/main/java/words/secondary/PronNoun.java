package words.secondary;

import utilities.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-прилагательное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRON_NOUN)
public class PronNoun extends Pronoun {
    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-noun(Местоимение-сущ)";
    }
}
