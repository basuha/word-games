package gui;

import words.Word;

public class HibernateThread extends Thread {

    private int IID;
    Word word;

    public HibernateThread(int IID) {
        this.IID = IID;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public synchronized void run() {
        word = Word.findById(IID);
        notify();
    }
}
