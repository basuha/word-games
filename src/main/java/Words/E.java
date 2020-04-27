package Words;

public class E {
    private static class SubType {
        public static final String ORDINAL = "поряд";
        public static final String QUANTITATIVE = "кол";
        public static final String COLLECTIVE = "собир";
        public static final String INDEFINITE = "неопр";
        public static final String TIMING = "врем";
        public static final String EXTENSIVE = "обст";
        public static final String DEFINITE = "опред";
        public static final String COUNTING = "счет";
        public static final String IMMUTABLE = "неизм";
    }
    private static class AdvSubType {
        public static final String QUALITATIVE = "кач";
        public static final String METHOD = "спос";
        public static final String EXTENT = "степ";
        public static final String PLACE = "места";
        public static final String DIRECTION = "напр";
        public static final String TIMING = "врем";
        public static final String PURPOSE = "цель";
        public static final String REASON = "причин";
    }
    private static class Gender {
        public static final String MALE = "муж";
        public static final String FEMALE = "жен";
        public static final String NEUTER = "ср";
        public static final String COMMON = "общ";
    }
    private static class Wcase {
        public static final String NOMINATIVE = "им";
        public static final String GENITIVE = "род";
        public static final String DATIVE = "дат";
        public static final String ACCUSATIVE = "вин";
        public static final String INSTRUMENTAL = "тв";
        public static final String PREPOSITIONAL = "пр";
        public static final String VOCATIVE = "зват";
        public static final String PARTITIVE = "парт";
        public static final String LOCATIVE = "мест";
        public static final String COUNTING = "счет";
    }
    private static class Comp {
        public static final String COMPARATIVE = "сравн";
        public static final String SUPER = "прев";
    }
    private static class Transit {
        public static final String TRANSITIVE = "перех";
        public static final String INTRANSITIVE = "непер";
        public static final String TRANS_INTRANS = "пер/не";
    }
    private static class Face {
        public static final String FIRST = "1-е";
        public static final String SECOND = "2-е";
        public static final String THIRD = "3-е";
        public static final String ANONYMOUS = "безл";
    }
    private static class Kind {
        public static final String FIRST = "1вид";
        public static final String SECOND = "2вид";
    }
    private static class Time {
        public static final String PAST = "прош";
        public static final String PRESENT = "наст";
        public static final String FUTURE = "буд";
    }
    private static class Voice {
        public static final String ACTIVE = "пов";
        public static final String PASSIVE = "страд";
    }

}
