package Words;

import com.sun.istack.Nullable;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(Type.ADJECTIVE)
public class Adjective extends Word {

    @Column(name = "short")
    private Boolean shortF;

    @Column(name = "plural")
    private Boolean plural;

    @Column(name = "gender")
    private String gender;

    @Nullable
    @Column(name = "type_sub")
    private String subType;

    @Column(name = "wcase")
    private String wCase;

    @Nullable
    @Column(name = "comp")
    private String comp;

    public void reload() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Adjective AS a " +
                "WHERE (:subType IS NULL OR a.subType = :subType) " +
                "AND (:comp IS NULL OR a.comp = :comp) " +
                "AND a.shortF = :shortF " +
                "AND a.plural = :plural " +
                "AND a.gender = :gender " +
                "AND a.wCase = :wCase ");

        query.setParameter("subType", this.subType);
        query.setParameter("comp", this.comp);
        query.setParameter("shortF", this.shortF);
        query.setParameter("plural", this.plural);
        query.setParameter("gender", this.gender);
        query.setParameter("wCase", this.wCase);


        List<Adjective> adj = query.getResultList();
        Adjective adjective = adj.get(0);
        System.out.println(adj.size());
        session.close();

        setWord(adjective.getWord());
        setIID(adjective.getIID());
        setCode(adjective.getCodeParent());
        setCodeParent(adjective.getCodeParent());
    }

    @Override
    public void addCognate(Word cognate) {
        this.cognates.add(cognate);
    }

    @Override
    public List<Word> getCognates() {
        return cognates;
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
    public String getInfo() {
        return super.getInfo() +
                "{" +
                "shortF=" + shortF +
                ", plural=" + plural +
                ", gender='" + gender + '\'' +
                ", subType='" + subType + '\'' +
                ", wCase='" + wCase + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}
