package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

public class WordToHex extends Word {
    private Word word;

    public WordToHex(Word word) {
        this.word = word;
    }

    public int attribToHex(String partOfSpeech) {
        return switch (partOfSpeech) {
            case ADJECTIVE -> 1;
            case ADVERB -> 2;
            case EXTRA_PARTICIPLE -> 3;
            case NOUN -> 4;
            case NUMERAL -> 5;
            case PARTICIPLE -> 6;
            case VERB -> 7;
            case CONJUNCTION -> 8;
            case INTERJECTION -> 9;
            case PARENTHESIS -> 0xA;
            case PARTICLE -> 0xB;
            case PREDICATE -> 0xC;
            case PRETEXT -> 0xD;
            case PRON_ADJ, PRON_ADV, PRON_NOUN -> 0xE;
            default -> 0;
        };
    }

    public int attribToHex(AdverbType adverbType) {
        return switch (adverbType) {
            case QUALITATIVE -> 1;
            case METHOD -> 2;
            case EXTENT -> 3;
            case PLACE -> 4;
            case DIRECTION -> 5;
            case TIMING -> 6;
            case PURPOSE -> 7;
            case REASON -> 8;
        };
    }

    public int attribToHex(Animate animate) {
        return switch (animate) {
            case ANIMATE -> 1;
            case INANIMATE -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Gender gender) {
        return switch (gender) {
            case MALE -> 1;
            case FEMALE -> 2;
            case NEUTER -> 3;
            case COMMON -> 4;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Kind kind) {
        return switch (kind) {
            case FIRST -> 1;
            case SECOND -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Plural plural) {
        return switch (plural) {
            case PLURAL -> 1;
            case SINGULAR -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Time time) {
        return switch (time) {
            case PAST -> 1;
            case PRESENT -> 2;
            case FUTURE -> 3;
        };
    }

    public int attribToHex(Type type) {
        return switch (type) {
            case IMMUTABLE_ADJECTIVE -> 1;
            case MUTABLE_ADJECTIVE -> 2;
            case EXTENSIVE_ADVERB -> 3;
            case DEFINITE_ADVERB -> 4;
            case QUESTION_ADVERB -> 5;
            case ORDINAL_NUMERAL -> 6;
            case QUANTITATIVE_NUMERAL -> 7;
            case COLLECTIVE_NUMERAL -> 8;
            case INDEFINITE_NUMERAL -> 9;
        };
    }

    public int attribToHex(WordCase wordCase) {
        return switch (wordCase) {
            case NOMINATIVE -> 1;
            case GENITIVE -> 2;
            case DATIVE -> 3;
            case ACCUSATIVE -> 4;
            case INSTRUMENTAL -> 5;
            case PREPOSITIONAL -> 6;
            case VOCATIVE -> 7;
            case PARTITIVE -> 8;
            case LOCATIVE -> 9;
            case COUNTING -> 0xA;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Comparative comparative) {
        return switch (comparative) {
            case COMPARATIVE -> 1;
            case SUPER -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Face face) {
        return switch (face) {
            case FIRST -> 1;
            case SECOND -> 2;
            case THIRD -> 3;
            case ANONYMOUS -> 4;
        };
    }

    public int attribToHex(Infinitive infinitive) {
        return switch (infinitive) {
            case INFINITIVE -> 1;
            case NOT -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Perfect perfect) {
        return switch (perfect) {
            case PERFECT -> 1;
            case NOT_PERFECT -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(Reflexive reflexive) {
        return switch (reflexive) {
            case REFLEXIVE -> 1;
            case NOT_REFLEXIVE -> 2;
            case N_A -> 0xF;
        };
    }

    public int attribToHex(ShortF shortF) {
        return switch (shortF) {
            case SHORT -> 1;
            case NOT_SHORT -> 2;
        };
    }

    public int attribToHex(Transitive transitive) {
        return switch (transitive) {
            case TRANSITIVE -> 1;
            case INTRANSITIVE -> 2;
            case TRANS_INTRANS -> 3;
        };
    }

    public int attribToHex(Voice voice) {
        return switch (voice) {
            case ACTIVE -> 1;
            case PASSIVE -> 2;
            case N_A -> 0xF;
        };
    }
}
