package words.attributes;

public enum Perfect {

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
