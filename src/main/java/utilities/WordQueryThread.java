package utilities;

import org.hibernate.Session;
import words.Word;

import javax.persistence.Query;
import java.util.List;

class WordQueryThread extends Thread {
    private List<Word> wordsList;
    private String hql;

    public WordQueryThread(String hql) {
        this.hql = hql;
    }

    public List<Word> getWordsList() {
        return wordsList;
    }

    public void setWordsList(List<Word> wordsList) {
        this.wordsList = wordsList;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }

    @Override
    @SuppressWarnings("unchecked assignment")
    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        wordsList = query.getResultList();
        session.close();
    }
}