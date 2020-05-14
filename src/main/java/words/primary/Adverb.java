package words.primary;

import com.sun.istack.Nullable;
import utilities.PartOfSpeech;
import words.Word;
import words.attributes.AdverbType;
import words.attributes.Comparative;
import words.attributes.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Наречие
 */
@Entity
@DiscriminatorValue(PartOfSpeech.ADVERB)
public class Adverb extends Word {
    private String type;
    private String adverbType;
    private String comparative;

    public Adverb() {
        partOfSpeech = PartOfSpeech.ADVERB;
        changeable = true;
    }

    public String getType() {
        return type;
    }

    public String getAdverbType() {
        return adverbType;
    }

    public String getComparative() {
        return comparative;
    }

    public Adverb setType(Type.Adverb type) {
        this.type = type.toString();
        return this;
    }

    public Adverb setComparative(Comparative comparative) {
        this.comparative = comparative.toString();
        return this;
    }

    public Adverb setAdverbType(AdverbType adverbType) {
        this.adverbType = adverbType.toString();
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adverb (Наречие){" +
                "subType='" + type + '\'' +
                ", advSubType='" + adverbType + '\'' +
                ", comp='" + comparative + '\'' +
                '}';
    }
}

