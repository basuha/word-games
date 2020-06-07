package gui;

import org.apache.poi.ss.formula.functions.T;
import utilities.WAttribute;
import words.attributes.primary.Gender;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class WSingleAttributePanel extends WAttributesPanel {
    private JLabel attribLabel;
    private JComboBox<WAttribute> attribComboBox;
    private DefaultComboBoxModel<WAttribute> attribComboBoxModel;
    private final static FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
    private final static Dimension DEFAULT_SIZE = new Dimension(200,25);

    public WSingleAttributePanel(WAttribute attribute) {
        super(flowLayout);
        createAttributeComboBox(attribute);
    }

    private void createAttributeComboBox(WAttribute attribute) {
        setPreferredSize(DEFAULT_SIZE);

        attribLabel = new JLabel(attribute.getLocalizedAttributeName() + ":");
        attribLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(attribLabel);

        attribComboBoxModel = new DefaultComboBoxModel(attribute.getLocalizedValueArray());
        attribComboBox = new JComboBox<>();
        attribComboBox.setModel(attribComboBoxModel);
        attribComboBox.setSelectedItem(attribute.getLocalizedValue());

        add(attribComboBox);
    }
}
