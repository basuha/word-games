package utilities;

import words.attributes.primary.*;
import words.attributes.secondary.*;

import java.lang.reflect.Field;
import java.util.List;

public interface IWord {

    default public String getPartOfSpeech() { return null; }
    default public AdverbType getAdverbType() { return null;}
    default public Animate getAnimate() { return null;}
    default public Comparative getComparative() { return null;}
    default public Face getFace() { return null;}
    default public Gender getGender() { return null;}
    default public Infinitive getInfinitive() { return null;}
    default public Kind getKind() { return null;}
    default public Perfect getPerfect() { return null;}
    default public Plural getPlural() { return null;}
    default public Reflexive getReflexive() { return null;}
    default public ShortF getShortF() { return null;}
    default public Time getTime() { return null;}
    default public Transitive getTransitive() { return null;}
    default public Type getType() { return null;}
    default public Voice getVoice() { return null;}
    default public WordCase getWordCase() { return null;}
    default public String getWord() { return null; }
    default public Field[] getWAttributes() { return null; }

}
