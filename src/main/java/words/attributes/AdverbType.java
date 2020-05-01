package words.attributes;

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
public enum AdverbType {

    /** качественные */
    QUALITATIVE("кач"),

    /** способа и образа действия */
    METHOD("спос"),

    /** степени действия */
    EXTENT("степ"),

    /** места действия */
    PLACE("места"),

    /** направление действия */
    DIRECTION("напр"),

    /** времени действия */
    TIMING("врем"),

    /** цели действия */
    PURPOSE("цель"),

    /** причины действия */
    REASON("причин");

    private final String value;

    AdverbType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
