package words.attributes;

/**
 * Признак переходности глагола/причастия/деепричастия
 */
public enum Transit {

    TRANSITIVE ("перех"),
    INTRANSITIVE ("непер"),
    TRANS_INTRANS ("пер/не");

    private final String value;

    Transit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}