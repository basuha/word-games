package words.secondary;

import utilities.PartOfSpeech;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-существительное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRON_ADJ)
public class PronAdj extends Pronoun {

    {
        partOfSpeech = PartOfSpeech.PRON_ADJ;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-adjective(Местоимение-прл)";
    }
}