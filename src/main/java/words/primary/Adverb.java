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

    {
        partOfSpeech = PartOfSpeech.ADVERB;
        changeable = true;
    }

    @Nullable
    @Column(name = "type")
    private String type;

    @Nullable
    @Column(name = "adverb_type")
    private String adverbType;

    @Nullable
    @Column(name = "comparative")
    private String comparative;

    public String getType() {
        return type;
    }

    public String getAdverbType() {
        return adverbType;
    }

    public String getComparative() {
        return comparative;
    }

    public Adverb setParam(Type.Adverb type) {
        this.type = type.toString();
        return this;
    }

    public Adverb setParam(Comparative comparative) {
        this.comparative = comparative.toString();
        return this;
    }

    public Adverb setParam(AdverbType adverbType) {
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

