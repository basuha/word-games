import utilities.Dictionary;
import utilities.RandomWord;
import words.Word;
import words.attributes.*;
import words.attributes.Short;
import words.primary.Adjective;
import words.primary.ExtraParticiple;
import words.primary.Noun;

import java.util.Random;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
//        RandomWord randomWord = new RandomWord(new Adjective()
//                .addParam(WordCase.NOMINATIVE)
//                .addParam(Plural.PLURAL));
//
//        RandomWord randomWord2 = new RandomWord(new Noun());
//
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());
//        System.out.println(randomWord.get() + " " + randomWord2.get());

        Adjective adjective = new Adjective();
        System.out.println(adjective.getInfo());

        adjective.setParam(Gender.N_A);
        System.out.println(adjective.getInfo());

        adjective.setParam(Type.Adjective.MUTABLE);
        System.out.println(adjective.getInfo());

        adjective.setParam(Plural.PLURAL);
        System.out.println(adjective.getInfo());

        adjective.setParam(Plural.PLURAL)
                .setParam(WordCase.INSTRUMENTAL)
                .setParam(Gender.FEMALE);
        System.out.println(adjective.getInfo());

    }
}
