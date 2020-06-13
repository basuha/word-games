package words.attributes.primary;

import utilities.WAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Род
 * <li>{@link #MALE} - мужской</li>
 * <li>{@link #FEMALE} - женский</li>
 * <li>{@link #NEUTER} - средний</li>
 * <li>{@link #COMMON} - общий</li>
 * <li>{@link #N_A} - множественная форма (без рода)</li>
 */
public enum Gender implements WAttribute {

    NULL (null,null),

    /** без рода */
    N_A ("n/a", "n/a"),

    /** мужской */
    MALE ("male", "мужской"),

    /** женский */
    FEMALE ("female", "женский"),

    /** средний */
    NEUTER ("neuter", "средний"),

    /** общий */
    COMMON ("common", "общий");


    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "пол";

    Gender(String value, String localizedValue) {
        this.VALUE = value;
        this.LOCALIZED_VALUE = localizedValue;
    }

    @Override
    public String toString() {
        return VALUE;
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
}


//        String[] values = new String[values().length];
//        for (int i = 0; i < values.length; i++) {
//            values[i] = values()[i].getLocalizedValue();
//        }
//        return values;