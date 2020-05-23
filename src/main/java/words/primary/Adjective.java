package words.primary;

import utilities.PartOfSpeech;
import utilities.Word;
import words.attributes.secondary.Comparative;
import words.attributes.secondary.ShortF;
import words.attributes.primary.Gender;
import words.attributes.primary.Plural;
import words.attributes.primary.Type;
import words.attributes.primary.WordCase;

import javax.persistence.*;

/**
 * Прилагательное
 */
@Entity
@DiscriminatorValue(PartOfSpeech.ADJECTIVE)
public class Adjective extends Word {

    @Enumerated
    private ShortF shortF;

    @Enumerated
    private Plural plural;

    @Enumerated
    private Gender gender;

    @Enumerated
    private Type type;

    @Enumerated
    private WordCase wordCase;

    @Enumerated
    private Comparative comparative;

    public Adjective() {
        partOfSpeech = ADJECTIVE;
    }

    public ShortF getShortF() {
        return shortF;
    }

    public Plural getPlural() {
        return plural;
    }

    public Gender getGender() {
        return gender;
    }

    public Type getType() {
        return type;
    }

    public WordCase getWordCase() {
        return wordCase;
    }

    public Comparative getComparative() {
        return comparative;
    }

    public Adjective setShortF(ShortF shortF) {
        this.shortF = shortF;
        return this;
    }

    public Adjective setPlural(Plural plural) {
        this.plural = plural;
        return this;
    }

    public Adjective setGender(Gender gender) {
        if (gender == Gender.N_A) {
            this.gender = gender;
            this.plural = Plural.PLURAL;
        } else {
            this.gender = gender;
            this.plural = Plural.SINGULAR;
        }
        return this;
    }

    public Adjective setType(Type type) {
        if (type == Type.IMMUTABLE_ADJECTIVE) {
            this.gender = Gender.N_A;
            this.plural = Plural.N_A;
            this.wordCase = WordCase.N_A;
            this.comparative = Comparative.N_A;
            this.shortF = ShortF.NOT_SHORT;
        } else {
            this.type = type;
        }
        return this;
    }

    public Adjective setWordCase(WordCase wordCase) {
        this.wordCase = wordCase;
        return this;
    }

    public Adjective setComparative(Comparative comparative) {
        this.comparative = comparative;
        return this;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adjective (прилагательное) {" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + type + '\'' +
                ", wCase='" + wordCase + '\'' +
                ", comp='" + comparative + '\'' +
                '}';
    }
}
