package utilities;

import words.Adjective;
import words.Noun;
import words.Word;
import org.hibernate.Session;

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
        String hql = null;
//        switch (type) {
//            case Type.NOUN: hql = "FROM Noun order by rand(2)"; break;
//            case Type.ADJECTIVE: hql = "FROM Adjective WHERE IID = :rand "; break;
//            case Type.ADVERB: hql = "FROM Adverb WHERE IID = :rand "; break;
//            case Type.CONJUNCTION: hql = "FROM Conjunction WHERE IID = :rand "; break;
//            case Type.EXTRA_PARTICIPLE: hql = "FROM ExtraParticiple WHERE IID = :rand "; break;
//            case Type.INTERJECTION: hql = "FROM Interjection WHERE IID = :rand "; break;
//            case Type.NUMERAL: hql = "FROM Numeral WHERE IID = :rand "; break;
//            case Type.PARENTHESIS: hql = "FROM Parenthesis WHERE IID = :rand "; break;
//            case Type.PARTICIPLE: hql = "FROM Participle WHERE IID = :rand "; break;
//            case Type.PARTICLE: hql = "FROM Particle WHERE IID = :rand "; break;
//            case Type.PREDICATE: hql = "FROM Predicate WHERE IID = :rand "; break;
//            case Type.PRETEXT: hql = "FROM Pretext WHERE IID = :rand "; break;
//            case Type.VERB: hql = "FROM Verb WHERE IID = :rand "; break;
//            case Type.PRONOUN: hql = "FROM Pronoun WHERE IID = :rand "; break;
//        }

        Word word = null;
//        Session session = getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Word.class);
//        criteria.add(Restrictions.eq("type", type));
//        criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
//        criteria.setMaxResults(1);
//        word = (Word) criteria.uniqueResult();
//        session.close();

//        hql = "SELECT COUNT(IID) as count FROM Word WHERE type = :type";
        do {
            hql = "from Word where IID = :rand";
            Session session = getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            query.setParameter("rand", random.nextInt(4000000));
//        query.setParameter("type", type);
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
