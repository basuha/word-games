package utilities;

import java.util.List;


/**
 * Класс-обертка для StringBuilder
 */
public class Sentence {
    private int counter = 0;
    private StringBuilder sentence = new StringBuilder();

    public Sentence(){

    }

    public Sentence(List<Word> word) {
        add(word);
    }

    public Sentence(Word word) {
        add(word.toString());
    }

    public Sentence(String word) {
        add(word);
    }

    public Sentence add(String word) {
        if (counter == 0) {
            sentence.append(firstUpperCase(word));
        } else {
            sentence.append(" ")
                    .append(word);
        }
        counter++;
        return this;
    }

    public Sentence add(List<Word> word) {
        for (Word s : word) {
            add(s.toString());
        }
        return this;
    }

    private static String firstUpperCase(String word){
        if (word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    @Override
    public String toString() {
        return sentence.toString() + ".";
    }
}
