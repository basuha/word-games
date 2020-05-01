import utilities.Dictionary;
import words.attributes.Plural;
import words.attributes.WordCase;
import words.primary.Adjective;
import words.primary.ExtraParticiple;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        Adjective adjective = new Adjective();
        System.out.println(adjective.getInfo());

        adjective.setParam(Plural.PLURAL);
        adjective.setParam(WordCase.DATIVE);
        System.out.println(adjective.getInfo());

        Dictionary dictionary = new Dictionary();

        for(Adjective a : dictionary.getWordsByAttrib(adjective)) {
            System.out.println(a);
        }
        ExtraParticiple participle = new ExtraParticiple();
    }
}
