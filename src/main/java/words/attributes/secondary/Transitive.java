package words.attributes.secondary;

/**
 * Признак переходности глагола/причастия/деепричастия
 */
public enum Transitive {

    TRANSITIVE ("transitive"),
    INTRANSITIVE ("intransitive"),
    TRANS_INTRANS ("trans/intrans");

    private final String value;

    Transitive(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}