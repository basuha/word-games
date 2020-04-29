package words;

import com.sun.istack.Nullable;
import utilities.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Наречие
 */
@Entity
@DiscriminatorValue(Type.ADVERB)
public class Adverb extends Word {

    @Nullable
    @Column(name = "type_sub")
    private String meaning;

    @Nullable
    @Column(name = "type_ssub")
    private String subType;

    @Nullable
    @Column(name = "comp")
    private String comp;

    /**
     * Классификация наречия по значению:
     * <li>{@link #EXTENSIVE} - обстоятельственные</li>
     * <li>{@link #DEFINITE} - определительные</li>
     * <li>{@link #QUESTION} - вопросительные</li>
     */
    public enum Meaning {

        /** обстоятельственные */
        EXTENSIVE("обст"),

        /** определительные */
        DEFINITE("опред"),

        /** вопросительные */
        QUESTION("вопр");

        private final String value;

        Meaning(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Подтипы наречия:
     * <li>{@link #QUALITATIVE} - качественные</li>
     * <li>{@link #METHOD} - способа и образа действия</li>
     * <li>{@link #EXTENT} - степени действия</li>
     * <li>{@link #PLACE} - места действия</li>
     * <li>{@link #DIRECTION} - направление действия</li>
     * <li>{@link #TIMING} - времени действия</li>
     * <li>{@link #PURPOSE} - цели действия</li>
     * <li>{@link #REASON} - причины действия</li>
     * Степень сравнения:
     * <li>{@link #COMPARATIVE} - сравнительная степень</li>
     * <li>{@link #SUPER} - превосходная степень</li>
     */
    public enum SubType {

        /** качественные */
        QUALITATIVE("кач"),

        /** способа и образа действия */
        METHOD("спос"),

        /** степени действия */
        EXTENT("степ"),

        /** места действия */
        PLACE("места"),

        /** направление действия */
        DIRECTION("напр"),

        /** времени действия */
        TIMING("врем"),

        /** цели действия */
        PURPOSE("цель"),

        /** причины действия */
        REASON("причин"),

        /** сравнительная степень */
        COMPARATIVE("сравн"),

        /** превосходная степень */
        SUPER("прев");

        private final String value;

        SubType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }


    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(Meaning meaning) {
        this.meaning = subType.toString();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        if (subType == SubType.COMPARATIVE
            || subType == SubType.SUPER) {
            this.comp = subType.toString();
            this.subType = null;
        } else {
            this.subType = subType.toString();
            this.comp = null;
        }
    }

    public String getComp() {
        return comp;
    }

    @Override
    public void addCognate(Word cognate) {
    }

    @Override
    public List<Word> getCognates() {
        return null;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adverb (Наречие){" +
                "subType='" + meaning + '\'' +
                ", advSubType='" + subType + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}

