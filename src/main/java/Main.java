import utilities.*;
import words.attributes.primary.*;
import words.primary.Adjective;
import words.primary.Adverb;
import words.primary.Noun;
import words.primary.Verb;

import java.io.IOException;
import java.util.Random;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
//        long a = System.currentTimeMillis();
//        WRandom wRandom = new WRandom("9");
//
//        long b = System.currentTimeMillis();
//        WRandom wRandom1 = new WRandom("9");
//
//        System.out.println(wRandom.getSingleWord() + " " + wRandom1.getSingleWord());
//        long c = System.currentTimeMillis();
//
//        System.out.println(b - a);
//        System.out.println(c - a);

//        Adverb adverb = new Adverb().setAdverbType(AdverbType.PURPOSE);
//        Word word = Word.findById(new Random().nextInt(Word.getMaxID()));

//        WordToHex wordToHex = new WordToHex(adverb);
//        int a = wordToHex.attribToHex(adverb.getAdverbType());
//        System.out.println(word.getHexCode());
//        System.out.println(word.getInfo());

//        Sentence sentence = new WParser(WAstro.getByID(2).toString());
//        System.out.println(sentence);


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
//        WRandomSentence randomSentenceBuilder = new WRandomSentence();
//        randomSentenceBuilder
//                            .append(new Adjective()
//                                    .setGender(Gender.MALE)
//                                    .setWordCase(WordCase.NOMINATIVE))
//                            .append(new Noun()
//                                    .setGender(Gender.MALE)
//                                    .setPlural(Plural.SINGULAR)
//                                    .setWordCase(WordCase.NOMINATIVE))
//                            .append(new Adverb())
//                            .append(new Verb()
//                                    .setGender(Gender.MALE)
//                                    .setPlural(Plural.SINGULAR)
//                                    .setKind(Kind.SECOND));
//
//        for (Sentence s : randomSentenceBuilder.getResultList()) {
//            System.out.println(s);
//        }


//        Credentials credentials = new Credentials("grajdanin233","AgAAAAAjlVJgAAZfbnHU08Ypa07fuEW8hR_0uvc");
//        TransportClient tc = null;
//        try {
//            tc = TransportClient.getInstance(credentials);
//        } catch (WebdavClientInitException e) {
//            System.out.println(e);
//        }
//        assert tc != null;
//        try {
//            tc.uploadFile("D:/dictionary-wg.db", null, null);
//        } catch (IOException | IntermediateFolderNotExistException | WebdavUserNotInitialized | PreconditionFailedException | WebdavNotAuthorizedException | ServerWebdavException | UnknownServerWebdavException  e) {
//            e.printStackTrace();
//        }

        Word wRandom = new WRandom(new Noun()).getSingleWord();
        System.out.println(wRandom.getWord());

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
