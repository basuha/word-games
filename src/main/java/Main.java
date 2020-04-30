import utilities.Type;
import utilities.Dictionary;
import words.Word;
import words.primary.Participle;
import words.secondary.Particle;
import words.secondary.Pronoun;

import java.util.ArrayList;
import java.util.List;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {

//        Words.Word word = new Words.Word("penis");
//        dictionary.addWord(word);
//
//        for (Words.Word w : dictionary.getWordList()) {
//            System.out.println(w.getCode() + "|" + w.getCodeParent());
//        }
//
//        System.out.println(dictionary.getWordById(3).getWord());

//        Adjective adjective = new Adjective();
//        adjective.setWord("хуевый");
//        adjective.setCode(1234545);
//        adjective.setCodeParent(0);
//        adjective.setSubType(Adjective.SubType.IMMUTABLE);
//        adjective.setPlural(false);
//        adjective.setGender(Adjective.Gender.MALE);
//        adjective.setwCase(Adjective.WCase.NOMINATIVE);
//        adjective.setShortF(false);
//
//        Word word = new Word();
//        word.setWord("Пиздатый");
//        word.setCode(12312444);
//        word.setType(Type.ADJECTIVE);
//
//        Word word1 = new Particle("хуй",123);
//
//
//
//        dictionary.addWord(word1);
//        Word word2 = dictionary.getWordById(29662);
//
//        System.out.println(word2 instanceof Adjective);
//        System.out.println(word2);
//        Dictionary dictionary = new Dictionary();
//        ArrayList<Word> list = new ArrayList<>();
//        list.add(dictionary.getRandomWord(Type.ADJECTIVE));
//        list.add(dictionary.getRandomWord(Type.ADVERB));
//        list.add(dictionary.getRandomWord(Type.CONJUNCTION));
//        list.add(dictionary.getRandomWord(Type.EXTRA_PARTICIPLE));
//        list.add(dictionary.getRandomWord(Type.INTERJECTION));
//        list.add(dictionary.getRandomWord(Type.NUMERAL));
//        list.add(dictionary.getRandomWord(Type.PARENTHESIS));
//        list.add(dictionary.getRandomWord(Type.PARTICIPLE));
//        list.add(dictionary.getRandomWord(Type.PARTICLE));
//        list.add(dictionary.getRandomWord(Type.PARTICLE));
//        list.add(dictionary.getRandomWord(Type.PARTICLE));
//        list.add(dictionary.getRandomWord(Type.PARTICLE));
//        list.add(dictionary.getRandomWord(Type.PREDICATE));
//        list.add(dictionary.getRandomWord(Type.PRETEXT));
//        list.add(dictionary.getRandomWord(Type.VERB));

//        for (Word w : list) {
//            System.out.println(w.getInfo());
//        }
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.getRandomWord(Type.PARTICLE));
        System.out.println(dictionary.getRandomWord(Type.ADJECTIVE));
        System.out.println(dictionary.getRandomWord(Type.ADVERB));
        System.out.println(dictionary.getRandomWord(Type.PARTICIPLE));
        System.out.println(dictionary.getRandomWord(Type.NOUN));


//        word3.setGender(Adjective.Gender.FEMALE);
//        word3.reload();
//        for (Word a : word3.getCognates()) {
//            System.out.println(a);
//        }

    }
}
