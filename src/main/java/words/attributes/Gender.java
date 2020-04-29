package words.attributes;

/**
 * Род прилагательного
 * <li>{@link #MALE} - мужской</li>
 * <li>{@link #FEMALE} - женский</li>
 * <li>{@link #NEUTER} - средний</li>
 * <li>{@link #PLURAL_FORM} - множественная форма (без рода)</li>
 */
public enum Gender {

    /** мужской */
    MALE ("муж"),

    /** женский */
    FEMALE ("жен"),

    /** средний */
    NEUTER ("ср"),

    /** множественная форма (без рода) */
    PLURAL_FORM (null);

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}