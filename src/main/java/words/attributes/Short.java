package words.attributes;

public enum Short {

    SHORT ("short"),
    NOT_SHORT ("not_short"),
    N_A ("n/a");

    private final String value;

    Short(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
