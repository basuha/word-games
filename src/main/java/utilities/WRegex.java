package utilities;

import words.attributes.*;
import words.primary.Participle;
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
        run();
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
        switch (partOfSpeech) {
            case ADJECTIVE:
                switch (hexCode.get(4)) {
                    case 1:
                        setType(Type.Adjective.IMMUTABLE);
                        break;
                    case 2:
                        setType(Type.Adjective.MUTABLE);
                        break;
                }
                break;
            case ADVERB:
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
                break;
            case NUMERAL:
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
                break;
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
        switch (hexCode.get(6)){
            case 0:
                adverbType = null;
                break;
            case 1:
                setAdverbType(AdverbType.QUALITATIVE);
                break;
            case 2:
                setAdverbType(AdverbType.METHOD);
                break;
            case 3:
                setAdverbType(AdverbType.EXTENT);
                break;
            case 4:
                setAdverbType(AdverbType.PLACE);
                break;
            case 5:
                setAdverbType(AdverbType.DIRECTION);
                break;
            case 6:
                setAdverbType(AdverbType.TIMING);
                break;
            case 7:
                setAdverbType(AdverbType.PURPOSE);
                break;
            case 8:
                setAdverbType(AdverbType.REASON);
                break;
        }
        switch (hexCode.get(7)){
            case 0:
                transitive = null;
                break;
            case 1:
                setTransitive(Transitive.TRANSITIVE);
                break;
            case 2:
                setTransitive(Transitive.INTRANSITIVE);
                break;
            case 3:
                setTransitive(Transitive.TRANS_INTRANS);
                break;
        }
        switch (hexCode.get(8)){
            case 0:
                animate = null;
                break;
            case 1:
                setAnimate(Animate.ANIMATE);
                break;
            case 2:
                setAnimate(Animate.INANIMATE);
                break;
            case 0xF:
                setAnimate(Animate.N_A);
                break;
        }
        switch (hexCode.get(9)){
            case 0:
                voice = null;
                break;
            case 1:
                setVoice(Voice.ACTIVE);
                break;
            case 2:
                setVoice(Voice.PASSIVE);
                break;
            case 0xF:
                voice = "n/a";
                break;
        }
        switch (hexCode.get(10)){
            case 0:
                perfect = null;
                break;
            case 1:
                setPerfect(Perfect.PERFECT);
                break;
            case 2:
                setPerfect(Perfect.NOT_PERFECT);
                break;
            case 3:
                setPerfect(Perfect.N_A);
                break;
        }
        switch (hexCode.get(11)){
            case 0:
                kind = null;
                break;
            case 1:
                setKind(Kind.FIRST);
                break;
            case 2:
                setKind(Kind.SECOND);
                break;
            case 0xF:
                kind = "n/a";
                break;
        }
        switch (hexCode.get(12)){
            case 0:
                comparative = null;
                break;
            case 1:
                setComparative(Comparative.COMPARATIVE);
                break;
            case 2:
                setComparative(Comparative.SUPER);
                break;
            case 0xF:
                setComparative(Comparative.N_A);
                break;
        }
        switch (hexCode.get(13)){
            case 0:
                infinitive = null;
                break;
            case 1:
                setInfinitive(Infinitive.INFINITIVE);
                break;
            case 2:
                setInfinitive(Infinitive.NOT);
                break;
            case 0xF:
                setInfinitive(Infinitive.N_A);
                break;
        }
    }
}
