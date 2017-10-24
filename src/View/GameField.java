package View;

import Controller.Main;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class GameField {

    public static void main(String[] args) {
        JFrame frame = new JFrame("PLAY HARD");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.add(new Main(frame));



        frame.setVisible(true);
    }

}
