package utilities;

import java.util.ArrayList;
import java.util.List;

public class WParser {
    private List<String> parsed = new ArrayList<>();

    public WParser(String sentence) {
        this.parsed.add(sentence.substring(sentence.indexOf("#")));
    }
}
