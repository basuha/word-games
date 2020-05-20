package utilities;

import words.attributes.*;
import words.primary.Verb;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * 0. Часть речи
 * 1. Падеж
 * 2. Пол
 * 3. Число
 * 4. Тип
 * 5. Время
 * 6. Тип наречия
 */
public class WRegex extends WRandom {
    private final List<Byte> hexCode = new ArrayList<>();

//    Integer.toHexString(int i)

    public WRegex(String hexCode) {
        for (int i = 0; i < hexCode.length(); i++) {
            this.hexCode.add(toDigit(hexCode.charAt(i)));
        }
        init();
        System.out.println(this.hexCode);
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
        switch (hexCode.get(1)){
            case 0:
                wordCase = null;
                break;
            case 1:
                setWordCase(WordCase.NOMINATIVE);
                break;
            case 2:
                setWordCase(WordCase.GENITIVE);
                break;
            case 3:
                setWordCase(WordCase.DATIVE);
                break;
            case 4:
                setWordCase(WordCase.ACCUSATIVE);
                break;
            case 5:
                setWordCase(WordCase.INSTRUMENTAL);
                break;
            case 6:
                setWordCase(WordCase.PREPOSITIONAL);
                break;
            case 7:
                setWordCase(WordCase.VOCATIVE);
                break;
            case 8:
                setWordCase(WordCase.PARTITIVE);
                break;
            case 9:
                setWordCase(WordCase.LOCATIVE);
                break;
            case 0xA:
                setWordCase(WordCase.COUNTING);
                break;
            case 0xF:
                setWordCase(WordCase.N_A);
                break;

        }
        switch (hexCode.get(2)){
            case 0:
                gender = null;
                break;
            case 1:
                setGender(Gender.MALE);
                break;
            case 2:
                setGender(Gender.FEMALE);
                break;
            case 3:
                setGender(Gender.NEUTER);
                break;
            case 4:
                setGender(Gender.COMMON);
                break;
            case 0xF:
                setGender(Gender.N_A);
                break;
        }
        switch (hexCode.get(3)){
            case 0:
                plural = null;
                break;
            case 1:
                setPlural(Plural.PLURAL);
                break;
            case 2:
                setPlural(Plural.SINGULAR);
                break;
            case 0xF:
                setPlural(Plural.N_A);
                break;

        }
        switch (hexCode.get(4)) {
            case 0:
                type = null;
                break;
        }
        if (partOfSpeech.equals(ADJECTIVE)) {
            switch (hexCode.get(4)) {
                case 1:
                    setType(Type.Adjective.IMMUTABLE);
                    break;
                case 2:
                    setType(Type.Adjective.MUTABLE);
                    break;
            }
        }
        if (partOfSpeech.equals(ADVERB)) {
            switch (hexCode.get(4)) {
                case 1:
                    setType(Type.Adverb.EXTENSIVE);
                    break;
                case 2:
                    setType(Type.Adverb.DEFINITE);
                    break;
                case 3:
                    setType(Type.Adverb.QUESTION);
                    break;
            }
        }
        if (partOfSpeech.equals(NUMERAL)) {
            switch (hexCode.get(4)) {
                case 1:
                    setType(Type.Numeral.ORDINAL);
                    break;
                case 2:
                    setType(Type.Numeral.QUANTITATIVE);
                    break;
                case 3:
                    setType(Type.Numeral.COLLECTIVE);
                    break;
                case 4:
                    setType(Type.Numeral.INDEFINITE);
                    break;
            }
        }
        switch (hexCode.get(5)){
            case 0:
                time = null;
                break;
            case 1:
                setTime(Time.PAST);
                break;
            case 2:
                setTime(Time.PRESENT);
                break;
            case 3:
                setTime(Time.FUTURE);
                break;
        }
        switch (hexCode.get(6)){}
        switch (hexCode.get(7)){}
        switch (hexCode.get(8)){}
        switch (hexCode.get(9)){}
        switch (hexCode.get(10)){}
        switch (hexCode.get(11)){}
        switch (hexCode.get(12)){}
        switch (hexCode.get(13)){}
    }
}
