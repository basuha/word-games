package utilities;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WChangeling {
    private String input;
    private String output;
    private List<Word> words;
    private List<List<Word>> rawWordsList = new ArrayList<>();
    private List<Word> wordList = new ArrayList<>();
    private List<String> hexesList = new ArrayList<>();
    private WRandSentence generator = new WRandSentence();
    public List<Sentence> resultSet = new ArrayList<>();

    public WChangeling(String input) {
        this.input = input.toLowerCase();
    }

    public void process() {
        findWordsByQuery();
        generateWordsList();
        getHexesList();
        generateRandomSentence();
    }

    public String get() {
        return resultSet.get(new Random().nextInt(resultSet.size())).toString();
    }

    private void generateRandomSentence() {
        for(String s : hexesList) {
            generator.append(s);
        }
        generator.build();
        resultSet.addAll(generator.getResultSet());
    }

    private void getHexesList() {
        for (Word w : wordList)
            hexesList.add(new WordToHex(w).get());
    }

    private void generateWordsList() {
        for (List<Word> l : rawWordsList)
            for (Word w : l) {
                wordList.add(w);
                break;
            }
    }

    private void findWordsByQuery() {
        System.out.println(input);
        for (String s : input.split(" "))
            rawWordsList.add(Word.find(s));
    }
}

class Main {
    public static void main(String[] args) {
        WChangeling wChangeling = new WChangeling("Мама мыла раму");
        wChangeling.process();
        System.out.println(wChangeling.resultSet);
    }
}