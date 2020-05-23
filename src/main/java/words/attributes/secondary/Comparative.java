package words.attributes.secondary;

/** Сравнительные формы прилагательного:
 * <li>{@link #COMPARATIVE} - сравнительная форма</li>
 * <li>{@link #SUPER} - превосходная форма</li>
 */
public enum Comparative {

    /** сравнительная форма */
    COMPARATIVE ("comparative"),

    /** превосходная форма */
    SUPER ("super"),

    /** без признака сравнения */
    N_A ("n/a");

    private final String value;

    Comparative(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}