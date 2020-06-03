package gui;

import org.codehaus.plexus.util.StringUtils;
import utilities.WAsyncTask;
import utilities.WDummy;
import utilities.Word;
import utilities.WAttribute;
import words.attributes.primary.Gender;
import words.attributes.primary.PartOfSpeech;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class WSearchDialogue extends JDialog {

    protected JPanel contentPane;
    protected JButton searchButton;
    protected JButton buttonAdd;
    protected JTextField textField1;
    protected JProgressBar progressBar1;
    protected JRadioButton idRadioButton;
    protected JRadioButton hexRadioButton;
    protected JCheckBox autoSearchCheckBox;
    protected JLabel mainLabel;

    private JRadioButton attribRadioButton;
    private JRadioButton wordRadioButton;
    private JList list1;
    private JPanel scrollBar;
    private JScrollPane scrollPane;
    private JPanel attributesPanel;
    private JList list2;
    private JScrollPane scrollPane2;
    private JButton deleteButton;
    private JButton addButton;
    private JButton cleanButton;
    private ButtonGroup typeChangeRadioGroup;
    private DefaultListModel<Word> listModel = new DefaultListModel<>();
    private DefaultComboBoxModel<WAttribute> comboBoxModel = new DefaultComboBoxModel<>();

    private Word selectedWord;

    public WSearchDialogue() {
        setTitle("Поиск слов");
        setContentPane(contentPane);

        setSize(750,450);
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(searchButton);
        setLocationRelativeTo(null);
        list1.setModel(listModel);
        scrollPane.setViewportView(list1);
        scrollPane2.setViewportView(list2);
        attributesPanel.setLayout(new GridBagLayout());


        WDummy wDummy = new WDummy("проверка");
        wDummy.setCode(1234);
        wDummy.setCodeParent(66666);
        wDummy.setPartOfSpeech(PartOfSpeech.NUMERAL);
        wDummy.setGender(Gender.FEMALE);

//        attributesPanel.add(new WAttributesPanel(wDummy));
//        pack();


        list1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    selectedWord = (Word) list1.getSelectedValue();
                    attributesPanel.add(new WAttributesPanel(selectedWord));
                }
            }
        });



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

        searchButton.addActionListener(new ActionListener() {
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

    private void extractAttributesFromSelectedWord() {
        attributesPanel.add(new WAttributesPanel());
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
        mainLabel.setEnabled(true);
        textField1.setEnabled(true);
        mainLabel.setText("ID:");
    }

    private void searchByHEXMode() {
        hexRadioButton.setSelected(true);
        mainLabel.setEnabled(true);
        textField1.setEnabled(true);
        mainLabel.setText("HEX:");
    }

    private void searchByAttribMode() {
        attribRadioButton.setSelected(true);
        mainLabel.setEnabled(false);
        textField1.setEnabled(false);
    }

    private void searchByWordMode() {
        wordRadioButton.setSelected(true);
        mainLabel.setText("Слово: ");
        mainLabel.setEnabled(true);
        textField1.setEnabled(true);
    }

    private void setVisibilityOfComboBoxes(boolean value) {

    }

    private void textFieldAction() {
        if (!textField1.getText().isEmpty()) {
            if (StringUtils.isNumeric(textField1.getText())) {
                searchButton.setEnabled(!textField1.getText().isEmpty());

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
        } else {
            searchButton.setEnabled(false);
        }
    }


    Word word;
    List<Word> wordList;

    private void onSearch() {
        list1.setSelectedValue(null,true);
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
