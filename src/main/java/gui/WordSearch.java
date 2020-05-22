package gui;

import org.codehaus.plexus.util.StringUtils;
import utilities.WRandom;
import utilities.Word;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class WordSearch extends WordGames {
    protected JPanel contentPane;
    protected JButton buttonSearch;
    protected JButton buttonAdd;
    protected JTabbedPane tabbedPane1;
    protected JTextField textField1;
    protected JCheckBox checkBox1;
    protected JTextArea textArea1;
    protected JProgressBar progressBar1;
    protected JRadioButton idRadioButton;
    protected JRadioButton hexRadioButton;
    protected JCheckBox autoSearchCheckBox;
    protected JLabel idHexLabel;

    public WordSearch() {
        setTitle("Поиск слов");
        setContentPane(contentPane);
        setSize(350,400);
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(buttonSearch);

        idRadioButton.addChangeListener(new ChangeListener() {
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

        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1();
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
            idHexLabel.setText("ID:");
            autoSearchCheckBox.setSelected(true);
        } else {
            idHexLabel.setText("HEX:");
            autoSearchCheckBox.setSelected(false);
        }
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
    private void onSearch() {
        progressBar1.setValue(34);
        if (!textField1.getText().isEmpty()) {
            if(idRadioButton.isSelected()) {
                word = Word.findById(Integer.parseInt(textField1.getText()));
                if (word == null) {
                    textArea1.setText("Слово не найдено");
                } else {
                    checkBox1();
                }
            } else {
                word = new WRandom(textField1.getText()).getSingleWord();
                if (word == null) {
                    textArea1.setText("Слово не найдено");
                } else {
                    checkBox1();
                }
            }
        }
    }

    private void checkBox1() {
        if (word != null) {
            if (checkBox1.isSelected()) {
                textArea1.setText(word.getWord());
            } else {
                textArea1.setText(word.getInfo());
            }
        }
    }

    private void onAdd() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        WordSearch dialog = new WordSearch();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
