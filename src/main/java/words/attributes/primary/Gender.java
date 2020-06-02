package words.attributes.primary;

import utilities.WAttribute;

/**
 * Род
 * <li>{@link #MALE} - мужской</li>
 * <li>{@link #FEMALE} - женский</li>
 * <li>{@link #NEUTER} - средний</li>
 * <li>{@link #COMMON} - общий</li>
 * <li>{@link #N_A} - множественная форма (без рода)</li>
 */
public enum Gender implements WAttribute {

    /** мужской */
    MALE ("male", "мужской"),

    /** женский */
    FEMALE ("female", "женский"),

    /** средний */
    NEUTER ("neuter", "средний"),

    /** общий */
    COMMON ("common", "общий"),

    /** без рода */
    N_A ("n/a", "n/a");

    private final String value;
    private final String localizedValue;
    private final static String localizedClassName = "пол";

    Gender(String value, String localizedValue) {
        this.value = value;
        this.localizedValue = localizedValue;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String getLocalizedValues() {
        return localizedValue;
    }

    @Override
    public String getLocalizedClassName() {
        return localizedClassName;
    }

}