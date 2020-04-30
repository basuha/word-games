import utilities.Dictionary;
import words.attributes.Plural;
import words.attributes.WCase;
import words.primary.Adjective;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        Adjective adjective = new Adjective();
        System.out.println(adjective.getInfo());

        adjective.setParam(Plural.PLURAL);
        adjective.setParam(WCase.DATIVE);
        System.out.println(adjective.getInfo());

        Dictionary dictionary = new Dictionary();

        for(Adjective a : dictionary.getWordsByAttrib(adjective)) {
            System.out.println(a);
        }
    }
}
