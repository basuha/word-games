package words.attributes.primary;

import words.attributes.Attribute;

public enum Animate implements Attribute {

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

    @Override
    public Attribute getEnum() {
        return null;
    }
}
