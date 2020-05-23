package words.attributes.primary;

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
    QUALITATIVE("qualitative"),

    /** способа и образа действия */
    METHOD("method"),

    /** степени действия */
    EXTENT("extent"),

    /** места действия */
    PLACE("place"),

    /** направление действия */
    DIRECTION("direction"),

    /** времени действия */
    TIMING("timing"),

    /** цели действия */
    PURPOSE("purpose"),

    /** причины действия */
    REASON("reason");

    private final String value;

    AdverbType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
