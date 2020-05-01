package words.secondary;

import com.sun.istack.Nullable;
import utilities.PartOfSpeech;
import words.Word;
import words.attributes.Gender;
import words.attributes.Plural;
import words.attributes.WordCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Местоимение
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRONOUN)
public class Pronoun extends Word {

    @Nullable
    @Column(name = "plural")
    private String plural;

    @Nullable
    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "word_case")
    private String wordCase;

    public String getWordCase() {
        return wordCase;
    }

    public String getPlural() {
        return plural;
    }

    public String getGender() {
        return gender;
    }


    public void setParam(Plural plural) {
        this.plural = plural.toString();
    }

    public void setParam(Gender gender) {
        this.gender = gender.toString();
    }

    public void setParam(WordCase wordCase) {
        this.wordCase = wordCase.toString();
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
                " Pronoun (Местоимение){" +
                "plural=" + plural +
                ", gender='" + gender + '\'' +
                ", wCase='" + wordCase + '\'' +
                '}';
    }

}
