package utilities;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private int counter = 0;
    protected List<IWord> sentence = new ArrayList<>();

    public Sentence(){

    }

    public Sentence(List<IWord> word) {
        add(word);
    }

    public Sentence(IWord word) {
        add(word);
    }

    public Sentence(String word) {
        add(new WDummy(word));
    }

    public Sentence add(IWord word) {
        if (counter == 0) {
            sentence.add(word); //todo capitalization
        } else {
            sentence.add(word);
        }
        counter++;
        return this;
    }

    public Sentence add(List<IWord> word) {
        for (IWord w : word) {
            add(w);
        }
        return this;
    }

    private static String firstUpperCase(String word){
        if (word == null || word.isEmpty())
            return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < this.sentence.size(); i++) {
            sentence.append(this.sentence.get(i));
            if (i != this.sentence.size()) {
                sentence.append(" ");
            }
        }
        return sentence.toString() + ".";
    }
}
