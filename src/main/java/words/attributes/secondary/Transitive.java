package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Признак переходности глагола/причастия/деепричастия
 */
public enum Transitive implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),
    /** переходный */
    TRANSITIVE ("transitive", "переходный"),

    /** непереходный */
    INTRANSITIVE ("intransitive", "непереходный"),

    /** пер/не */
    TRANS_INTRANS ("trans/intrans", "пер/не");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "переходность";

    Transitive (String value, String localizedValue) {
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