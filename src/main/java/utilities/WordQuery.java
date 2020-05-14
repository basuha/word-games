package utilities;

import org.hibernate.Session;
import words.Word;

import javax.persistence.Query;
import java.util.List;

class WordQuery extends Thread {
    List<Word> wordsList;
    String hql;

    public WordQuery(String hql) {
        this.wordsList = wordsList;
        this.hql = hql;
    }

    @Override
    public synchronized void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        wordsList = query.getResultList();
        session.close();
        notify();
    }
}