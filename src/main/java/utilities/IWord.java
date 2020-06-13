package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

import java.lang.reflect.Field;
import java.util.List;

public interface IWord {

    default String getPartOfSpeech() { return null; }

    default AdverbType getAdverbType() { return AdverbType.NULL;}
    default Animate getAnimate() { return Animate.NULL;}
    default Comparative getComparative() { return Comparative.NULL;}
    default Face getFace() { return Face.NULL;}
    default Gender getGender() { return Gender.NULL;}
    default Infinitive getInfinitive() { return Infinitive.NULL;}
    default Kind getKind() { return Kind.NULL;}
    default Perfect getPerfect() { return Perfect.NULL;}
    default Plural getPlural() { return Plural.NULL;}
    default Reflexive getReflexive() { return Reflexive.NULL;}
    default ShortF getShortF() { return ShortF.NULL;}
    default Time getTime() { return Time.NULL;}
    default Transitive getTransitive() { return Transitive.NULL;}
    default Type getType() { return Type.NULL;}
    default Voice getVoice() { return Voice.NULL;}
    default WordCase getWordCase() { return WordCase.NULL;}

    default String getWord() { return null; }
    default Field[] getWAttributes() { return null; }
    default String getInfo() { return null; }
}
