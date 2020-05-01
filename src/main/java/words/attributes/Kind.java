package words.attributes;

/**
 * Вид глагола
 */
public enum Kind {

    FIRST ("first"),
    SECOND ("second");

    private final String value;

    Kind(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Вид причастия
     * Второй или NULL
     */
    public enum Participle {

        SECOND ("second"),
        N_A("n/a");

        private final String value;

        Participle (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
