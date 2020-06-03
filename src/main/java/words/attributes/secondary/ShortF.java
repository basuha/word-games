package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Краткость прилагательного
 */
public enum ShortF implements WAttribute {

    /** краткая форма */
    SHORT ("short", "краткая"),

    /** нет краткая форма */
    NOT_SHORT ("n/a", "нет");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "краткая форма";

    ShortF (String value, String localizedValue) {
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
