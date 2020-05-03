import utilities.Dictionary;
import utilities.RandomSentenceBuilder;
import utilities.RandomWord;
import utilities.SentenceGenerator;
import words.Word;
import words.attributes.*;
import words.attributes.Short;
import words.primary.*;

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
//        RandomSentenceBuilder randomSentenceBuilder = new RandomSentenceBuilder();
//        System.out.println(randomSentenceBuilder
//                .append(new Adjective()
//                        .setParam(Gender.MALE)
//                        .setParam(WordCase.NOMINATIVE))
//                .append(new Noun()
//                        .setParam(Gender.MALE)
//                        .setParam(Plural.SINGULAR)
//                        .setParam(WordCase.Noun.NOMINATIVE))
//                .append(new Adverb())
//                .append(new Verb()
//                        .setParam(Gender.MALE)
//                        .setParam(Plural.SINGULAR)
//                        .setParam(Kind.SECOND))
//                .build());

        SentenceGenerator sentenceGenerator = new SentenceGenerator();
        sentenceGenerator.init();
    }
}
