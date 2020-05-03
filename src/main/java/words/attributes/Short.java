package words.attributes;

public enum Short {

    SHORT ("short"),
    NOT_SHORT ("n/a");

    private final String value;

    Short(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
