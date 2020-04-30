package words.attributes;

/** Сравнительные формы прилагательного:
 * <li>{@link #COMPARATIVE} - сравнительная форма</li>
 * <li>{@link #SUPER} - превосходная форма</li>
 */
public enum Comp {

    /** сравнительная форма */
    COMPARATIVE ("сравн"),

    /** превосходная форма*/
    SUPER ("прев");

    private final String value;

    Comp (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}