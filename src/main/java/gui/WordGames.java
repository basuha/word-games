package gui;

import gui.lookandfeel.LookAndFeelDemo;
import utilities.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordGames extends JFrame {
    protected JPanel contentPane;
    protected JButton buttonOK;
    protected JButton buttonCancel;
    protected JTabbedPane tabbedPane1;
    protected JPanel settings;
    protected JRadioButton частыеСловаRadioButton;
    protected JRadioButton всеСловаRadioButton;
    protected JRadioButton radioButton3;
    protected JRadioButton radioButton4;
    protected JList list1;
    protected JButton searchButton;
    protected JComboBox attribComboBox1;
    protected JComboBox attribComboBox2;

    public WordGames() {
        setTitle("WordGames alpha");
        setContentPane(contentPane);
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
