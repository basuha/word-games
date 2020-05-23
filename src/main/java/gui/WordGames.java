package gui;

import utilities.Word;

import javax.swing.*;
import java.awt.event.*;

public class WordGames extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JPanel settings;
    private JRadioButton частыеСловаRadioButton;
    private JRadioButton всеСловаRadioButton;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JList list1;
    private JButton searchButton;
    private JComboBox attribComboBox1;
    private JComboBox attribComboBox2;

    public WordGames() {
        setTitle("WordGames alpha");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        Word.findById(1); //инициализация хибернейта

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSearch();
            }
        });

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        });
//
//        buttonCancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onSearch() {
        WordSearch wordSearch = new WordSearch();
        wordSearch.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        WordGames dialog = new WordGames();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
