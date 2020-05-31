package gui;

import org.codehaus.plexus.util.StringUtils;
import utilities.WAsyncTask;
import utilities.WDummy;
import utilities.Word;
import utilities.WAttribute;
import words.attributes.primary.AdverbType;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.List;

public class WordSearch extends JDialog {

    protected JPanel contentPane;
    protected JButton buttonSearch;
    protected JButton buttonAdd;
    protected JTextField textField1;
    protected JProgressBar progressBar1;
    protected JRadioButton idRadioButton;
    protected JRadioButton hexRadioButton;
    protected JCheckBox autoSearchCheckBox;
    protected JLabel idHexLabel;

    private JRadioButton attribRadioButton;
    private JRadioButton wordRadioButton;
    private JList list1;
    private JButton minusButton;
    private JButton plusButton;
    private JPanel scrollBar;
    private JScrollPane scrollPane;
    private JPanel attributesPanel;
    private JComboBox comboBox1;
    private ButtonGroup typeChangeRadioGroup;
    private DefaultListModel<Word> listModel = new DefaultListModel<>();
    private DefaultComboBoxModel<WAttribute> comboBoxModel = new DefaultComboBoxModel<>();

    public WordSearch() {
        setTitle("Поиск слов");
        setContentPane(contentPane);
        pack();
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(buttonSearch);
        setLocationRelativeTo(null);
        list1.setModel(listModel);
        scrollPane.setViewportView(list1);


        comboBoxModel.addElement(AdverbType.DIRECTION);

        attributesPanel.add(new JComboBox<>(comboBoxModel),1);



        idRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                idHexButtons();
            }
        });
        hexRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                idHexButtons();
            }
        });
        attribRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                idHexButtons();
            }
        });
        wordRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                idHexButtons();
            }
        });

        textField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                textFieldAction();
            }
            public void removeUpdate(DocumentEvent e) {
                textFieldAction();
            }
            public void insertUpdate(DocumentEvent e) {
                textFieldAction();
            }
        });

        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSearch();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });

        textField1.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField1.getCaret().isVisible()) {
                    onSearch();
                }
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void idHexButtons() {
        if (idRadioButton.isSelected()) {
            searchByIDMode();
        } else if (hexRadioButton.isSelected()){
            searchByHEXMode();
        } else if (attribRadioButton.isSelected()) {
            searchByAttribMode();
        } else if (wordRadioButton.isSelected()) {
            searchByWordMode();
        }
    }

    private void searchByIDMode() {
        idRadioButton.setSelected(true);
        idHexLabel.setEnabled(true);
        textField1.setEnabled(true);
        idHexLabel.setText("ID:");
    }

    private void searchByHEXMode() {
        hexRadioButton.setSelected(true);
        idHexLabel.setEnabled(true);
        textField1.setEnabled(true);
        idHexLabel.setText("HEX:");
    }

    private void searchByAttribMode() {
        attribRadioButton.setSelected(true);
        idHexLabel.setEnabled(false);
        textField1.setEnabled(false);
    }

    private void searchByWordMode() {
        wordRadioButton.setSelected(true);
        idHexLabel.setText("Слово: ");
        idHexLabel.setEnabled(true);
        textField1.setEnabled(true);
    }

    private void setVisibilityOfComboBoxes(boolean value) {

    }

    private void textFieldAction() {
        if(StringUtils.isNumeric(textField1.getText())) {
            buttonSearch.setEnabled(!textField1.getText().isEmpty());

            if (autoSearchCheckBox.isSelected()) {
                onSearch();
            }

            if (wordRadioButton.isSelected()) {
                searchByIDMode();
            }

        } else {
            autoSearchCheckBox.setSelected(false);
            searchByWordMode();
        }
    }


    Word word;
    List<Word> wordList;

    private void onSearch() {
    if (!textField1.getText().isEmpty()) {
        if(idRadioButton.isSelected()) {
            word = Word.findById(Integer.parseInt(textField1.getText()));
            listModel.clear();
            if (word == null) {
                listModel.addElement(new WDummy("Cлово не найдено"));
            } else {
                listModel.addElement(word);
            }

        } else if(hexRadioButton.isSelected()){
            WAsyncTask wAsyncTask = new WAsyncTask(textField1.getText());
            wAsyncTask.run();

            listModel.clear();

            int progress;
            do {
                progress = wAsyncTask.getProgress(); //Должно работать
                progressBar1.setValue(progress);
            } while (progress != 100);

            wordList = wAsyncTask.getList();
            if (wordList == null) {
                listModel.addElement(new WDummy("Cлово не найдено"));
            } else {
                listModel.addAll(wordList);
            }


        } else if(attribRadioButton.isSelected()){
        }

        } else if(wordRadioButton.isSelected()){
        }
    }

    private void onAdd() {
        // add your code here if necessary
        dispose();
    }
}
