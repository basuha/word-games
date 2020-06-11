package utilities;

import com.google.inject.internal.cglib.reflect.$FastMember;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WRandSentence {
    private List<IWord> inputWordList = new ArrayList<>();
    private List<List<IWord>> rawResultSet = new ArrayList<>();
    private List<Sentence> resultSet = new ArrayList<>();

    public WRandSentence() {
    }

    public WRandSentence(List<IWord> inputWordList) {
        this.inputWordList.addAll(inputWordList);
    }

//    public WRandSentence(List<Sentence> hexCodeList) { //todo this
//        this.inputWordList.addAll();
//    }

    public WRandSentence append(IWord iWord) {
        inputWordList.add(iWord);
        return this;
    }

    public WRandSentence append(String hexCode) {
        inputWordList.add(new WSearch(hexCode));
        return this;
    }

    public List<Sentence> getResultSet() {
        return resultSet;
    }

    public void build() {
        search();
        generateResultSet();
    }

    private void search() {
        for (IWord w : inputWordList) { //todo multithreading
            WAsyncTask wAsyncTask = new WAsyncTask(w);
            Thread thread = new Thread(wAsyncTask);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rawResultSet.add(wAsyncTask.getList());
        }
    }

    private void generateResultSet() {
        Sentence sentence;
        do {
            sentence = new Sentence();
            for (List<IWord> l : rawResultSet) {
                for (IWord w : l) {
                    sentence.add(w);
                    l.remove(w);
                    break;
                }
            }
            if (sentence.size()
                    == inputWordList.size())
                resultSet.add(sentence);
        } while (!sentence.isEmpty());
    }
}
