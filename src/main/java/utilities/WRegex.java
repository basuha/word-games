package utilities;

import words.primary.Verb;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. Часть речи
 * 2. Падеж
 * 3. Число
 * 4.
 */
public class WRegex extends WRandom {
    private final List<Byte> hexCode = new ArrayList<>();

//    Integer.toHexString(int i)

    public WRegex(String hexCode) {
        for (int i = 0; i < hexCode.length(); i++) {
            this.hexCode.add(toDigit(hexCode.charAt(i)));
        }
//        init();
//        System.out.println(this.hexCode);
    }

    private byte toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: "+ hexChar);
        }
        return (byte) digit;
    }

    private void init() {
        switch (hexCode.get(0)){
            case 0:
                setPartOfSpeech(null);
                break;
            case 1:
                setPartOfSpeech(ADJECTIVE);
                break;
            case 2:
                setPartOfSpeech(ADVERB);
                break;
            case 3:
                setPartOfSpeech(EXTRA_PARTICIPLE);
                break;
            case 4:
                setPartOfSpeech(NOUN);
                break;
            case 5:
                setPartOfSpeech(NUMERAL);
                break;
            case 6:
                setPartOfSpeech(PARTICIPLE);
                break;
            case 7:
                setPartOfSpeech(VERB);
                break;
            case 8:
                setPartOfSpeech(CONJUNCTION);
                break;
            case 9:
                setPartOfSpeech(INTERJECTION);
                break;
            case 0xA:
                setPartOfSpeech(PARENTHESIS);
                break;
            case 0xB:
                setPartOfSpeech(PARTICLE);
                break;
            case 0xC:
                setPartOfSpeech(PREDICATE);
                break;
            case 0xD:
                setPartOfSpeech(PRETEXT);
                break;
            case 0xE:
                setPartOfSpeech(PRONOUN);
                break;
        }
    }
}
