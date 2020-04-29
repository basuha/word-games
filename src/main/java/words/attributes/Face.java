package words.attributes;

/**
 * Лицо глагола
 */
public enum Face {

    FIRST ("1-е"),
    SECOND ("2-е"),
    THIRD ("3-е"),
    ANONYMOUS ("безл");

    private final String value;

    Face(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
