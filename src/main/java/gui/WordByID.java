package gui;

import utilities.Word;

public class WordByID extends Thread {

    private int IID;
    Word word;

    public WordByID(int IID) {
        this.IID = IID;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public void run() {
        word = Word.findById(IID);
    }
}
