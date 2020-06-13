package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Залог глагола: активный, пассивный
 * Залог причастия, деепричастия: второй, null
 */
public enum Voice implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),
    /** активный */
    ACTIVE ("active", "активный"),

    /** пассивный */
    PASSIVE ("passive", "пассивный");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "залог";

    Voice (String value, String localizedValue) {
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



