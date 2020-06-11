package gui;

import utilities.IWord;
import utilities.WAttribute;
import utilities.WDummy;
import utilities.Word;
import words.attributes.primary.Gender;
import words.attributes.primary.WordCase;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class WAttributesPanel extends JPanel {
    private GridLayout gridLayout = new GridLayout(6,2,1,1);
    private Field[] fields;

    public WAttributesPanel(LayoutManager layout) {
        super(layout);
    }

    public WAttributesPanel(IWord word) {
        setLayout(gridLayout);
        setPreferredSize(new Dimension(400,250));
        setMaximumSize(new Dimension(400,250));
        fields = word.getWAttributes();
        System.out.println(Arrays.toString(fields));
        for (int i = 0; i < fields.length; i++) {
            try {
                if (fields[i].get(word) instanceof Enum)
                    add(new WSingleAttributePanel((WAttribute) fields[i].get(word)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

//    public void addAttribute(WAttribute attribute) {
//        add(new WSingleAttributePanel(attribute));
//    }
}
