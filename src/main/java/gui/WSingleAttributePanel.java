package gui;

import org.apache.poi.ss.formula.functions.T;
import utilities.WAttribute;
import words.attributes.primary.Gender;

import javax.swing.*;
import java.awt.*;

public class WSingleAttributePanel extends WAttributesPanel {
    private JLabel attribLabel;
    private JComboBox<WAttribute> attribComboBox;
    private DefaultComboBoxModel<WAttribute> attribComboBoxModel;
    private static final Dimension DEFAULT_SIZE = new Dimension(150,20);

    public WSingleAttributePanel(WAttribute attribute) {
        super(new FlowLayout(10));
        setMaximumSize(DEFAULT_SIZE);
        setMinimumSize(DEFAULT_SIZE);
        setPreferredSize(DEFAULT_SIZE);

        attribLabel = new JLabel(attribute.getLocalizedAttributeName() + ":");
        attribLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(attribLabel);



        attribComboBoxModel = new DefaultComboBoxModel(WAttribute.getLocalizedValueArray(attribute));
        attribComboBox = new JComboBox<>();
        attribComboBox.setModel(attribComboBoxModel);
        attribComboBox.setAlignmentY(TOP_ALIGNMENT);
        attribComboBox.setSelectedItem(null);

        add(attribComboBox);
    }
}
