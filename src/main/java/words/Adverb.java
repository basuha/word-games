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
    private String subType;

    @Nullable
    @Column(name = "type_ssub")
    private String advSubType;

    @Nullable
    @Column(name = "comp")
    private String comp;

    /**
     * Классификация по значению:
     * обстоятельственные, определительные и вопросительные.
     */
    public enum SubType {

        /**
         * обстоятельственные
         */
        EXTENSIVE("обст"),

        /**
         * определительные
         */
        DEFINITE("опред"),

        /**
         * вопросительные
         */
        QUESTION("вопр");

        private final String value;

        SubType (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Подтипы: способ и образ действия, качественные,
     * места действия, цели, причины и времени.
     */
    public enum AdvSubType {

        /**
         * качественные
         */
        QUALITATIVE ("кач"),

        /**
         * способа и образа действия
         */
        METHOD ("спос"),

        /**
         * степени действия
         */
        EXTENT ("степ"),

        /**
         * места действия
         */
        PLACE ("места"),

        /**
         * направление действия
         */
        DIRECTION ("напр"),

        /**
         * времени действия
         */
        TIMING ("врем"),

        /**
         * цели действия
         */
        PURPOSE ("цель"),

        /**
         * причины действия
         */
        REASON ("причин");

        private final String value;

        AdvSubType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Классификация по степени сравнения:
     * сравнительная и превосходная
     */

    public enum Comp {

        /**
         * сравнительная степень
         */
        COMPARATIVE("сравн"),

        /**
         * превосходная степень
         */
        SUPER("прев");

        private final String value;

        Comp (String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType.toString();
    }

    public String getAdvSubType() {
        return advSubType;
    }

    public void setAdvSubType(AdvSubType advSubType) {
        this.advSubType = advSubType.toString();
    }

    public String getComp() {
        return comp;
    }

    public void setComp(Comp comp) {
        this.comp = comp.toString();
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                " Adverb{" +
                "subType='" + subType + '\'' +
                ", advSubType='" + advSubType + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }


    @Override
    public void addCognate(Word cognate) {
    }

    @Override
    public List<Word> getCognates() {
        return null;
    }
}
