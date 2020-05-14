package utilities;

import words.Word;
import words.primary.*;
import words.secondary.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSentenceBuilder {

    private List<Word> wordsList = new ArrayList<>();
    private Sentence sentence = new Sentence();
    private List<Sentence> sentences = new ArrayList<>();
    private List<List<Word>> words = new ArrayList<>();
    private Random random = new Random();

    public RandomSentenceBuilder append(Word word) {
        wordsList.add(word);
        return this;
    }

    public String getSingleResult() {
        for (int i = 0; i < wordsList.size(); i++) {
            sentence.add(new RandomWord(wordsList.get(i)).getSingleWord().toString());
            sentence.add(" ");
        }
        return sentence.toString();
    }

    public List<Sentence> getResultList() {
        for (int i = 0; i < wordsList.size(); i++) {
            List<Word> list = new RandomWord(wordsList.get(i)).getList();
            if (list.size() != 0) {
                words.add(list);
            } else { //если слов по запросу не найдено
                List<Word> list2 = new ArrayList<>();
                list2.add(new Word().setWord(wordsList.get(i).getPartOfSpeech() + " не найдено"));
                words.add(list2);
            }
        }

        List<Integer> listSizes = new ArrayList<>();
        for (List<Word> l : words) {
            listSizes.add(l.size());
        }

        List<Integer> listSizesNotSorted = new ArrayList<>();
        for (List<Word> l : words) {
            listSizesNotSorted.add(l.size());
        }

        Integer buff;
        do { //пузырьковая сортировка для определения самого короткого столбца слов
            buff = null;
            for (int i = 0; i < listSizes.size() - 1; i++) {
                if (listSizes.get(i) > listSizes.get(i + 1)) {
                    buff = listSizes.get(i);
                    listSizes.set(i,listSizes.get(i + 1));
                    listSizes.set(i + 1, buff);
                }
            }
        } while (buff != null);

        int minSize = listSizes.get(0);

        if (minSize != 0) { //построение предложений из слов
            for (int i = 0; i < minSize; i++) {
                Sentence sentence = new Sentence();
                for (int j = 0; j < 4; j++) {
                    sentence.add(words.get(j).get(random.nextInt(listSizesNotSorted.get(j))).toString());
                }
                sentences.add(sentence);
            }
            return sentences;
        } else {
            return null;
        }
    }
}
