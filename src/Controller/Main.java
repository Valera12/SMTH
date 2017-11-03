package Controller;

import Model.BallModel;
import Model.MapModel;
import Model.PlayerModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Main extends JPanel implements ActionListener {
    private Timer timer = new Timer(20, this);

    private Player player;
    private Player player2;
    private Ball ball;
    private PlayerModel playerModel;
    private BallModel ballModel;
    private MapModel mapModel;

    private JFrame frame;


    public Main(JFrame frame) {
        this.frame = frame;
        player = new Player();
        player.setxCoordinate(150);
        player.setyCoordinate(200);
        player.setSpeed(10);
        player2 = new Player();
        player2.setxCoordinate(1125);
        player2.setyCoordinate(200);
        player2.setSpeed(10);
        ball = new Ball(player, player2);
        ball.setBallX(650);
        ball.setBallY(300);
        timer.start();
        ball.setBallDirection(2);
        playerModel = new PlayerModel(frame, ball, player);
        ballModel = new BallModel(frame, ball, player);
        mapModel = new MapModel(frame);


        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player2.keyReleased(e);
            }
        });

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                ball.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                ball.keyReleased(e);
            }

        });
    }

    public void finishGame() {
        if ((player.firstPlayerScore == 11) || (player2.secondPlayerScore == 11)) {
            frame.dispose();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(mapModel.img, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.drawImage(playerModel.img, player.getxCoordinate(), player.getyCoordinate(), null);
        g.drawImage(playerModel.img2, player2.getxCoordinate(), player2.getyCoordinate(), null);
        g.drawImage(ballModel.img, ball.getBallX(), ball.getBallY(), null);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", 8, 45));
        g.drawString(String.valueOf(player2.secondPlayerScore + " : " + player.firstPlayerScore), 650, 90);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", 8, 45));
        g.drawString(String.valueOf(player.power + ball.ballSpeed), 100, 90);
        g.drawString(String.valueOf(player2.power + ball.ballSpeed), 1000, 90);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move(-1);
        player.stopZone(-1);
        frame.repaint();
        player2.move(-1);
        player2.stopZone(-1);
        ball.ballMove();
        ball.rebound();
        ball.numberOfBallsOutOfTheField();
        ball.ballCentre();
        finishGame();

        repaint();
    }

}