package words.attributes.primary;

import utilities.WAttribute;

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
public enum WordCase implements WAttribute {

    /** именитильный (кто?, что?) */
    NOMINATIVE ("nominative"),

    /** родительный (кого?, чего?) */
    GENITIVE ("genitive"),

    /** дательный (кому?, чему?) */
    DATIVE ("dative"),

    /** винительный (кого?, что?) */
    ACCUSATIVE ("accusative"),

    /** творительный (кем?, чем?) */
    INSTRUMENTAL ("instrumental"),

    /** предложный (о ком?, о чем?) */
    PREPOSITIONAL ("prepositional"),

    /** звательный */
    VOCATIVE ("vocative"),

    /** частичный */
    PARTITIVE ("partitive"),

    /** локатив */
    LOCATIVE ("locative"),

    /** счетный */
    COUNTING ("counting"),

    N_A ("n/a");

    private final String value;

    WordCase(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
