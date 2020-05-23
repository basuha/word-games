package gui.lookandfeel;

import gui.WordGames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WordGamesMain {

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        //Create and set up the window.
        JFrame frame = new JFrame("SwingApplication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WordGames wordGames = new WordGames();
        frame.getContentPane().add(wordGames.getContentPane(), BorderLayout.CENTER);

        //Display the window.
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
