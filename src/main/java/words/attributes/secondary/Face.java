package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Лицо глагола
 */
public enum Face {

    FIRST ("first"),
    SECOND ("second"),
    THIRD ("third"),
    ANONYMOUS ("anonymous");

    private final String value;

    Face(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
