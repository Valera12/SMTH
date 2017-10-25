package Controller;

import com.sun.javafx.scene.traversal.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    int xCoordinate;
    int yCoordinate;
    int speed;
    int firstPlayerScore = 0;
    int secondPlayerScore = 0;
    int goal = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private static final int FAIL = -1;
    private static final int OK = 4;

    Image img = new ImageIcon("res/playerOne.png").getImage();
    Image img2 = new ImageIcon("res/playerTwo.png").getImage();


    JFrame frame;
    Player player2;
    ;

    Player(JFrame frame, Ball ball) {
        this.frame = frame;

    }


    public void move(int direction) {
        switch (direction) {
            case UP:
                yCoordinate -= speed;
                break;
            case DOWN:
                yCoordinate += speed;
                break;

            default:
                break;
        }
    }


    public int stopZone(int direction) {
        switch (direction) {
            case UP:
                if ((yCoordinate + speed) > (frame.getHeight() - 675)) {
                    return OK;
                } else {
                    return FAIL;
                }

            case DOWN:
                if ((yCoordinate - speed) < frame.getHeight() - 250) {
                    return OK;
                } else {
                    return FAIL;
                }
        }

        return FAIL;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((frame.getWidth() - 780) > xCoordinate) {
            if (key == KeyEvent.VK_W) {
                if (stopZone(UP) == OK) {
                    move(UP);
                } else {
                    move(FAIL);
                }
            }
            if (key == KeyEvent.VK_S) {
                if (stopZone(DOWN) == OK) {
                    move(DOWN);
                } else {
                    move(FAIL);
                }
            }
        } else {
            if (key == KeyEvent.VK_UP) {
                if (stopZone(UP) == OK) {
                    move(UP);
                } else {
                    move(FAIL);
                }
            }
            if (key == KeyEvent.VK_DOWN) {
                if (stopZone(DOWN) == OK) {
                    move(DOWN);
                } else {
                    move(FAIL);
                }
            }
        }
    }


    public void keyReleased(KeyEvent e) {
        move(-1);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}