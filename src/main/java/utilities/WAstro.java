package utilities;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "astro")
public class WAstro {

    @Id
    private int IID;
    private String sentence;
    private int position;
    private boolean isPositive;

    @Transient
    private static int MAX_ID;

    public static int getMaxID() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //определение максимального ID в базе словаря
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("SELECT max(IID) FROM Word");
                MAX_ID = (Integer) query.getSingleResult();
                session.close();
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return MAX_ID;
    }

    public static WAstro getRandom(int position) {
        StringBuilder hql = new StringBuilder();
        WAstro wAstro;
        hql.append("FROM WAStro WHERE IID = ")
                .append(new Random().nextInt(getMaxID()))
                .append(" AND position = ")
                .append(position);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql.toString());
        MAX_ID = (Integer) query.getSingleResult();
        session.close();
    }

    public int getIID() {
        return IID;
    }

    public void setIID(int IID) {
        this.IID = IID;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }
}
