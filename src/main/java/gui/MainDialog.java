package gui;

import utilities.RandomWord;
import utilities.Zodiac;
import words.Word;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JCheckBox randomCheckBox;
    private Word word;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        button1.addActionListener(e -> testListener());
        randomCheckBox.addActionListener(e -> checkBox());
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    WordByID wordByID;

    private void onOK() {
        if (textField1.isEnabled()) {
           word = Word.findById(Integer.parseInt(textField1.getText()));
        } else {
           word = RandomWord.get();
        }
        textArea1.setText(word.getIID().toString());
    }

    private void checkBox() {
        if (textField1.isEnabled()) {
            textField1.setEnabled(false);
        } else {
            textField1.setEnabled(true);
        }
    }

    private void testListener() {
//        Word word = Word.findById(new Random().nextInt(Word.getMaxID()));
//        System.out.println(word.getInfo());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
