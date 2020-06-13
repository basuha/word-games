package utilities;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class WParser extends Sentence {
    private String[] parsed;
    private List<String> parsedHexes = new ArrayList<>();
    private List<Word> words = new ArrayList<>();

    public WParser(String sentence) {
        parsed = sentence.split(" ");
        for (int i = 0; i < parsed.length; i++) {
            if (parsed[i].charAt(0) == '0' && parsed[i].charAt(1) == 'x') {
                parsedHexes.add(parsed[i]);
                super.sentence.add(new WSearch(parsed[i].substring(2)).getSingleWord().getWord());
            } else {
                super.sentence.add(new WDummy(parsed[i]).getWord());
            }
        }
    }
}
