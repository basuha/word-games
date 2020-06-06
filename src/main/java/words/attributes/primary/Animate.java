package words.attributes.primary;

import utilities.WAttribute;

public enum Animate implements WAttribute {

    /** одушевленный */
    ANIMATE ("animate", "одушевленный"),

    /** неодушевленный */
    INANIMATE ("inanimate", "неодушевленный"),

    /** н/д */
    N_A ("n/a", "н/д");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "одуш.";

    Animate (String value, String localizedValue) {
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
