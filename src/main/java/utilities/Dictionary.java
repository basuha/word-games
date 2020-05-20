package utilities;

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
//
//    public Word getWordById(int iid) {
//       Session session = getSessionFactory().openSession();
//       Word word = session.get(Word.class, iid);
//       session.close();
//       return word;
//    }
//
//
//
//    public Word addWord(Word word) {
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(word);
//        session.getTransaction().commit();
//        session.close();
//        return word;
//    }
//


//    private Integer getMaxId (String type) {
//        Integer maxId;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createSQLQuery("SELECT max(IID) FROM " + type + "_ids");
//        maxId = (Integer) query.getSingleResult();
//        session.close();
//        return maxId;
//    }
//
//    private Integer getRandId (String type) {
//        Integer randId;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createSQLQuery("SELECT id_of_source FROM " + type + "_ids WHERE IID = ?");
//        query.setParameter(1, random.nextInt(getMaxId(type)));
//        randId = (Integer) query.getSingleResult();
//        session.close();
//        return randId;
//    }
//
//    public Word getRandomWord(String type) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query query1 = session.createQuery("FROM Word WHERE IID = :id");
//        query1.setParameter("id", getRandId(type));
//        Word word = (Word) query1.getSingleResult();
//        session.close();
//        return word;
//    }


}
