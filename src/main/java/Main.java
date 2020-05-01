import utilities.Dictionary;
import utilities.RandomWord;
import words.Word;
import words.attributes.Gender;
import words.attributes.Plural;
import words.attributes.WordCase;
import words.primary.Adjective;
import words.primary.ExtraParticiple;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        Adjective adjective = new Adjective();
        System.out.println(adjective.getInfo());

        adjective.setParam(Plural.SINGULAR);
        adjective.setParam(Gender.MALE);
        adjective.setParam(WordCase.NOMINATIVE);
        System.out.println(adjective.getInfo());

        Dictionary dictionary = new Dictionary();

        RandomWord randomWord = new RandomWord(adjective);

        for(Word a : randomWord.getRandomWords()) {
            System.out.println(a);
        }

        ExtraParticiple participle = new ExtraParticiple();
    }
}
