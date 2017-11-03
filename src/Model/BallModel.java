package Model;

import Controller.Ball;
import Controller.Player;

import javax.swing.*;
import java.awt.*;


public class BallModel {
    JFrame frame;
    Ball ball;
    Player player;
    Player player2;

    public Image img = new ImageIcon("res/ball1.png").getImage();


    public BallModel(JFrame frame, Ball ball, Player player) {
        this.frame = frame;
        this.ball = ball;
        this.player = player;
        this.player2 = player;
    }
}
