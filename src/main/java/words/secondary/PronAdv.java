package words.secondary;

import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Местоимение-наречие
 */
@Entity
@DiscriminatorValue(Word.PRON_ADV)
public class PronAdv extends Pronoun {

    public PronAdv() {
        partOfSpeech = PRON_ADV;
        changeable = false;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Pronoun-adverb(Местоимение-наречие)";
    }
}