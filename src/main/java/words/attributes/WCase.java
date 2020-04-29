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
public enum WCase {

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

    WCase (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
