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

    /**
     * именитильный (кто?, что?)
     */
    NOMINATIVE("nominative", "именитильный"),

    /**
     * родительный (кого?, чего?)
     */
    GENITIVE("genitive", "родительный"),

    /**
     * дательный (кому?, чему?)
     */
    DATIVE("dative", "дательный"),

    /**
     * винительный (кого?, что?)
     */
    ACCUSATIVE("accusative", "винительный"),

    /**
     * творительный (кем?, чем?)
     */
    INSTRUMENTAL("instrumental", "творительный"),

    /**
     * предложный (о ком?, о чем?)
     */
    PREPOSITIONAL("prepositional", "предложный"),

    /**
     * звательный
     */
    VOCATIVE("vocative", "звательный"),

    /**
     * частичный
     */
    PARTITIVE("partitive", "частичный"),

    /**
     * локатив
     */
    LOCATIVE("locative", "локатив"),

    /**
     * счетный
     */
    COUNTING("counting", "счетный"),

    N_A("n/a", "н/д");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "падеж";

    WordCase(String value, String localizedValue) {
        this.VALUE = value;
        this.LOCALIZED_VALUE = localizedValue;
    }

    public WAttribute[] getValues() {
        return values();
    }

    public String[] getLocalizedValueArray() {
        return WAttribute.getLocalizedValueArray(this);
    }

    @Override
    public String getLocalizedValue() {
        return LOCALIZED_VALUE;
    }

    public String getLocalizedAttributeName() {
        return LOCALIZED_ATTRIBUTE_NAME;
    }

    @Override
    public String toString() {
        return VALUE;
    }
}
