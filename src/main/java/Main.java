import Words.Adjective;
import Words.Particle;
import Words.Type;
import Words.Word;

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

        Adjective adjective = new Adjective();
        adjective.setWord("хуевый");
        adjective.setCode(1234545);
        adjective.setCodeParent(0);
        adjective.setSubType(Adjective.SubType.IMMUTABLE);
        adjective.setPlural(false);
        adjective.setGender(Adjective.Gender.MALE);
        adjective.setwCase(Adjective.WCase.NOMINATIVE);
        adjective.setShortF(false);

        Word word = new Word();
        word.setWord("Пиздатый");
        word.setCode(12312444);
        word.setType(Type.ADJECTIVE);

        Word word1 = new Particle("хуй",123);


        Dictionary dictionary = new Dictionary();
        dictionary.addWord(word1);
        Word word2 = dictionary.getWordById(29662);

        System.out.println(word2 instanceof Adjective);
        System.out.println(word2);

        Word word3 = dictionary.getRandomWord(Type.ADJECTIVE);
        System.out.println(word3);

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(word1);
//        session.getTransaction().commit();
//        session.close();
    }
}
