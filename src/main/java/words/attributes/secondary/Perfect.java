package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Совершенность глагола
 */
public enum Perfect implements WAttribute{

    /** совершенный */
    PERFECT ("perfect", "совершенный"),

    /** несовершенный */
    NOT_PERFECT ("imperfect", "несовершенный"),

    /** н/д */
    N_A ("n/a", "н/д");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "совершенность";

    Perfect (String value, String localizedValue) {
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
