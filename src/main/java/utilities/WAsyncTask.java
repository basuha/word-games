package utilities;

import org.hibernate.Session;

import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WAsyncTask extends WSearch implements Runnable {

    private final int NUMBER_OF_THREADS = 10;
    private final int ONE_THREAD_INTERVAL = Word.getMaxID() / NUMBER_OF_THREADS;
    private BlockingQueue<Word> queue = new ArrayBlockingQueue<>(10);
    private int progress;

    public WAsyncTask(String hexCode) {
        super(hexCode);
    }

    public WAsyncTask(IWord word) {
        super(word);
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0, interval = 0, nextInterval = interval + ONE_THREAD_INTERVAL;
             i < NUMBER_OF_THREADS;
             i++, interval = nextInterval, nextInterval += ONE_THREAD_INTERVAL) {

            int finalInterval = interval;
            int finalNextInterval = nextInterval;

            executorService.submit(() -> {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery(buildQuery(finalInterval, finalNextInterval));
                List<Word> words = query.getResultList();
                if (words != null)
                    wordsList.addAll(words);
                session.close();
            });
            progress += 100 / NUMBER_OF_THREADS;
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress = 100;
        getResultSet();
    }

    public int getProgress() {
        return progress;
    }

    private String buildQuery(int lowID, int hiID) {
        StringBuilder hql = new StringBuilder();
        hql.append("FROM ")
                .append(partOfSpeech != null ? partOfSpeech : "Word")
                .append(" WHERE")
                .append(" IID > ").append(lowID)
                .append(" AND")
                .append(" IID < ").append(hiID);

//        System.out.println("запрос " + hql.toString());
//        System.out.println(Arrays.toString(wAttributes));
//        System.out.println(getInfo());

//        for (Field f : word.wAttributes) {
//            hql.append(" AND ")
//                    .append(f.getName())
//                    .append(" = ")
//                    .append("'")
//                    .append(f.get(word))
//                    .append("'");
//        }
//
//        System.out.println("запрос " + hql.toString());
//
//
//        if (word != null) {
//            hql.append(" AND")
//                    .append(" word = ")
//                    .append("'")
//                    .append(word)
//                    .append("'");
//        }

        if (shortF != null) {
            hql.append(" AND")
                    .append(" shortF = ")
                    .append("'")
                    .append(shortF)
                    .append("'");
        }

        if (plural != null) {
            hql.append(" AND")
                    .append(" plural = ")
                    .append("'")
                    .append(plural)
                    .append("'");
        }

        if (gender != null) {
            hql.append(" AND")
                    .append(" gender = ")
                    .append("'")
                    .append(gender)
                    .append("'");
        }

        if (type != null) {
            hql.append(" AND")
                    .append(" type = ")
                    .append("'")
                    .append(type)
                    .append("'");
        }

        if (wordCase != null) {
            hql.append(" AND")
                    .append(" wordCase = ")
                    .append("'")
                    .append(wordCase)
                    .append("'");
        }

        if (comparative != null) {
            hql.append(" AND")
                    .append(" comparative = ")
                    .append("'")
                    .append(comparative)
                    .append("'");
        }

        if (animate != null) {
            hql.append(" AND")
                    .append(" animate = ")
                    .append("'")
                    .append(animate)
                    .append("'");
        }

        if (adverbType != null) {
            hql.append(" AND")
                    .append(" adverbType = ")
                    .append("'")
                    .append(adverbType)
                    .append("'");
        }

        if (face != null) {
            hql.append(" AND")
                    .append(" face = ")
                    .append("'")
                    .append(face)
                    .append("'");
        }

        if (infinitive != null) {
            hql.append(" AND")
                    .append(" infinitive = ")
                    .append("'")
                    .append(infinitive)
                    .append("'");
        }

        if (kind != null) {
            hql.append(" AND")
                    .append(" kind = ")
                    .append("'")
                    .append(kind)
                    .append("'");
        }

        if (perfect != null) {
            hql.append(" AND")
                    .append(" perfect = ")
                    .append("'")
                    .append(perfect)
                    .append("'");
        }

        if (reflexive != null) {
            hql.append(" AND")
                    .append(" reflexive = ")
                    .append("'")
                    .append(reflexive)
                    .append("'");
        }

        if (time != null) {
            hql.append(" AND")
                    .append(" time = ")
                    .append("'")
                    .append(time)
                    .append("'");
        }

        if (transitive != null) {
            hql.append(" AND")
                    .append(" transitive = ")
                    .append("'")
                    .append(transitive)
                    .append("'");
        }

        if (voice != null) {
            hql.append(" AND")
                    .append(" voice = ")
                    .append("'")
                    .append(voice)
                    .append("'");
        }

        return hql.toString();
    }
}
