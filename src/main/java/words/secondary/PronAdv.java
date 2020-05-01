package words.secondary;


import utilities.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-наречие
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRON_ADV)
public class PronAdv extends Pronoun {
    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-adverb(Местоимение-наречие)";
    }
}