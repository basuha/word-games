package words.attributes.primary;

import utilities.WAttribute;

public enum Animate implements WAttribute {

    NULL (null,null),

    /** без рода */
    N_A ("n/a", "n/a"),

    /** одушевленный */
    ANIMATE ("animate", "одушевленный"),

    /** неодушевленный */
    INANIMATE ("inanimate", "неодушевленный");

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
