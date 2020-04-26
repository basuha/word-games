package Words;

public class Particle extends Word {

    public Particle(){}

    public Particle(String word, Integer code) {
        super.word = word;
        super.codeParent = 0;
        super.code = code;
        super.type = Type.PARTICLE;
    }
}
