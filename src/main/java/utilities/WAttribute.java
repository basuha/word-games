package utilities;

import words.attributes.primary.Gender;

public interface WAttribute {

    int ordinal();

    String name();

    String toString();

    String getLocalizedValue();

    WAttribute[] getValues();

    static String[] getLocalizedValueArray(WAttribute wAttribute) {
        String[] values = new String[wAttribute.getValues().length];
        for (int i = 0; i < values.length; i++) {
            values[i] = wAttribute.getValues()[i].getLocalizedValue();
        }
        return values;
    }

    String getLocalizedAttributeName();

    default String getAttributeName() {
        return getClass().getSimpleName();
    }
}

