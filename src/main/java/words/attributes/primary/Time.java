package words.attributes.primary;

import utilities.WAttribute;

/**
 * Признак времени глагола
 */
public enum Time implements WAttribute {

    PAST ("past"),
    PRESENT ("present"),
    FUTURE ("future");


    private final String value;

    Time(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
