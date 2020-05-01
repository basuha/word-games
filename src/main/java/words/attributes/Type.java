package words.attributes;

public enum Type {
    ;
    /**
     * Подтип прилагательного:
     * <li>{@link #IMMUTABLE} - неизменяемое</li>
     * <li>{@link #MUTABLE} - изменяемое</li>
     */
    public enum Adjective {

        /** неизменяемое */
        IMMUTABLE ("неизм"),

        /** изменяемое */
        MUTABLE ("изм");

        private final String value;

        Adjective(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    /**
     * Классификация наречия по значению:
     * <li>{@link #EXTENSIVE} - обстоятельственные</li>
     * <li>{@link #DEFINITE} - определительные</li>
     * <li>{@link #QUESTION} - вопросительные</li>
     */
    public enum Adverb {

        /** обстоятельственные */
        EXTENSIVE("обст"),

        /** определительные */
        DEFINITE("опред"),

        /** вопросительные */
        QUESTION("вопр");

        private final String value;

        Adverb(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Подтип числительного:
     * <li>{@link #ORDINAL} - неизменяемое</li>
     * <li>{@link #QUANTITATIVE} - количественное</li>
     * <li>{@link #COLLECTIVE} - собирательное</li>
     * <li>{@link #INDEFINITE} - неопределенное</li>
     */
    public enum Numeral {

        /** порядковое */
        ORDINAL ("поряд"),

        /** количественное */
        QUANTITATIVE ("кол"),

        /** собирательное */
        COLLECTIVE ("собир"),

        /** неопределенное */
        INDEFINITE ("неопр");

        private final String value;

        Numeral(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}
