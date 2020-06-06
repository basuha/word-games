package words.attributes.secondary;

import utilities.WAttribute;

/** Сравнительные формы прилагательного:
 * <li>{@link #COMPARATIVE} - сравнительная форма</li>
 * <li>{@link #SUPER} - превосходная форма</li>
 */
public enum Comparative implements WAttribute {

    /** сравнительная форма */
    COMPARATIVE ("comparative", "сравнительная"),

    /** превосходная форма */
    SUPER ("super", "превосходная"),

    /** без признака сравнения */
    N_A ("n/a", "н/д");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "сравн.";

    Comparative (String value, String localizedValue) {
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