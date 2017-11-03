package View;

import Controller.Main;

import javax.swing.*;

public class GameField {

    public static void main(String[] args) {
        JFrame frame = new JFrame("PLAY HARD");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }

}
