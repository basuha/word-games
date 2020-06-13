package words.attributes.primary;

import utilities.WAttribute;
import utilities.Word;

public enum PartOfSpeech implements WAttribute{

    NULL (null,null),
    N_A ("1","n/a"),
    ADJECTIVE("Adjective", "прилагательное"),
    ADVERB("Adverb", "наречие"),
    EXTRA_PARTICIPLE("ExtraParticiple", "деепричастие"),
    NOUN("Noun", "существительное"),
    NUMERAL("Numeral", "числительное"),
    PARTICIPLE("Participle", "причастие"),
    VERB("Verb", "глагол"),
    CONJUNCTION("Conjunction", "союз"),
    INTERJECTION("Interjection", "междометие"),
    PARENTHESIS("Parenthesis", "вводное слово"),
    PARTICLE("Particle", "частица"),
    PREDICATE("Predicate", "предикатив"),
    PRETEXT("Pretext", "пердлог"),
    PRONOUN("Pronoun", "местоимение");

    private final String VALUE;
    private final String LOCALIZED_VALUE;
    private final static String LOCALIZED_ATTRIBUTE_NAME = "часть речи";

    PartOfSpeech(String value, String localizedValue) {
        this.VALUE = value;
        this.LOCALIZED_VALUE = localizedValue;
    }

    @Override
    public String toString() {
        return VALUE;
    }

    public WAttribute[] getValues() {
        return values();
    }

    public String[] getLocalizedValueArray() {
        return WAttribute.getLocalizedValueArray(this);
    }

    @Override
    public String getLocalizedValue() {
        return LOCALIZED_VALUE;
    }

    public String getLocalizedAttributeName() {
        return LOCALIZED_ATTRIBUTE_NAME;
    }
}
