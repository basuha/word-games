package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WordToHex extends WSearch {
    private List<Byte> hexCode = new ArrayList<>();

    public WordToHex(Word word) {
        init(word);
    }

    public BigDecimal toHex(){
        hexCode.add(PART_OF_SPEECH_INDEX, attribToHex(partOfSpeech));
        hexCode.add(WORD_CASE_INDEX, attribToHex(wordCase));
        hexCode.add(GENDER_INDEX, attribToHex(gender));
        hexCode.add(PLURAL_INDEX, attribToHex(plural));
        hexCode.add(TYPE_INDEX, attribToHex(type));
        hexCode.add(TIME_INDEX, attribToHex(time));
        hexCode.add(ADVERB_TYPE_INDEX, attribToHex(adverbType));
        hexCode.add(TRANSITIVE_INDEX, attribToHex(transitive));
        hexCode.add(ANIMATE_INDEX, attribToHex(animate));
        hexCode.add(VOICE_INDEX, attribToHex(voice));
        hexCode.add(PERFECT_INDEX, attribToHex(perfect));
        hexCode.add(KIND_INDEX, attribToHex(kind));
        hexCode.add(COMPARATIVE_INDEX, attribToHex(comparative));
        hexCode.add(INFINITIVE_INDEX, attribToHex(infinitive));
        hexCode.add(FACE_INDEX, attribToHex(face));
        hexCode.add(REFLEXIVE_INDEX, attribToHex(reflexive));
        hexCode.add(SHORT_FORM_INDEX, attribToHex(shortF));

        return byteArrayToNumeric(hexCode);
    }

    private BigDecimal byteArrayToNumeric(List<Byte> bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : bytes) {
            stringBuilder.append(b);
        }
        return BigDecimal.valueOf(Long.parseLong(stringBuilder.toString()));
    }

    public byte attribToHex(PartOfSpeech partOfSpeech) {
        if (partOfSpeech != null) {
            return (byte) switch (partOfSpeech) {
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
        return 0;
    }

    public byte attribToHex(AdverbType adverbType) {
        if (adverbType != null) {
            return (byte) switch (adverbType) {
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
        return 0;
    }

    public byte attribToHex(Animate animate) {
        if (animate != null) {
            return (byte) switch (animate) {
                case ANIMATE -> 1;
                case INANIMATE -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Gender gender) {
        if (gender != null) {
            return (byte) switch (gender) {
                case MALE -> 1;
                case FEMALE -> 2;
                case NEUTER -> 3;
                case COMMON -> 4;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Kind kind) {
        if (kind != null) {
            return (byte) switch (kind) {
                case FIRST -> 1;
                case SECOND -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Plural plural) {
        if (plural != null) {
            return (byte) switch (plural) {
                case PLURAL -> 1;
                case SINGULAR -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Time time) {
        if (time != null) {
            return (byte) switch (time) {
                case PAST -> 1;
                case PRESENT -> 2;
                case FUTURE -> 3;
            };
        }
        return 0;
    }

    public byte attribToHex(Type type) {
        if (type != null) {
            return (byte) switch (type) {
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
        return 0;
    }

    public byte attribToHex(WordCase wordCase) {
        if (wordCase != null) {
            return (byte) switch (wordCase) {
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
        return 0;
    }

    public byte attribToHex(Comparative comparative) {
        if (comparative != null) {
            return (byte) switch (comparative) {
                case COMPARATIVE -> 1;
                case SUPER -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Face face) {
        if (face != null) {
            return (byte) switch (face) {
                case FIRST -> 1;
                case SECOND -> 2;
                case THIRD -> 3;
                case ANONYMOUS -> 4;
            };
        }
        return 0;
    }

    public byte attribToHex(Infinitive infinitive) {
        if (infinitive != null) {
            return (byte) switch (infinitive) {
                case INFINITIVE -> 1;
                case NOT -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Perfect perfect) {
        if (perfect != null) {
            return (byte) switch (perfect) {
                case PERFECT -> 1;
                case NOT_PERFECT -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(Reflexive reflexive) {
        if (reflexive != null) {
            return (byte) switch (reflexive) {
                case REFLEXIVE -> 1;
                case NOT_REFLEXIVE -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }

    public byte attribToHex(ShortF shortF) {
        if (shortF != null) {
            return (byte) switch (shortF) {
                case SHORT -> 1;
                case NOT_SHORT -> 2;
            };
        }
        return 0;
    }

    public byte attribToHex(Transitive transitive) {
        if (transitive != null) {
            return (byte) switch (transitive) {
                case TRANSITIVE -> 1;
                case INTRANSITIVE -> 2;
                case TRANS_INTRANS -> 3;
            };
        }
        return 0;
    }

    public byte attribToHex(Voice voice) {
        if (voice != null) {
            return (byte) switch (voice) {
                case ACTIVE -> 1;
                case PASSIVE -> 2;
                case N_A -> 0xF;
            };
        }
        return 0;
    }
}
