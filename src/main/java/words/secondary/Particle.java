package words.secondary;

import org.hibernate.Session;
import utilities.HibernateUtil;
import utilities.Type;
import words.Word;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

/**
 * Частица
 */
@Entity
@DiscriminatorValue(Type.PARTICLE)
public class Particle extends Word {

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
                " Particle (Частица)";
    }
}
