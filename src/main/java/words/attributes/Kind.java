package words.attributes;

/**
 * Вид глагола
 */
public enum Kind {

    FIRST ("1вид"),
    SECOND ("2вид");

    private final String value;

    Kind(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
