package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Возвратность глагола
 */
public enum Reflexive implements WAttribute{

    /** возвратный **/
    REFLEXIVE ("reflexive", "возвратный"),

    /** не возвратный **/
    NOT_REFLEXIVE ("not", "не возвратный"),

    /** н/д **/
    N_A ("n_a", "н/д");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "возвратность";

    Reflexive (String value, String localizedValue) {
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
