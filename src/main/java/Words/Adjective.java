package Words;

import com.sun.istack.Nullable;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(Type.ADJECTIVE)
@Table(name = "words_test")
public class Adjective extends Word {

    @Column(name = "short")
    private Boolean shortF;

    @Column(name = "plural")
    private Boolean plural;

    @Column(name = "gender")
    private String gender;

    @Column(name = "type_sub")
    private String subType;

    @Column(name = "wcase")
    private String wCase;

    @Column(name = "comp")
    private String comp;

    public void reload() {
        Session session = getSessionFactory().openSession();
        String hql;
//        if (subType == null && comp == null) {
            hql = "FROM Adjective WHERE shortF = :s " +
                    "AND plural = :p " +
                    "AND gender = :g " +
                    "AND subType IS NULL " +
                    "AND wCase = :w " +
                    "AND comp IS NULL";
//        } else {
//            hql = "FROM Adjective WHERE shortF = :s " +
//                    "AND plural = :p " +
//                    "AND gender = :g " +
//                    "AND subType = :s " +
//                    "AND wCase = :w " +
//                    "AND comp = :co";
//        }

        Query query = session.createQuery(hql);
        query.setParameter("s", this.shortF);
        query.setParameter("p", this.plural);
        query.setParameter("g", this.gender);
//        query.setParameter("s", this.subType);
        query.setParameter("w", this.wCase);
//        query.setParameter("co", this.comp);

        List<Adjective> adj = query.getResultList();
        Adjective adjective = adj.get(0);
        System.out.println(adj.size());
        session.close();

        setWord(adjective.getWord());
        setIID(adjective.getIID());
        setCode(adjective.getCodeParent());
        setCodeParent(adjective.getCodeParent());
    }

    public static class SubType {
        public static final String IMMUTABLE = "неизм";
    }

    public static class Gender {
        public static final String MALE = "муж";
        public static final String FEMALE = "жен";
        public static final String NEUTER = "ср";
    }

    public static class WCase {
        public static final String NOMINATIVE = "им";
        public static final String GENITIVE = "род";
        public static final String DATIVE = "дат";
        public static final String ACCUSATIVE = "вин";
        public static final String INSTRUMENTAL = "тв";
        public static final String PREPOSITIONAL = "пр";
    }

    public static class Comp {
        public static final String COMPARATIVE = "сравн";
        public static final String SUPER = "прев";
    }

    public Boolean getShortF() {
        return shortF;
    }

    public void setShortF(Boolean shortF) {
        this.shortF = shortF;
    }

    public Boolean getPlural() {
        return plural;
    }

    public void setPlural(Boolean plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getwCase() {
        return wCase;
    }

    public void setwCase(String wCase) {
        this.wCase = wCase;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return "Adjective{" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + subType + '\'' +
                ", wCase='" + wCase + '\'' +
                ", comp='" + comp + '\'' +
                ", IID=" + IID +
                ", word='" + word + '\'' +
                ", code=" + code +
                ", type='" + type + '\'' +
                ", codeParent=" + codeParent +
                '}';
    }
}
