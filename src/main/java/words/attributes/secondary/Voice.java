package words.attributes.secondary;

import utilities.WAttribute;

/**
 * Залог глагола: активный, пассивный
 * Залог причастия, деепричастия: второй, null
 */
public enum Voice implements WAttribute {

    ACTIVE ("active"),
    PASSIVE ("passive"),
    N_A ("n/a");

    private final String value;

    Voice (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
            return value;
        }
}


