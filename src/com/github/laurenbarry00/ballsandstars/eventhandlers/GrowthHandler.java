package com.github.laurenbarry00.ballsandstars.eventhandlers;

import com.github.laurenbarry00.ballsandstars.MainGraphics;
import com.github.laurenbarry00.ballsandstars.Shape;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GrowthHandler implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();

        if (!source.getValueIsAdjusting()) {
            Shape[] shapes = MainGraphics.getShapesArray();
            for (Shape shape : shapes) {
                shape.setSizeGrowthRate(source.getValue());
            }
        }
    }
}
