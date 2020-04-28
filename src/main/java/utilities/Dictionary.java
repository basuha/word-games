package utilities;

import words.Word;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class Dictionary extends HibernateUtil {

    private Random random = new Random();

    public List<Word> getWordList() {
        Session session = getSessionFactory().openSession();

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
       Session session = getSessionFactory().openSession();
       Word word = session.get(Word.class, iid);
       session.close();
       return word;
    }

    public Word getRandomWord(String type) {
        Word word;
        do {
            Session session = getSessionFactory().openSession();
            String hql = "FROM Word WHERE " +
                    "IID = :rand ";
            Query query = session.createQuery(hql);
            query.setParameter("rand", random.nextInt(4159394));
            word = (Word) query.getSingleResult();
            session.close();
        } while (!word.getType().equals(type));

//        for (Word a : results) {
//            if (word.getCode().equals(a.getCodeParent())) {
//                word.addCognate(a);
//            }
//        }
//
//        System.out.println(results.size());
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
