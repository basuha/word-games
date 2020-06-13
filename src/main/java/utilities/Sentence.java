package utilities;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    protected List<String> sentence = new ArrayList<>();

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
        sentence.add(word.getWord());
        return this;
    }

    public Sentence add(List<IWord> word) {
        for (IWord w : word) {
            add(w);
        }
        return this;
    }

    public boolean isEmpty() {
        return sentence.isEmpty();
    }

    public int size() {
        return sentence.size();
    }

    @Override
    public String toString() {
        return StringUtils.capitalize(String.join(" ", sentence) + ". ");
    }
}
