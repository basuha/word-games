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
    private JSeparator separator;
    private static final Dimension DEFAULT_SIZE = new Dimension(200,25);

    public WSingleAttributePanel(WAttribute attribute) {
        super(new FlowLayout(FlowLayout.CENTER));
        createAttributeComboBox(attribute);
    }

    private void createAttributeComboBox(WAttribute attribute) {
        setPreferredSize(DEFAULT_SIZE);

        attribLabel = new JLabel(attribute.getLocalizedAttributeName() + ":");
        add(attribLabel);

        attribComboBoxModel = new DefaultComboBoxModel(WAttribute.getLocalizedValueArray(attribute));
        attribComboBox = new JComboBox<>();
        attribComboBox.setModel(attribComboBoxModel);
        attribComboBox.setSelectedItem(attribute.getLocalizedValue());

        add(attribComboBox);

        separator = new JPopupMenu.Separator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        add(separator);
    }
}
