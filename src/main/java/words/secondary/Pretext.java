package words.secondary;

import utilities.Type;
import words.Word;
import words.attributes.WCase;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Предлог
 */
@Entity
@DiscriminatorValue(Type.PRETEXT)
public class Pretext extends Word {

    @Column(name = "wcase", nullable = false)
    private String wCase;

    public String getwCase() {
        return wCase;
    }

    public void setwCase(WCase wCase) {
        this.wCase = wCase.toString();
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
                "wCase='" + wCase + '\'' +
                '}';
    }
}
