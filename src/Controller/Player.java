package Controller;

import java.awt.event.KeyEvent;


public class Player {

    private int xCoordinate;
    private int yCoordinate;
    private int speed;
    public int firstPlayerScore = 0;
    public int secondPlayerScore = 0;
    int power = 0;
    private int frameWidth = 1366;
    private int frameHigh = 768;
    private int safeZoneUp = 675;
    private int SafeZoneDown = 250;
    private int safeZoneCentre = 780;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private static final int FAIL = -1;
    private static final int OK = 4;
    private static final int FINAL_SCORE = 11;


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
                if ((yCoordinate + speed) > (frameHigh - safeZoneUp)) {
                    return OK;
                } else {
                    return FAIL;
                }

            case DOWN:
                if ((yCoordinate - speed) < frameHigh - SafeZoneDown) {
                    return OK;
                } else {
                    return FAIL;
                }
        }

        return FAIL;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((frameWidth - safeZoneCentre) > xCoordinate) {
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