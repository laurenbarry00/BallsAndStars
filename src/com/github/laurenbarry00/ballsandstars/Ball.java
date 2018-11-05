package com.github.laurenbarry00.ballsandstars;

import java.awt.*;
import java.util.Random;

public class Ball implements Shape {
    private Color color;
    private int size;
    private int positionX;
    private int positionY;
    private int speedX;
    private int speedY;
    private int sizeGrowthRate;

    public Ball() {
        Random random = new Random(); // Most values are randomly generated to start with
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random RGB color
        positionX = random.nextInt(MainGraphics.getHeightWidth()/5);
        positionY = random.nextInt(MainGraphics.getHeightWidth()/2);
        size = random.nextInt(50)+40;
        speedX = 15;
        speedY = 15;
        sizeGrowthRate = 5;
    }

    public void drawShape(Graphics g) {
        g.setColor(color);
        positionX += speedX;
        positionY += speedY;
        size += sizeGrowthRate;
        g.fillOval(positionX, positionY, size, size);

        if (positionX > MainGraphics.getHeightWidth() - size) {
            positionX = MainGraphics.getHeightWidth() - size - 5; // Necessary to keep the shape inside the border but still change directions
            speedX *= -1; // reverse direction
        } else if (positionX < 0) {
            speedX *= -1;
        } else if (positionY > MainGraphics.getHeightWidth() - size) {
            positionY = MainGraphics.getHeightWidth() - size - 5;
            speedY *= -1;
        } else if (positionY < 0) {
            speedY *= -1;
        }

        // Preventing shape from getting too small/large
        if (size > 150 || size < 25) {
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
