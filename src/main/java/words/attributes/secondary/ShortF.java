package words.attributes.secondary;

import utilities.WAttribute;

public enum ShortF {

    SHORT ("short"),
    NOT_SHORT ("n/a");

    private final String value;

    ShortF(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
