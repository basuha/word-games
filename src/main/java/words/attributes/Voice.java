package words.attributes;

/**
 * Залог глагола, причастия, деепричастия
 */
public enum Voice {

    ACTIVE ("пов"),
    PASSIVE ("страд");

    private final String value;

    Voice(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

