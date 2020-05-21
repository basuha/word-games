package utilities;

import java.util.ArrayList;
import java.util.List;

public class WParser extends Sentence {
    private String[] parsed;
    private List<String> parsedHexes = new ArrayList<>();
    private List<Word> words = new ArrayList<>();


    public WParser(String sentence) {
        parsed = sentence.split(" ");
        for (int i = 0; i < parsed.length; i++) {
            if (parsed[i].charAt(0) == '#') {
                parsedHexes.add(parsed[i]);
            }
        }
        System.out.println(parsedHexes);
    }
}
