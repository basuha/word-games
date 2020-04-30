package words.attributes;

/**
 * Признак времени глагола
 */
public enum Time {

    PAST ("прош"),
    PRESENT ("наст"),
    FUTURE ("буд");


    private final String value;

    Time(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


    /**
     * Признак времени причастия, деепричастия
     */
    public enum Participle {

        PAST ("прош"),
        PRESENT ("наст");

        private final String value;

        Participle(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}