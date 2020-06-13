package words.attributes.primary;

import utilities.WAttribute;

/**
 * Вид глагола: первый или второй
 * Вид причастия: второй или NULL
 */
public enum Kind implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),
    FIRST ("first", "первый"),
    SECOND ("second", "второй");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "вид";

    Kind (String value, String localizedValue) {
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

