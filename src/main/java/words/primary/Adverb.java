package words.primary;

import utilities.Word;
import words.attributes.primary.AdverbType;
import words.attributes.secondary.Comparative;
import words.attributes.primary.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Наречие
 */
@Entity
@DiscriminatorValue(Word.ADVERB)
public class Adverb extends Word {

    @Enumerated
    private Type type;

    @Enumerated
    private AdverbType adverbType;

    @Enumerated
    private Comparative comparative;

    public Adverb() {
        partOfSpeech = ADVERB;
        changeable = true;
    }

    public Type getType() {
        return type;
    }

    public AdverbType getAdverbType() {
        return adverbType;
    }

    public Comparative getComparative() {
        return comparative;
    }

    public Adverb setType(Type type) {
        this.type = type;
        return this;
    }

    public Adverb setComparative(Comparative comparative) {
        this.comparative = comparative;
        return this;
    }

    public Adverb setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType;
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adverb (Наречие){" +
                "type='" + type + '\'' +
                ", adverbType='" + adverbType + '\'' +
                ", comp='" + comparative + '\'' +
                '}';
    }
}

