package words.attributes.secondary;

public enum Infinitive {

    /**  */
    INFINITIVE ("infinitive"),

    /**  */
    NOT ("not"),

    /**  */
    N_A ("n/a");

    private final String value;

    Infinitive(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
