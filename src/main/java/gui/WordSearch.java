package gui;

import utilities.Word;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class WordSearch extends WordGames {
    private JPanel contentPane;
    private JButton buttonSearch;
    private JButton buttonAdd;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JTextArea textArea1;
    private JProgressBar progressBar1;

    public WordSearch() {
        setTitle("Поиск слов");
        setContentPane(contentPane);
        setSize(350,400);
        setResizable(false);
        setModal(true);
        getRootPane().setDefaultButton(buttonSearch);

        textField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                textFieldAction();
                onSearch();
            }
            public void removeUpdate(DocumentEvent e) {
                textFieldAction();
                onSearch();
            }
            public void insertUpdate(DocumentEvent e) {
                textFieldAction();
                onSearch();
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

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField1.getCaret().isVisible()) {
                    onSearch();
                }
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void textFieldAction() {
        if(!textField1.getText().isEmpty()) {
            buttonSearch.setEnabled(true);
        } else {
            buttonSearch.setEnabled(false);
        }
    }

    Word word;
    private void onSearch() {
        progressBar1.setValue(34);
        if (!textField1.getText().isEmpty()) {
            word = Word.findById(Integer.parseInt(textField1.getText()));
            if (word == null) {
                textArea1.setText("Слово не найдено");
            } else {
                checkBox1();
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
