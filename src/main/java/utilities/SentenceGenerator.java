package utilities;

import org.hibernate.Session;
import words.Word;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceGenerator {
    private String inputSentence;
    private final Scanner SCANNER = new Scanner(System.in);
    private ArrayList<String> separatedWords = new ArrayList<>();
    private ArrayList<Word> wordsList = new ArrayList<>();
    private int wordCount;
    Random random = new Random();

    private List<List<Word>> resultSet = new ArrayList<>();
    private List<Word> output = new ArrayList<>();
    private StringBuilder outString = new StringBuilder();

    public void init() {
        System.out.println("Введите предложение: ");
        inputSentence = SCANNER.nextLine();
        wordSeparator();
        find();
        for (List<Word> l : resultSet) {
//            for (Word w : l) {
                output.add(new WRandom(l.get(0)).getSingleWord());
//            }
        }
        for (Word w : output) {
            outString.append(w).append(" ");
        }
        System.out.println(outString.toString());
    }

    private void wordSeparator(){
        Pattern pattern =
                Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputSentence);
        while (matcher.find()) {
            wordCount++;
            separatedWords.add(matcher.group().toLowerCase());
        }
    }

    private void findWord(String word) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Word WHERE word = :word");
        query.setParameter("word", word);
        List<Word> words = query.getResultList();
        resultSet.add(words);
        session.close();
    }

    private void find() {
        for (int i = 0; i < wordCount; i++) {
            findWord(separatedWords.get(i));
        }
    }
}
