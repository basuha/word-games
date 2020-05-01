package words.attributes;

/**
 * Залог глагола, причастия, деепричастия
 */
public enum Voice {

    ACTIVE ("active"),
    PASSIVE ("passive");

    private final String value;

    Voice(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }



    public enum Participle {

        PASSIVE ("passive"),
        N_A ("n/a");

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

