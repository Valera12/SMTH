package Controller;

import com.sun.javafx.scene.traversal.Direction;

import javax.swing.*;
import java.awt.*;
import java.lang.management.PlatformLoggingMXBean;

public class Ball {
    int ballX;
    int ballY;
    int ballSpeed = 6;
    int currentBallDirection;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final int FAIL = -1;
    private static final int OK = 4;


    Player player;
    Player player2;

    Image img = new ImageIcon("res/ball1.png").getImage();

    private JFrame frame;

    Ball(JFrame frame, Player player, Player player2) {
        this.frame = frame;
        this.player = player;
        this.player2 = player2;
    }

    public void ballMove() {
        switch (currentBallDirection) {
            case LEFT:
                ballX -= ballSpeed;
                break;
            case RIGHT:
                ballX += ballSpeed;
                break;

            default:
                break;
        }
    }

    public void rebound() {
        if ((player.getxCoordinate() + 90 > getBallX()) &&
                (player.getyCoordinate() + 50 > getBallY()) &&
                (player.getyCoordinate() - 50 < getBallY())) {
            setBallDirection(RIGHT);
        }
        if ((player2.getxCoordinate() - 90 < getBallX()) &&
                (player2.getyCoordinate() + 50 > getBallY()) &&
                (player2.getyCoordinate() - 50 < getBallY())) {
            setBallDirection(LEFT);
        }
    }


    public void showResult() {
        if (getBallX() <= 90) {
            player.firstPlayerScore = player.firstPlayerScore + 1;
            System.out.println("SCORE OF RIGHT PLAYER: " + player.firstPlayerScore);
        }

        if (getBallX() >= 1155) {
            player2.secondPlayerScore = player2.secondPlayerScore + 1;
            System.out.println("SCORE OF LEFT PLAYER: " + player2.secondPlayerScore);
        }
    }


    public void ballCentre() {
        if ((getBallX() < 90) || (getBallX()) > 1155) {
            setBallX(650);
            setBallY(300);
        }
    }

    public int getBallSpeed() {
        return ballSpeed;
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public int getBallDirection() {
        return currentBallDirection;
    }

    public void setBallDirection(int ballDirection) {
        this.currentBallDirection = ballDirection;
    }
}
