package com.github.laurenbarry00.ballsandstars;

import java.awt.*;

public interface Shape {
    void drawShape(Graphics graphics);

    // Getter and setter methods
    int getSize();
    int getPositionX();
    int getPositionY();
    int getSpeedX();
    int getSpeedY();
    int getSizeGrowthRate();
}
