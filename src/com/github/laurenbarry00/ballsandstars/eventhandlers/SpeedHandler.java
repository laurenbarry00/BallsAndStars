package com.github.laurenbarry00.ballsandstars.eventhandlers;

import com.github.laurenbarry00.ballsandstars.MainGraphics;
import com.github.laurenbarry00.ballsandstars.Shape;

import javax.swing.*;
import javax.swing.event.*;

public class SpeedHandler implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();

        if (!source.getValueIsAdjusting()) {
            Shape[] shapes = MainGraphics.getShapesArray();
            for (Shape shape : shapes) {
                shape.setSpeed(source.getValue());
            }
        }
    }
}
