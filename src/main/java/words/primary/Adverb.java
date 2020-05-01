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

    public void setParam(Type.Adverb type) {
        this.type = type.toString();
    }

    public void setParam(Comparative comparative) {
        this.comparative = comparative.toString();
    }

    public void setParam(AdverbType adverbType) {
        this.adverbType = adverbType.toString();
    }

    @Override
    public void addCognate(Word cognate) {
    }

    @Override
    public List<Word> getCognates() {
        return null;
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

