package gui;

import org.codehaus.plexus.util.StringUtils;
import utilities.WAsyncTask;
import utilities.WDummy;
import utilities.Word;

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

    private JComboBox attribComboBox1;
    private JComboBox attribComboBox2;
    private JComboBox attribComboBox3;
    private JComboBox attribComboBox4;
    private JComboBox attribComboBox5;
    private JComboBox attribComboBox6;
    private JComboBox attribComboBox7;
    private JComboBox attribComboBox8;
    private JComboBox attribComboBox9;
    private JComboBox attribComboBox10;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;

    private JRadioButton attribRadioButton;
    private JRadioButton wordRadioButton;
    private JList list1;
    private JButton minusButton;
    private JButton plusButton;
    private JPanel scrollBar;
    private JScrollPane scrollPane;
    private ButtonGroup typeChangeRadioGroup;
    private DefaultListModel<Word> listModel = new DefaultListModel<>();

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
            idHexLabel.setEnabled(true);
            textField1.setEnabled(true);
            idHexLabel.setText("ID:");
        } else if (hexRadioButton.isSelected()){
            idHexLabel.setEnabled(true);
            textField1.setEnabled(true);
            idHexLabel.setText("HEX:");
        } else if (attribRadioButton.isSelected()) {
            idHexLabel.setEnabled(false);
            textField1.setEnabled(false);
        } else if (wordRadioButton.isSelected()) {
            idHexLabel.setText("Слово: ");
            idHexLabel.setEnabled(true);
            textField1.setEnabled(true);
        }
    }

    private void setVisibilityOfComboBoxes(boolean value) {

    }

    private void textFieldAction() {
        if(StringUtils.isNumeric(textField1.getText())) {
            buttonSearch.setEnabled(!textField1.getText().isEmpty());
            if (autoSearchCheckBox.isSelected()) {
                onSearch();
            }
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
                progress = wAsyncTask.getProgress();
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
