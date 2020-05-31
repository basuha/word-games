package words.attributes.primary;

import utilities.WAttribute;

public enum Plural implements WAttribute {

    PLURAL ("plural"),
    SINGULAR ("singular"),
    N_A ("n/a");

    private final String value;

    Plural(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
