package com.github.laurenbarry00.ballsandstars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGraphics extends JFrame implements ActionListener {
    private static final int heightWidth = 800;
    private static Shape[] shapesArray = new Shape[5];

    public MainGraphics() {
        super("Balls and Stars");
        setBounds(600, 200, heightWidth, heightWidth);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Button optionsButton = new Button("Options");
        optionsButton.addActionListener(this);

        this.add(optionsButton);
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

    public static Shape[] getShapesArray() {
        return shapesArray;
    }

    private static void createAndFillShapes() {
        Ball b1 = new Ball();
        Ball b2 = new Ball();
        Ball b3 = new Ball();
        Ball b4 = new Ball();
        Ball b5 = new Ball();
        shapesArray[0] = b1;
        shapesArray[1] = b2;
        shapesArray[2] = b3;
        shapesArray[3] = b4;
        shapesArray[4] = b5;
    }

    public void actionPerformed(ActionEvent e) {
        new OptionsWindow();
    }

    public static void main(String[] args) {
        createAndFillShapes();
        new MainGraphics();
    }
}
