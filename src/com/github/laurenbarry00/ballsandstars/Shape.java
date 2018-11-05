package com.github.laurenbarry00.ballsandstars;

import java.awt.*;

public interface Shape {
    void drawShape(Graphics graphics);

    // Getter and setter methods
    int getSize();
    int getPositionX();
    int getPositionY();
    int getSpeed();
    int getSizeGrowthRate();

    void setSpeed(int speed);
    void setColor(int r, int g, int b);
    void setSizeGrowthRate(int speed);

    void randomizeColor();
    void randomizePosition();
}
