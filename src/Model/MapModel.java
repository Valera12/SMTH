package Model;

import javax.swing.*;
import java.awt.*;


public class MapModel {
    JFrame frame;

    public Image img = new ImageIcon("res/stol.png").getImage();

    public MapModel(JFrame frame) {
        this.frame = frame;
    }
}
