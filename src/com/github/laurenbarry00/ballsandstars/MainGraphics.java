package com.github.laurenbarry00.ballsandstars;

import javax.swing.*;
import java.awt.*;

public class MainGraphics extends JFrame {
    private static final int heightWidth = 800;
    Shape[] shapesArray = new Shape[3];

    public MainGraphics() {
        super("Balls and Stars");
        setBounds(600, 200, heightWidth, heightWidth);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createAndFillShapes();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < shapesArray.length; i++) {
            shapesArray[i].drawShape(g);
        }

        try{
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        repaint();
    }

    public static int getHeightWidth() {
        return heightWidth;
    }

    private void createAndFillShapes() {
        Ball b1 = new Ball();
        Ball b2 = new Ball();
        Ball b3 = new Ball();
        shapesArray[0] = b1;
        shapesArray[1] = b2;
        shapesArray[2] = b3;
    }

    public static void main(String[] args) {
        new MainGraphics();
    }
}
