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
public enum Type implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),

    /** неизменяемое */
    IMMUTABLE_ADJECTIVE ("immutable", "неизменяемое"),

    /** изменяемое */
    MUTABLE_ADJECTIVE ("mutable", "изменяемое"),


    /** обстоятельственные */
    EXTENSIVE_ADVERB("extensive", "обстоятельственные"),

    /** определительные */
    DEFINITE_ADVERB("definite", "определительные"),

    /** вопросительные */
    QUESTION_ADVERB("question", "вопросительные"),


    /** порядковое */
    ORDINAL_NUMERAL ("ordinal", "порядковое"),

    /** количественное */
    QUANTITATIVE_NUMERAL ("quantitative", "количественное"),

    /** собирательное */
    COLLECTIVE_NUMERAL ("collective", "собирательное"),

    /** неопределенное */
    INDEFINITE_NUMERAL ("indefinite", "неопределенное");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "тип";

    Type (String value, String localizedValue) {
        this.VALUE = value;
        this.LOCALIZED_VALUE = localizedValue;
    }

    public WAttribute[] getValues() {
        return values();
    }

    public String[] getLocalizedValueArray() {
        return WAttribute.getLocalizedValueArray(this);
    }

    @Override
    public String getLocalizedValue() {
        return LOCALIZED_VALUE;
    }

    public String getLocalizedAttributeName() {
        return LOCALIZED_ATTRIBUTE_NAME;
    }

    @Override
    public String toString() {
        return VALUE;
    }

}
