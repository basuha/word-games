package words.attributes.primary;

import utilities.WAttribute;

public enum Animate implements WAttribute {

    /** */
    ANIMATE ("animate"),

    /** */
    INANIMATE ("inanimate"),

    /** */
    N_A ("n/a");

    private final String value;

    Animate(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
