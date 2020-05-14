package gui;

import org.hibernate.Session;
import utilities.HibernateUtil;
import words.Word;

import javax.persistence.Query;
import java.util.List;

public class Hibernate extends Thread {
    Session session;
    Query query;
    List<Word> words;

    @Override
    public void run() {
        session = HibernateUtil.getSessionFactory().openSession();
        words = query.getResultList();
    }

    public void createSQLQuery(String query) {
        this.query = session.createSQLQuery(query);
    }
}
