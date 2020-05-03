package words.secondary;

import utilities.PartOfSpeech;
import words.Word;
import words.attributes.WordCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Предлог
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PRETEXT)
public class Pretext extends Word {

    {
        partOfSpeech = PartOfSpeech.PRETEXT;
        changeable = false;
    }

    @Column(name = "word_case")
    private String wordCase;

    public String getWordCase() {
        return wordCase;
    }

    public Pretext setWordCase(WordCase wordCase) {
        this.wordCase = wordCase.toString();
        return this;
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
        return super.getInfo() + " Pretext (Предлог){" +
                "wCase='" + wordCase + '\'' +
                '}';
    }
}
