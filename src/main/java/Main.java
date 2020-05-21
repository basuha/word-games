import utilities.*;
import words.primary.Noun;

import java.util.Random;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
//        long a = System.currentTimeMillis();
//        WRandom WRandom1 = new WRandom(new Noun());
//
//        long b = System.currentTimeMillis();
//        WRandom WRandom2 = new WRandom(new Noun());
//
//        System.out.println(WRandom1.getSingleWord() + " " + WRandom2.getSingleWord());
//        long c = System.currentTimeMillis();
//
//        System.out.println(b - a);
//        System.out.println(c - a);
        WRandom wRandom = new WRandom("1325");
        System.out.println(wRandom.getSingleWord());

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
//        System.out.println(Zodiac.CANCER);
//        System.out.println(Zodiac.GEMINI);
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
