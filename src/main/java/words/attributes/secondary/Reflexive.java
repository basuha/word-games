package words.attributes.secondary;

import utilities.WAttribute;

public enum Reflexive {

    REFLEXIVE ("reflexive"),
    NOT_REFLEXIVE ("not"),
    N_A ("n_a");

    private final String value;

    Reflexive(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
