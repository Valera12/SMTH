package Model;

import Controller.Ball;
import Controller.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerModel {
    JFrame frame;
    Ball ball;
    Player player;
    Player player2;

    public Image img = new ImageIcon("res/playerOne.png").getImage();
    public Image img2 = new ImageIcon("res/playerTwo.png").getImage();


    public PlayerModel(JFrame frame, Ball ball, Player player) {
        this.frame = frame;
        this.ball = ball;
        this.player = player;
        this.player2 = player;
    }

}
