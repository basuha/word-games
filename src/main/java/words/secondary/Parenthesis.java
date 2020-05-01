package words.secondary;

import utilities.PartOfSpeech;
import words.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Вводное слово
 * Примеры: безусловно, видно, наверное, конечно, к удивлению
 */
@Entity
@DiscriminatorValue(PartOfSpeech.PARENTHESIS)
public class Parenthesis extends Word {

    {
        super.codeParent = 0;
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
                " Parenthesis (Вводное слово)";
    }
}
