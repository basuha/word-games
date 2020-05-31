package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Признак переходности глагола/причастия/деепричастия
 */
public enum Transitive implements WAttribute {

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