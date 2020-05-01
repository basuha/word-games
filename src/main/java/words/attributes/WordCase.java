package words.attributes;

/**
 * Падеж:
 * <li>{@link #NOMINATIVE} - именитильный (кто?, что?)</li>
 * <li>{@link #GENITIVE} - родительный (кого?, чего?)</li>
 * <li>{@link #DATIVE} - дательный (кому?, чему?)</li>
 * <li>{@link #ACCUSATIVE} - винительный (кого?, что?)</li>
 * <li>{@link #INSTRUMENTAL} - творительный (кем?, чем?)</li>
 * <li>{@link #PREPOSITIONAL} - предложный (о ком?, о чем?)</li>
 */
public enum WordCase {

    /** именитильный (кто?, что?) */
    NOMINATIVE ("им"),

    /** родительный (кого?, чего?) */
    GENITIVE ("род"),

    /** дательный (кому?, чему?) */
    DATIVE ("дат"),

    /** винительный (кого?, что?) */
    ACCUSATIVE ("вин"),

    /** творительный (кем?, чем?) */
    INSTRUMENTAL ("тв"),

    /** предложный (о ком?, о чем?) */
    PREPOSITIONAL ("пр");

    private final String value;

    WordCase(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Падеж существительного:
     * <li>{@link #NOMINATIVE} - именитильный (кто?, что?)</li>
     * <li>{@link #GENITIVE} - родительный (кого?, чего?)</li>
     * <li>{@link #DATIVE} - дательный (кому?, чему?)</li>
     * <li>{@link #ACCUSATIVE} - винительный (кого?, что?)</li>
     * <li>{@link #INSTRUMENTAL} - творительный (кем?, чем?)</li>
     * <li>{@link #PREPOSITIONAL} - предложный (о ком?, о чем?)</li>
     * <li>{@link #VOCATIVE} - звательный </li>
     * <li>{@link #PARTITIVE} - частичный </li>
     * <li>{@link #LOCATIVE} - локатив </li>
     * <li>{@link #COUNTING} - счетный </li>
     */
    public enum Noun {

        /** именитильный (кто?, что?) */
        NOMINATIVE ("им"),

        /** родительный (кого?, чего?) */
        GENITIVE ("род"),

        /** дательный (кому?, чему?) */
        DATIVE ("дат"),

        /** винительный (кого?, что?) */
        ACCUSATIVE ("вин"),

        /** творительный (кем?, чем?) */
        INSTRUMENTAL ("тв"),

        /** предложный (о ком?, о чем?) */
        PREPOSITIONAL ("пр"),

        /** звательный */
        VOCATIVE ("зват"),

        /** частичный */
        PARTITIVE ("парт"),

        /** локатив */
        LOCATIVE ("мест"),

        /** счетный */
        COUNTING ("счет");

        private final String value;

        Noun (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}
