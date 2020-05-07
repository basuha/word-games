import utilities.*;
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
//
//        RandomSentenceBuilder randomSentenceBuilder = new RandomSentenceBuilder();
//        randomSentenceBuilder
//                            .append(new Adjective()
//                                    .setParam(Gender.MALE)
//                                    .setParam(WordCase.NOMINATIVE))
//                            .append(new Noun()
//                                    .setParam(Gender.MALE)
//                                    .setParam(Plural.SINGULAR)
//                                    .setParam(WordCase.Noun.NOMINATIVE))
//                            .append(new Adverb())
//                            .append(new Verb()
//                                    .setParam(Gender.MALE)
//                                    .setParam(Plural.SINGULAR)
//                                    .setParam(Kind.SECOND));

        RandomSentenceBuilder randomSentenceBuilder = new RandomSentenceBuilder();
        randomSentenceBuilder
                .append(new Adjective()
                        .setParam(Gender.MALE)
                        .setParam(WordCase.NOMINATIVE))
                .append(new Noun()
                        .setParam(Gender.MALE)
                        .setParam(Plural.SINGULAR)
                        .setParam(WordCase.Noun.NOMINATIVE))
                .append(new Verb()
                        .setParam(Gender.MALE)
                        .setParam(Plural.SINGULAR)
                        .setParam(Kind.SECOND)
                        .setParam(Reflexive.NOT_REFLEXIVE))
                .append(new Noun()
                        .setParam(WordCase.Noun.ACCUSATIVE)
                        .setParam(Plural.SINGULAR));


        for (Sentence s : randomSentenceBuilder.getResultList()) {
            System.out.println(s);
        }


//        SentenceGenerator sentenceGenerator = new SentenceGenerator();
//        sentenceGenerator.init();
    }
}
