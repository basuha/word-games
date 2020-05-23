package words.secondary;

import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-существительное
 */
@Entity
@DiscriminatorValue(Word.PRON_ADJ)
public class PronAdj extends Pronoun {

    public PronAdj() {
        partOfSpeech = PRON_ADJ;
        changeable = false;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-adjective(Местоимение-прл)";
    }
}