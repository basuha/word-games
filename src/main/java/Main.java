import utilities.Type;
import utilities.Dictionary;
import words.Word;
import words.attributes.IsPlural;
import words.attributes.WCase;
import words.primary.Adjective;
import words.primary.Participle;
import words.secondary.Particle;
import words.secondary.Pronoun;

import java.util.ArrayList;
import java.util.List;

//сделать астропрогноз. рандомизатор будет принимать знак зодиака и дату в качестве seed
public class Main {
    public static void main(String[] args) {
        Adjective adjective = new Adjective();
        System.out.println(adjective.getInfo());

        adjective.setParam(IsPlural.PLURAL);
        adjective.setParam(WCase.DATIVE);
        System.out.println(adjective.getInfo());

        Dictionary dictionary = new Dictionary();

        for(Adjective a : dictionary.getWordsByAttrib(adjective)) {
            System.out.println(a);
        }
    }
}
