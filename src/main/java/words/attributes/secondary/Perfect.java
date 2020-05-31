package words.attributes.secondary;

import utilities.WAttribute;

public enum Perfect implements WAttribute {

    PERFECT ("perfect"),
    NOT_PERFECT ("imperfect"),
    N_A ("n/a");

    private final String value;

    Perfect(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
