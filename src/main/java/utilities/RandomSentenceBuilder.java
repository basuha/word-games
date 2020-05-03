package utilities;

import words.Word;
import words.primary.*;
import words.secondary.*;


import java.util.ArrayList;
import java.util.List;

public class RandomSentenceBuilder {

    private List<Adjective> adjectives;
    private List<Adverb> adverbs;
    private List<ExtraParticiple> extraParticiples;
    private List<Noun> nouns;
    private List<Numeral> numerals;
    private List<Participle> participles;
    private List<Verb> verbs;

    private List<Conjunction> conjunctions;
    private List<Interjection> interjections;
    private List<Parenthesis> parentheses;
    private List<Particle> particles;
    private List<Predicate> predicates;
    private List<Pretext> pretexts;
    private List<PronAdj> pronAdjs;
    private List<PronAdv> pronAdvs;
    private List<PronNoun> pronNouns;
    private List<Pronoun> pronouns;

    private List<Word> wordsList = new ArrayList<>();
    private StringBuilder sentence = new StringBuilder();
//    private List<StringBuilder> stringBuilders = new ArrayList<>();

    public RandomSentenceBuilder append(Word word) {
        wordsList.add(word);
        return this;
    }

    public RandomSentenceBuilder build() {
        for (int i = 0; i < wordsList.size(); i++) {
            sentence.append(new RandomWord(wordsList.get(i)).get().getWord());
            sentence.append(" ");
        }
        return this;
    }
//
//    public RandomSentenceBuilder append(Adverb adverb) {
//        adverbs.add(adverb);
//        return this;
//    }
//
//    public RandomSentenceBuilder append(ExtraParticiple extraParticiple) {
//        extraParticiples.add(extraParticiple);
//        return this;
//    }
//
//    public RandomSentenceBuilder append(Noun noun) {
//        nouns.add(noun);
//        return this;
//    }
//
//    public RandomSentenceBuilder append(Numeral numeral) {
//        numerals.add(numeral);
//        return this;
//    }
//
//    public RandomSentenceBuilder append(Participle participle) {
//        participles.add(participle);
//        return this;
//    }
//
//    public RandomSentenceBuilder append(Verb verb) {
//        verbs.add(verb);
//        return this;
//    }

    @Override
    public String toString() {
        return sentence.toString();
    }
}
