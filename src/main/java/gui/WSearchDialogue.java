package gui;

import org.apache.fontbox.ttf.TTFDataStream;
import org.apache.poi.ss.formula.functions.T;
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
    protected JRadioButton attribRadioButton;
    protected JRadioButton wordRadioButton;

    protected JCheckBox autoSearchCheckBox;
    protected JLabel mainLabel;
    private JList<Word> list1;
    private JScrollPane scrollPane;
    private JPanel attributesPanel;
    private JList<Word> list2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
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

        setSize(850,450);
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(searchButton);
        setLocationRelativeTo(null);
        list1.setModel(listModel);
        scrollPane.setViewportView(list1);
        scrollPane2.setViewportView(list2);
        attributesPanel.setLayout(new GridBagLayout());
        attributesPanel.setVisible(true);


        WDummy wDummy = new WDummy("проверка");
        wDummy.setCode(1234);
        wDummy.setCodeParent(66666);
        wDummy.setPartOfSpeech(PartOfSpeech.NUMERAL);
        wDummy.setGender(Gender.FEMALE);

//        attributesPanel.add(new WAttributesPanel(wDummy));
//        pack();

        addListenerToMenuList();

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

    private void addListenerToMenuList() {
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedWord = (Word) list1.getSelectedValue();
                    attribAction();
                }
                else {
                    System.out.println("I think the value is adjusting");
                }
            }
        });
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
        autoSearchCheckBox.setSelected(true);
    }

    private void searchByHEXMode() {
        hexRadioButton.setSelected(true);
        mainLabel.setEnabled(true);
        textField1.setEnabled(true);
        mainLabel.setText("HEX:");
        autoSearchCheckBox.setSelected(false);
    }

    private void searchByAttribMode() {
        attribRadioButton.setSelected(true);
        mainLabel.setEnabled(false);
        textField1.setEnabled(false);
        autoSearchCheckBox.setSelected(false);
    }

    private void searchByWordMode() {
        wordRadioButton.setSelected(true);
        mainLabel.setText("Слово: ");
        mainLabel.setEnabled(true);
        textField1.setEnabled(true);
        autoSearchCheckBox.setSelected(false);
    }

    private void textFieldAction() {
        searchButton.setEnabled(!textField1.getText().isEmpty());
        if (StringUtils.isNumeric(textField1.getText())) {
            if (autoSearchCheckBox.isSelected()) {
                onSearch();
            }

            if (idRadioButton.isSelected()) {
                searchByIDMode();
            }
        } else {
            searchByWordMode();
        }
    }

    List<Word> wordList;

    private void onSearch() {
    if (!textField1.getText().isEmpty()) {
        if(idRadioButton.isSelected()) {
            selectedWord = Word.findById(Integer.parseInt(textField1.getText()));
            listModel.clear();
            if (selectedWord == null) {
                listModel.addElement(new WDummy("Cлово не найдено"));
            } else {
                listModel.addElement(selectedWord);
                attribAction();
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

    private void attribAction() {
        attributesPanel.removeAll();
        attributesPanel.add(new WAttributesPanel(selectedWord));
    }
    private void onAdd() {
        // add your code here if necessary
        dispose();
    }

}
