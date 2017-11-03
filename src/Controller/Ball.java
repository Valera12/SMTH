package Controller;

import java.awt.event.KeyEvent;

public class Ball {
    private int ballX;
    private int ballY;
    int ballSpeed = 6;
    private static final int STEP = 5;
    private static final int SCORE_STEP = 1;
    private static final int DEFAULT_SPEED = 1;
    private static final int DEFAULT_POWER = 1;
    private static final int X_ZONE = 80;
    private static final int Y_ZONE = 40;
    private static final int BORDER_LEFT = 90;
    private static final int BORDER_RIGHT = 1125;
    private int currentBallDirection;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final int FAIL = -1;
    private static final int OK = 4;


    private Player player;
    private Player player2;


    Ball(Player player, Player player2) {
        this.player = player;
        this.player2 = player2;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_E) {
            player.power = player.power + STEP;
        }
        if (key == KeyEvent.VK_Q) {
            player.power = player.power - STEP;
        }
        if (key == KeyEvent.VK_RIGHT) {
            player2.power = player2.power + STEP;
        }
        if (key == KeyEvent.VK_LEFT) {
            player2.power = player2.power - STEP;
        }
    }

    public void keyReleased(KeyEvent e) {

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
        if ((player.getxCoordinate() + X_ZONE > getBallX()) &&
                (player.getyCoordinate() + Y_ZONE > getBallY()) &&
                (player.getyCoordinate() - Y_ZONE < getBallY())) {
            setBallDirection(RIGHT);
            if (player.power < 0 && ballSpeed + player.power <= 0)
                ballSpeed = 1;
            else
                ballSpeed = ballSpeed + player.power;
            player.power = 0;
        }
        if ((player2.getxCoordinate() - X_ZONE < getBallX()) &&
                (player2.getyCoordinate() + Y_ZONE > getBallY()) &&
                (player2.getyCoordinate() - Y_ZONE < getBallY())) {
            setBallDirection(LEFT);
            if (player2.power < 0 && ballSpeed + player2.power <= 0)
                ballSpeed = 1;
            else
                ballSpeed = ballSpeed + player2.power;

            player2.power = 0;
        }
    }


    public void numberOfBallsOutOfTheField() {
        if (getBallX() <= BORDER_LEFT) {
            player.firstPlayerScore = player.firstPlayerScore + SCORE_STEP;
            System.out.println("SCORE OF RIGHT PLAYER: " + player.firstPlayerScore);
        }

        if (getBallX() >= BORDER_RIGHT) {
            player2.secondPlayerScore = player2.secondPlayerScore + SCORE_STEP;
            System.out.println("SCORE OF LEFT PLAYER: " + player2.secondPlayerScore);
        }
    }


    public void ballCentre() {
        if ((getBallX() < BORDER_LEFT) || (getBallX()) > BORDER_RIGHT) {
            setBallX(650);
            setBallY(300);
        }
    }


    public double getBallSpeed() {
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
