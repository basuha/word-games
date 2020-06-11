package gui;

import org.apache.commons.lang3.StringUtils;
import utilities.*;
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
    private JList<IWord> list1;
    private JScrollPane scrollPane;
    private JPanel attributesPanel;
    protected WAttributesPanel wAttributesPanel;
    private JList<IWord> list2;
    private JButton createButton;
    private JButton button3;
    private JScrollPane scrollPane2;
    private JButton deleteButton;
    private JButton addButton;
    private JButton cleanButton;
    private JTextField wordField;
    private JTextField IDfield;
    private JTextField HEXField;
    private JComboBox<WAttribute> partOfSpeechComboBox;
    private ButtonGroup typeChangeRadioGroup;
    private DefaultListModel<IWord> listModel = new DefaultListModel<>();
    private DefaultComboBoxModel<WAttribute> comboBoxModel = new DefaultComboBoxModel<>();

    private IWord selectedWord;

    public WSearchDialogue() {
        setTitle("Поиск слов");
        setContentPane(contentPane);

        partOfSpeechComboBox.setModel(new DefaultComboBoxModel(PartOfSpeech.NOUN.getLocalizedValueArray()));
        partOfSpeechComboBox.setSelectedItem(null);

        setSize(850,500);
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(searchButton);
        setLocationRelativeTo(null);
        list1.setModel(listModel);
        scrollPane.setViewportView(list1);
        scrollPane2.setViewportView(list2);
        attributesPanel.setLayout(new GridBagLayout());
        attributesPanel.setVisible(true);


//        WDummy wDummy = new WDummy("проверка");
//        wDummy.setCode(1234);
//        wDummy.setCodeParent(66666);
//        wDummy.setPartOfSpeech(PartOfSpeech.NUMERAL);
//        wDummy.setGender(Gender.FEMALE);
//        attributesPanel.add(new WAttributesPanel(wDummy));
//        pack();

        addListenerToMenuList();

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

        IDfield.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IDfield.getCaret().isVisible()) {
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
                    selectedWord = list1.getSelectedValue();
                    attribAction();
                    list1.updateUI();
                }
                else {
                    System.out.println("I think the value is adjusting");
                }
            }
        });
    }

    List<IWord> wordList;
    WAsyncTask wAsyncTask;

    private void onSearch() {
        if (idRadioButton.isSelected()) {
            searchByIdLogic();
        } else if (hexRadioButton.isSelected()) {
            wAsyncTask = new WAsyncTask(textField1.getText());
            searchLogic();
        } else if (wordRadioButton.isSelected()) {
            wAsyncTask = new WAsyncTask(new WDummy(textField1.getText()));
            searchLogic();
        }
    }

    private void searchByIdLogic() {
        if(!IDfield.getText().isEmpty() && StringUtils.isNumeric(IDfield.getText())) {
            selectedWord = Word.findById(Integer.parseInt(IDfield.getText()));
            listModel.clear();
            if (selectedWord == null) {
                wordField.setText("слово не найдено");
                attributesPanel.removeAll();
                attributesPanel.updateUI();
            } else {
                wordField.setText(selectedWord.getWord());
                WordToHex wordToHex = new WordToHex(selectedWord);
                Thread thread = new Thread(wordToHex);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HEXField.setText(wordToHex.getHexOut().toString());
                partOfSpeechComboBox.setSelectedItem(selectedWord.getPartOfSpeech());
                attribAction();
            }
        }
    }

    private void searchLogic() {
        wAsyncTask.run();
        listModel.clear();
        int progress;
        do {
            progress = wAsyncTask.getProgress(); //Должно работать
            progressBar1.setValue(progress);
        } while (progress != 100);

        wordList = wAsyncTask.getList();
        if (wordList == null) {
            wordField.setText("слов не найдено");
        } else {
            listModel.addAll(wordList);
        }
    }

    private void attribAction() {
        wAttributesPanel = new WAttributesPanel(selectedWord);
        attributesPanel.remove(wAttributesPanel);
        attributesPanel.removeAll();
        attributesPanel.updateUI();
        wAttributesPanel.updateUI();
        attributesPanel.add(wAttributesPanel);
        attributesPanel.updateUI();
        wAttributesPanel.updateUI();
    }

    private void onAdd() {
        // add your code here if necessary
        dispose();
    }
}
