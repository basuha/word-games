package words.attributes.primary;

import utilities.WAttribute;

/**
 * Подтип прилагательного:
 * <li>{@link #IMMUTABLE_ADJECTIVE} - неизменяемое</li>
 * <li>{@link #MUTABLE_ADJECTIVE} - изменяемое</li>
 *
 * Классификация наречия по значению:
 * <li>{@link #EXTENSIVE_ADVERB} - обстоятельственные</li>
 * <li>{@link #DEFINITE_ADVERB} - определительные</li>
 * <li>{@link #QUESTION_ADVERB} - вопросительные</li>
 *
 * Подтип числительного:
 * <li>{@link #ORDINAL_NUMERAL} - неизменяемое</li>
 * <li>{@link #QUANTITATIVE_NUMERAL} - количественное</li>
 * <li>{@link #COLLECTIVE_NUMERAL} - собирательное</li>
 * <li>{@link #INDEFINITE_NUMERAL} - неопределенное</li>
 */
public enum Type {

    /** неизменяемое */
    IMMUTABLE_ADJECTIVE ("immutable"),

    /** изменяемое */
    MUTABLE_ADJECTIVE ("mutable"),


    /** обстоятельственные */
    EXTENSIVE_ADVERB("extensive"),

    /** определительные */
    DEFINITE_ADVERB("definite"),

    /** вопросительные */
    QUESTION_ADVERB("question"),


    /** порядковое */
    ORDINAL_NUMERAL ("ordinal"),

    /** количественное */
    QUANTITATIVE_NUMERAL ("quantitative"),

    /** собирательное */
    COLLECTIVE_NUMERAL ("collective"),

    /** неопределенное */
    INDEFINITE_NUMERAL ("indefinite");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
