package words.attributes.primary;

import utilities.WAttribute;

import javax.management.ValueExp;
import java.lang.reflect.Field;

public enum Plural implements WAttribute {

    NULL (null,null),
    N_A ("n/a", "n/a"),
    PLURAL ("plural", "мн.ч"),
    SINGULAR ("singular", "ед.ч");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "число";

    Plural (String value, String localizedValue) {
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
