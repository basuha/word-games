package words.attributes.secondary;

/**
 * Залог глагола: активный, пассивный
 * Залог причастия, деепричастия: второй, null
 */
public enum Voice {

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



