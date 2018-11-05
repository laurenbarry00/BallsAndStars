package com.github.laurenbarry00.ballsandstars;

import com.github.laurenbarry00.ballsandstars.eventhandlers.ColorHandler;
import com.github.laurenbarry00.ballsandstars.eventhandlers.GrowthHandler;
import com.github.laurenbarry00.ballsandstars.eventhandlers.PositionHandler;
import com.github.laurenbarry00.ballsandstars.eventhandlers.SpeedHandler;

import javax.swing.*;
import java.awt.*;

public class OptionsWindow extends JFrame {


    public OptionsWindow() {
        super("Options");
        setBounds(850, 450, 300, 250);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLayout(new FlowLayout());

        createAndAddComponents();
    }

    private void createAndAddComponents() {
        // Modifies the speed of the balls using a slider
        JPanel speedPanel = new JPanel();
        JLabel speedLabel = new JLabel("Speed:");
        JSlider speedSlider = new JSlider();
        speedSlider.setMajorTickSpacing(5);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setMinimum(0);
        speedSlider.setMaximum(30);
        speedSlider.setValue(15); // default speed
        speedSlider.addChangeListener(new SpeedHandler());
        speedPanel.add(speedLabel);
        speedPanel.add(speedSlider);

        JPanel growthPanel = new JPanel();
        JLabel growthLabel = new JLabel("Growth Rate:");
        JSlider growthSlider = new JSlider();
        growthSlider.setMajorTickSpacing(1);
        growthSlider.setMinorTickSpacing(1);
        growthSlider.setPaintLabels(true);
        growthSlider.setPaintTicks(true);
        growthSlider.setMinimum(0);
        growthSlider.setMaximum(10);
        growthSlider.setValue(3);
        growthSlider.addChangeListener(new GrowthHandler());
        growthPanel.add(growthLabel);
        growthPanel.add(growthSlider);

        JPanel colorPanel = new JPanel();
        JButton randomizeColors = new JButton("Randomize Colors");
        randomizeColors.addActionListener(new ColorHandler());
        colorPanel.add(randomizeColors);

        JPanel positionPanel = new JPanel();
        JButton randomizePositions = new JButton("Randomize Positions");
        randomizePositions.addActionListener(new PositionHandler());
        positionPanel.add(randomizePositions);

        this.add(speedPanel);
        this.add(growthPanel);
        this.add(colorPanel);
        this.add(positionPanel);
    }
}
