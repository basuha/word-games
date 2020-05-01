package utilities;

import org.hibernate.Session;
import words.Word;
import words.primary.*;

import javax.persistence.Query;
import java.util.List;

public class RandomWord {

    private String adverbType;
    private String animate;
    private String comparative;
    private String face;
    private String gender;
    private String infinitive;
    private String kind;
    private String perfect;
    private String plural;
    private String reflexive;
    private String shortF;
    private String time;
    private String transitive;
    private String type;
    private String voice;
    private String wordCase;
    private Word word;

    public RandomWord(Word word) {
        this.word = word;
        switch (word.getPartOfSpeech()) {

            case PartOfSpeech.ADJECTIVE:

                Adjective adjective = (Adjective) word;
                this.comparative = adjective.getComparative();
                this.gender = adjective.getGender();
                this.plural = adjective.getPlural();
                this.shortF = adjective.getShortF();
                this.type = adjective.getType();
                this.wordCase = adjective.getWordCase();
                break;

            case PartOfSpeech.ADVERB:

                Adverb adverb = (Adverb) word;
                this.type = adverb.getType();
                this.adverbType = adverb.getAdverbType();
                this.comparative = adverb.getComparative();
                break;

            case PartOfSpeech.EXTRA_PARTICIPLE:

                ExtraParticiple extraParticiple = (ExtraParticiple) word;
                this.transitive = extraParticiple.getTransitive();
                this.perfect = extraParticiple.getPerfect();
                this.time = extraParticiple.getTime();
                this.reflexive = extraParticiple.getReflexive();
                break;

            case PartOfSpeech.NOUN:

                Noun noun = (Noun) word;
                this.plural = noun.getPlural();
                this.gender = noun.getGender();
                this.wordCase = noun.getWordCase();
                this.animate = noun.getAnimate();
                break;

            case PartOfSpeech.NUMERAL:

                Numeral numeral = (Numeral) word;
                this.plural = numeral.getPlural();
                this.gender = numeral.getGender();
                this.wordCase = numeral.getWordCase();
                this.type = numeral.getType();
                break;

            case PartOfSpeech.PARTICIPLE:

                Participle participle = (Participle) word;
                this.gender = participle.getGender();
                this.kind = participle.getKind();
                this.plural = participle.getPlural();
                this.reflexive = participle.getReflexive();
                this.shortF = participle.getShortF();
                this.time = participle.getTime();
                this.transitive = participle.getTransitive();
                this.voice = participle.getVoice();
                this.wordCase = participle.getWordCase();
                break;

            case PartOfSpeech.VERB:

                Verb verb = (Verb) word;
                this.face = verb.getFace();
                this.gender = verb.getGender();
                this.infinitive = verb.getInfinitive();
                this.kind = verb.getKind();
                this.perfect = verb.getPerfect();
                this.plural = verb.getPlural();
                this.reflexive = verb.getReflexive();
                this.time = verb.getTime();
                this.transitive = verb.getTransitive();
                this.voice = verb.getVoice();
                break;
        }
    }

    @SuppressWarnings("unchecked assignment")
    public List<Word> getRandomWords() {
        List<Word> wordsList;
        StringBuilder hql = new StringBuilder();
        int attribCount = 0;
        hql.append("FROM ")
                .append(word.getPartOfSpeech())
                .append(" WHERE");

        if (shortF != null) {
            hql.append(" short = ")
                    .append("'").append(shortF).append("'");
            attribCount++;
        }

        if (plural != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" plural = ").append("'").append(plural).append("'");
            attribCount++;
        }

        if (gender != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" gender = ").append("'").append(gender).append("'");
            attribCount++;
        }

        if (type != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" type = ").append("'").append(type).append("'");
            attribCount++;
        }

        if (wordCase != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" word_case = ").append("'").append(wordCase).append("'");
            attribCount++;
        }

        if (comparative != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" comparative = ").append("'").append(comparative).append("'");
            attribCount++;
        }

        if (animate != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" animate = ").append("'").append(animate).append("'");
            attribCount++;
        }

        if (adverbType != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" adverb_type = ").append("'").append(adverbType).append("'");
            attribCount++;
        }

        if (face != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" face = ").append("'").append(face).append("'");
            attribCount++;
        }

        if (infinitive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" infinitive = ").append("'").append(infinitive).append("'");
            attribCount++;
        }

        if (kind != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" kind = ").append("'").append(kind).append("'");
            attribCount++;
        }

        if (perfect != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" perfect = ").append("'").append(perfect).append("'");
            attribCount++;
        }

        if (reflexive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" reflexive = ").append("'").append(reflexive).append("'");
            attribCount++;
        }

        if (time != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" time = ").append("'").append(time).append("'");
            attribCount++;
        }

        if (transitive != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" transitive = ").append("'").append(transitive).append("'");
            attribCount++;
        }

        if (voice != null) {
            if (attribCount > 0)
                hql.append(" AND");
            hql.append(" voice = ").append("'").append(voice).append("'");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql.toString());
        wordsList = query.getResultList();
        session.close();
        return wordsList;
    }
}
