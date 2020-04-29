package utilities;

import words.Word;
import org.hibernate.Session;
import words.secondary.Particle;

import javax.persistence.Query;
import java.util.Random;

public class Dictionary extends HibernateUtil {

    private Random random = new Random();
//
//    public List<Word> getWordList() {
//        Session session = getSessionFactory().openSession();
//
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery(Word.class);
//
//        Root<Word> root = cq.from(Word.class);
//
//        cq.select(root);
//
//        Query query = session.createQuery(cq);
//
//        List<Word> wordList = query.getResultList();
//
//        session.close();
//
//        return wordList;
//    }

    public Word getWordById(int iid) {
       Session session = getSessionFactory().openSession();
       Word word = session.get(Word.class, iid);
       session.close();
       return word;
    }

    public Word getRandomWord(String type) {
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("SELECT id_of_source FROM particle_ids WHERE IID = ?");
        Query query1 = session.createSQLQuery("SELECT * FROM words_test WHERE IID = ?");
        query.setParameter(1, random.nextInt(Particle.IDS_COUNT));
        query1.setParameter(1, query.getFirstResult());
        Word word = (Word) query1.getSingleResult();
        session.close();
        return word;
    }


    public Word getWord(String word) {
        Session session = getSessionFactory().openSession();
        Word w = session.get(Word.class, word);
        session.close();
        return w;
    }


    public Word addWord(Word word) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(word);
        session.getTransaction().commit();
        session.close();
        return word;
    }
}
