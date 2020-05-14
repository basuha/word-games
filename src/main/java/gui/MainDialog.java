package gui;

import utilities.RandomWord;
import utilities.Zodiac;
import words.Word;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.*;
import java.util.Random;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton button1;

    public MainDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        button1.addActionListener(e -> testListener());

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

    private void onOK() {
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
