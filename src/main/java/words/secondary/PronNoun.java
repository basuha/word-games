package words.secondary;

import utilities.Word;
import words.attributes.primary.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-прилагательное
 */
@Entity
@DiscriminatorValue(Word.PRON_NOUN)
public class PronNoun extends Pronoun {

    public PronNoun() {
        partOfSpeech = PartOfSpeech.PRON_NOUN;
        changeable = false;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-noun(Местоимение-сущ)";
    }
}

