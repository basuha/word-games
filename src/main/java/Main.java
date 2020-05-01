import utilities.Dictionary;
import utilities.RandomWord;
import words.Word;
import words.attributes.Gender;
import words.attributes.Plural;
import words.attributes.WordCase;
import words.primary.Adjective;
import words.primary.ExtraParticiple;
import words.primary.Noun;

import java.util.Random;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        Adjective adjective = new Adjective();
        Noun noun = new Noun();

        adjective.setParam(Gender.FEMALE);
        adjective.setParam(WordCase.NOMINATIVE);

        noun.setParam(Gender.FEMALE);
        noun.setParam(WordCase.Noun.NOMINATIVE);

        RandomWord randomWord = new RandomWord(adjective);
        RandomWord randomWord2 = new RandomWord(noun);

        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
        System.out.println(randomWord.get() + " " + randomWord2.get());
    }
}
