package utilities;

import words.Word;


/**
 * Знаки зодиака
 */
public enum Zodiac {

    /** Овен */
    ARIES(Word.findById(1915804)),

    /** Телец */
    TAURUS(Word.findById(3698999)),

    /** Близнецы */
    GEMINI(Word.findById(139085)),

    /** Рак */
    CANCER(Word.findById(3191028)),

    /** Лев */
    LEO(Word.findById(1327535)),

    /** Дева */
    VIRGO(Word.findById(594043)),

    /** Весы */
    LIBRA(Word.findById(216000)),

    /** Скорпион */
    SCORPIO(Word.findById(3470330)),

    /** Стрелец */
    SAGITTARIUS(Word.findById(3635743)),

    /** Козерог */
    CAPRICORN(Word.findById(1206327)),

    /** Водолей */
    AQUARIUS(Word.findById(274806)),

    /** Рыбы */
    PISCES(Word.findById(3335797));

    private final Word word;

    Zodiac(Word word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word.toString();
    }

    public Word getWord() {
        return word;
    }
}
