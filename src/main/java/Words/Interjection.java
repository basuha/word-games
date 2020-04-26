package Words;

public class Interjection extends Word{

    public Interjection(){}

    public Interjection(String word, Integer code) {
        super.word = word;
        super.codeParent = 0;
        super.code = code;
        super.type = Type.INTERJECTION;
    }
}
