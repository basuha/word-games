package gui;

import utilities.WAttribute;
import words.attributes.primary.Gender;
import words.attributes.primary.WordCase;

import javax.swing.*;

public class WAttributesAdaptor extends JPanel {
    private WAttribute[] items = {Gender.FEMALE, Gender.MALE, WordCase.COUNTING};

    public WAttributesAdaptor() {
        add(new JComboBox<>(items));
    }
}
