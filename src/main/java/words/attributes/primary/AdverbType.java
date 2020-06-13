package words.attributes.primary;

import utilities.WAttribute;

/**
 * Подтипы наречия:
 * <li>{@link #QUALITATIVE} - качественные</li>
 * <li>{@link #METHOD} - способа и образа действия</li>
 * <li>{@link #EXTENT} - степени действия</li>
 * <li>{@link #PLACE} - места действия</li>
 * <li>{@link #DIRECTION} - направление действия</li>
 * <li>{@link #TIMING} - времени действия</li>
 * <li>{@link #PURPOSE} - цели действия</li>
 * <li>{@link #REASON} - причины действия</li>
 */
public enum AdverbType implements WAttribute{

    NULL (null,null),

    /** без рода */
    N_A ("n/a", "n/a"),

    /** качественные */
    QUALITATIVE("qualitative", "качественные"),

    /** способа и образа действия */
    METHOD("method", "способа"),

    /** степени действия */
    EXTENT("extent", "степени"),

    /** места действия */
    PLACE("place", "места"),

    /** направление действия */
    DIRECTION("direction", "направление"),

    /** времени действия */
    TIMING("timing", "времени"),

    /** цели действия */
    PURPOSE("purpose", "цели"),

    /** причины действия */
    REASON("reason", "причины");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "тип наречия";

    AdverbType(String value, String localizedValue) {
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
