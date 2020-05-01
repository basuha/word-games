package words.attributes;

/**
 * Род
 * <li>{@link #MALE} - мужской</li>
 * <li>{@link #FEMALE} - женский</li>
 * <li>{@link #NEUTER} - средний</li>
 * <li>{@link #COMMON} - общий</li>
 * <li>{@link #N_A} - множественная форма (без рода)</li>
 */
public enum Gender {

    /** мужской */
    MALE ("male"),

    /** женский */
    FEMALE ("female"),

    /** средний */
    NEUTER ("neuter"),

    /** общий */
    COMMON ("common"),

    /** без рода */
    N_A ("n/a");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}