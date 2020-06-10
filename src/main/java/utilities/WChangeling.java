package utilities;

import java.util.List;

public class WChangeling {
    private String input;
    private String output;
    private List<Word> words;
    private List<List<Word>> rawWordsList;
    private List<Word> wordList;
    private List<String> hexesList;

    public WChangeling(String input) {
        this.input = input;
    }

    public String get() {
        findWordsByQuery();
        generateWordsList();
        getHexesList();
        return output;
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
        for (String s : input.split(" "))
            rawWordsList.add(Word.find(s));
    }
}

class Main {
    public static void main(String[] args) {

    }
}