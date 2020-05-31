package words.attributes.primary;

import utilities.WAttribute;

/**
 * Вид глагола: первый или второй
 * Вид причастия: второй или NULL
 */
public enum Kind implements WAttribute {

    FIRST ("first"),
    SECOND ("second"),
    N_A("n/a");

    private final String value;

    Kind (String value) {
            this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

