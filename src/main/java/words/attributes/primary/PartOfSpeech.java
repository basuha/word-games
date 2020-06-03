package words.attributes.primary;

import utilities.WAttribute;
import utilities.Word;

public enum PartOfSpeech implements WAttribute{

    ADJECTIVE(Word.ADJECTIVE, "прилагательное"),
    ADVERB(Word.ADVERB, "наречие"),
    EXTRA_PARTICIPLE(Word.EXTRA_PARTICIPLE, "деепричастие"),
    NOUN(Word.NOUN, "существительное"),
    NUMERAL(Word.NUMERAL, "числительное"),
    PARTICIPLE(Word.PARTICIPLE, "причастие"),
    VERB(Word.VERB, "глагол"),
    CONJUNCTION(Word.CONJUNCTION, "союз"),
    INTERJECTION(Word.INTERJECTION, "междометие"),
    PARENTHESIS(Word.PARENTHESIS, "вводное слово"),
    PARTICLE(Word.PARTICLE, "частица"),
    PREDICATE(Word.PREDICATE, "предикатив"),
    PRETEXT(Word.PRETEXT, "пердлог"),
    PRON_ADJ(Word.PRON_ADJ, "мест-прил"),
    PRON_ADV(Word.PRON_ADV, "мест-нар"),
    PRON_NOUN(Word.PRON_NOUN, "мест-сущ"),
    PRONOUN(Word.PRONOUN, "местоимение");

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
