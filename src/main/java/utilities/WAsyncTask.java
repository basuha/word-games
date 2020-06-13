package utilities;

import org.hibernate.Session;
import words.attributes.primary.*;
import words.attributes.secondary.*;

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
        PartOfSpeech part = PartOfSpeech.values()[Integer.parseInt(partOfSpeech)];
        StringBuilder hql = new StringBuilder();
        hql.append("FROM ")
                .append(part != null ? part : "Word")
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

        if (shortF != ShortF.NULL) {
            hql.append(" AND")
                    .append(" shortF = ")
                    .append("'")
                    .append(shortF.ordinal())
                    .append("'");
        }

        if (plural != Plural.NULL) {
            hql.append(" AND")
                    .append(" plural = ")
                    .append("'")
                    .append(plural.ordinal())
                    .append("'");
        }

        if (gender != Gender.NULL) {
            hql.append(" AND")
                    .append(" gender = ")
                    .append("'")
                    .append(gender.ordinal())
                    .append("'");
        }

        if (type != Type.NULL) {
            hql.append(" AND")
                    .append(" type = ")
                    .append("'")
                    .append(type.ordinal())
                    .append("'");
        }

        if (wordCase != WordCase.NULL) {
            hql.append(" AND")
                    .append(" wordCase = ")
                    .append("'")
                    .append(wordCase.ordinal())
                    .append("'");
        }

        if (comparative != Comparative.NULL) {
            hql.append(" AND")
                    .append(" comparative = ")
                    .append("'")
                    .append(comparative.ordinal())
                    .append("'");
        }

        if (animate != Animate.NULL) {
            hql.append(" AND")
                    .append(" animate = ")
                    .append("'")
                    .append(animate.ordinal())
                    .append("'");
        }

        if (adverbType != AdverbType.NULL) {
            hql.append(" AND")
                    .append(" adverbType = ")
                    .append("'")
                    .append(adverbType.ordinal())
                    .append("'");
        }

        if (face != Face.NULL) {
            hql.append(" AND")
                    .append(" face = ")
                    .append("'")
                    .append(face.ordinal())
                    .append("'");
        }

        if (infinitive != Infinitive.NULL) {
            hql.append(" AND")
                    .append(" infinitive = ")
                    .append("'")
                    .append(infinitive.ordinal())
                    .append("'");
        }

        if (kind != Kind.NULL) {
            hql.append(" AND")
                    .append(" kind = ")
                    .append("'")
                    .append(kind.ordinal())
                    .append("'");
        }

        if (perfect != Perfect.NULL) {
            hql.append(" AND")
                    .append(" perfect = ")
                    .append("'")
                    .append(perfect.ordinal())
                    .append("'");
        }

        if (reflexive != Reflexive.NULL) {
            hql.append(" AND")
                    .append(" reflexive = ")
                    .append("'")
                    .append(reflexive.ordinal())
                    .append("'");
        }

        if (time != Time.NULL) {
            hql.append(" AND")
                    .append(" time = ")
                    .append("'")
                    .append(time.ordinal())
                    .append("'");
        }

        if (transitive != Transitive.NULL) {
            hql.append(" AND")
                    .append(" transitive = ")
                    .append("'")
                    .append(transitive.ordinal())
                    .append("'");
        }

        if (voice != Voice.NULL) {
            hql.append(" AND")
                    .append(" voice = ")
                    .append("'")
                    .append(voice.ordinal())
                    .append("'");
        }
        System.out.println(hql.toString());

        return hql.toString();
    }
}
