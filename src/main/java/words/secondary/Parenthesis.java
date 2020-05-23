package words.secondary;

import utilities.Word;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Вводное слово
 * Примеры: безусловно, видно, наверное, конечно, к удивлению
 */
@Entity
@DiscriminatorValue(Word.PARENTHESIS)
public class Parenthesis extends Word {

    public Parenthesis() {
        partOfSpeech = PARENTHESIS;
        changeable = false;
        super.codeParent = 0;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Parenthesis (Вводное слово)";
    }
}
