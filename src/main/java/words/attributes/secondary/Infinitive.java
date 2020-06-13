package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Признак инфинитива
 */
public enum Infinitive implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),
    /** инфинитив */
    INFINITIVE ("infinitive", "инфинитив"),

    /** нет */
    NOT ("not", "нет");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "инфинитив";

    Infinitive (String value, String localizedValue) {
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
