package gui;

import words.Word;

public class HibernateThread extends Thread {
    @Override
    public void run() {
        Word word = Word.findById(4159183);
        System.out.println(word.getInfo());

        for (Word w : word.getCognates()) {
            System.out.println(w.getInfo());
        }

    }
}
