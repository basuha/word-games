import utilities.*;
import words.Word;
import words.attributes.Plural;
import words.attributes.WordCase;
import words.primary.Adjective;
import words.primary.Noun;

import java.util.List;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        RandomWord randomWord = new RandomWord(new Adjective()
                .setWordCase(WordCase.NOMINATIVE)
                .setPlural(Plural.PLURAL));

        RandomWord randomWord2 = new RandomWord(new Noun());
        randomWord.start();
        randomWord2.start();
        try {
            randomWord.join();
            randomWord2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
            System.out.println(randomWord.getSingleWord() + " " + randomWord2.getSingleWord());
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
//
//        RandomSentenceBuilder randomSentenceBuilder = new RandomSentenceBuilder();
//        randomSentenceBuilder
//                .append(new Adjective()
//                        .setParam(Gender.MALE)
//                        .setParam(WordCase.NOMINATIVE))
//                .append(new Noun()
//                        .setParam(Gender.MALE)
//                        .setParam(Plural.SINGULAR)
//                        .setParam(WordCase.Noun.NOMINATIVE))
//                .append(new Verb()
//                        .setParam(Gender.MALE)
//                        .setParam(Plural.SINGULAR)
//                        .setParam(Kind.SECOND)
//                        .setParam(Reflexive.NOT_REFLEXIVE))
//                .append(new Noun()
//                        .setParam(WordCase.Noun.ACCUSATIVE)
//                        .setParam(Plural.SINGULAR));
//
//
//        for (Sentence s : randomSentenceBuilder.getResultList()) {
//            System.out.println(s);
//        }
//
        System.out.println(Zodiac.CANCER);
        System.out.println(Zodiac.GEMINI);
//
//        Word word = Word.findById(4159183);
//        System.out.println(word.getInfo());
//
//        for (Word w : word.getCognates()) {
//            System.out.println(w.getInfo());
//        }
//

//        long a = System.currentTimeMillis();
//        for (Word w : word.getCognates()) {
//            System.out.println(w.getInfo());
//        }
//        System.out.println(System.currentTimeMillis() - a);

//        SentenceGenerator sentenceGenerator = new SentenceGenerator();
//        sentenceGenerator.init();
    }
}
