package words.attributes;

/**
 * Признак времени глагола
 */
public enum Time {

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
