package com.github.laurenbarry00.ballsandstars;

import java.awt.*;
import java.util.Random;

public class Star implements Shape {
    private Color color;
    private int size;
    private int positionX;
    private int positionY;
    private int speedX;
    private int speedY;
    private int sizeGrowthRate;

    private static double rad, pi = 3.14159;
    private static int angle = 90;

    public Star() {
        Random random = new Random(); // Most values are randomly generated to start with
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random RGB color
        positionX = random.nextInt(MainGraphics.getHeightWidth()/5);
        positionY = random.nextInt(MainGraphics.getHeightWidth()/2);
        size = 30;
        speedX = 15;
        speedY = 15;
        sizeGrowthRate = 5;
    }

    public void drawShape(Graphics g) {
        int [] Sx = new int [10];
        int [] Sy = new int [10];
        for(int i = 0; i<10; i++){
            if (i % 2 == 0) {
                rad = size*.38;
            } else {
                rad = size;
            }
            Sx[i] += (int) (rad * Math.cos(pi * angle/180));
            Sy[i] += (int) (rad * Math.sin(pi * angle/180));
            angle += 36;
            Sx[i] += positionX;
            Sy[i] += positionY;
        }
        g.setColor(color);
        positionX+=speedX;
        positionY+=speedY;
        size+=sizeGrowthRate;
        g.fillPolygon(Sx, Sy, 10);

        if (positionX > MainGraphics.getHeightWidth() - size) {
            positionX = MainGraphics.getHeightWidth() - size - 5; // Necessary to keep the shape inside the border but still change directions
            speedX *= -1; // reverse direction
        } else if (positionX < size) {
            positionX = size + 1;
            speedX *= -1;
        } else if (positionY > MainGraphics.getHeightWidth() - size) {
            positionY = MainGraphics.getHeightWidth() - size - 5;
            speedY *= -1;
        } else if (positionY < size) {
            positionY = size + 1;
            speedY *= -1;
        }

        // Preventing shape from getting too small/large
        if (size > 100 || size < 25) {
            sizeGrowthRate *= -1;
        }
    }

    // Getters and Setters
    public int getSize() {
        return size;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public int getSpeed() {
        return speedX;
    }
    public int getSizeGrowthRate() {
        return sizeGrowthRate;
    }

    public void setSizeGrowthRate(int speed) {
        sizeGrowthRate = speed;
    }
    public void setSpeed(int speed) {
        speedX = speed;
        speedY = speed;
    }
    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public void randomizeColor() {
        Random random = new Random();
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void randomizePosition() {
        Random random = new Random();
        positionX = random.nextInt(MainGraphics.getHeightWidth());
        positionY = random.nextInt(MainGraphics.getHeightWidth());
    }
}
