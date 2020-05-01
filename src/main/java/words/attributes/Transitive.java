package words.attributes;

/**
 * Признак переходности глагола/причастия/деепричастия
 */
public enum Transitive {

    TRANSITIVE ("перех"),
    INTRANSITIVE ("непер"),
    TRANS_INTRANS ("пер/не");

    private final String value;

    Transitive(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}