package gui;

import utilities.WAttribute;
import utilities.WDummy;
import utilities.Word;
import words.attributes.primary.Gender;
import words.attributes.primary.WordCase;

import javax.swing.*;
import java.awt.*;

public class WAttributesPanel extends JPanel {
    private GridLayout gridLayout = new GridLayout(8,4,10,10);

    public WAttributesPanel() {
    }

    public WAttributesPanel(LayoutManager layout) {
        super(layout);
    }

    public WAttributesPanel(WDummy word) {
        setLayout(gridLayout);
        add(new WSingleAttributePanel(word.getGender()));
        add(new WSingleAttributePanel(word.getGender()));
        add(new WSingleAttributePanel(word.getGender()));
        add(new WSingleAttributePanel(word.getGender()));
        add(new WSingleAttributePanel(word.getGender()));
    }

//    public void addAttribute(WAttribute attribute) {
//        add(new WSingleAttributePanel(attribute));
//    }
}
