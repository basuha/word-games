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

    static {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT MAX(IID) FROM particle_ids");
        IDS_COUNT = (Integer) query.getSingleResult();
        session.close();
    }

    @Transient
    public static final Integer IDS_COUNT;

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
