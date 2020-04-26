import Words.Adjective;
import Words.Type;
import Words.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private SessionFactory sessionFactory;
    private Random random = new Random();

    public Dictionary() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Word> getWordList() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Word.class);

        Root<Word> root = cq.from(Word.class);

        cq.select(root);

        Query query = session.createQuery(cq);

        List<Word> wordList = query.getResultList();

        session.close();

        return wordList;
    }

    public Word getWordById(int iid) {
       Session session = sessionFactory.openSession();
       Word word = session.get(Word.class, iid);
       session.close();
       return word;
    }

    public Word getRandomAdj(String wCase) {
        Session session = sessionFactory.openSession();
        String hql = "FROM Adjective WHERE codeParent = 0";
        Query query = session.createQuery(hql);
//        query.setParameter("wCase",wCase);
        List<Word> results = query.getResultList();
        session.close();
        System.out.println(results.size());
        return results.get(random.nextInt(results.size()));
    }


    public Word getWord(String word) {
        Session session = sessionFactory.openSession();
        Word w = session.get(Word.class, word);
        session.close();
        return w;
    }


    public Word addWord(Word word) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(word);
        session.getTransaction().commit();
        session.close();
        return word;
    }
}
