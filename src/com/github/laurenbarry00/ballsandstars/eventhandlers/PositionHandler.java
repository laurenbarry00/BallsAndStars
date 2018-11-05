package com.github.laurenbarry00.ballsandstars.eventhandlers;

import com.github.laurenbarry00.ballsandstars.MainGraphics;
import com.github.laurenbarry00.ballsandstars.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PositionHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Shape[] shapes = MainGraphics.getShapesArray();
        for (Shape shape : shapes) {
            shape.randomizePosition();
        }
    }
}
