package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

public class WordToHex extends Word {
    private Word word;

    public WordToHex(Word word) {
        this.word = word;
    }

    public int attribToHex(String partOfSpeech) {
        switch (partOfSpeech) {
            case ADJECTIVE:
                return 1;
            case ADVERB:
                return 2;
            case EXTRA_PARTICIPLE:
                return 3;
            case NOUN:
                return 4;
            case NUMERAL:
                return 5;
            case PARTICIPLE:
                return 6;
            case VERB:
                return 7;
            case CONJUNCTION:
                return 8;
            case INTERJECTION:
                return 9;
            case PARENTHESIS:
                return 0xA;
            case PARTICLE:
                return 0xB;
            case PREDICATE:
                return 0xC;
            case PRETEXT:
                return 0xD;
            case PRON_ADJ:
            case PRON_ADV:
            case PRON_NOUN:
                return 0xE;
        }
        return 0;
    }

    public int attribToHex(AdverbType adverbType) {
        switch (adverbType) {
            case QUALITATIVE:
                return 1;
            case METHOD:
                return 2;
            case EXTENT:
                return 3;
            case PLACE:
                return 4;
            case DIRECTION:
                return 5;
            case TIMING:
                return 6;
            case PURPOSE:
                return 7;
            case REASON:
                return 8;
        }
        return 0;
    }
    public int attribToHex(Animate animate) {

        return 0;
    }
    public int attribToHex(Gender gender) {
        return 0;
    }
    public int attribToHex(Kind kind) {
        return 0;
    }
    public int attribToHex(Plural plural) {
        return 0;
    }
    public int attribToHex(Time time) {
        return 0;
    }
    public int attribToHex(Type type) {
        return 0;
    }
    public int attribToHex(WordCase wordCase) {
        return 0;
    }

    public int attribToHex(Comparative comparative) {
        return 0;
    }
    public int attribToHex(Face face) {
        return 0;
    }
    public int attribToHex(Infinitive infinitive) {
        return 0;
    }
    public int attribToHex(Perfect perfect) {
        return 0;
    }
    public int attribToHex(Reflexive reflexive) {
        return 0;
    }
    public int attribToHex(ShortF shortF) {
        return 0;
    }
    public int attribToHex(Transitive transitive) {
        return 0;
    }
    public int attribToHex(Voice voice) {
        return 0;
    }
}
