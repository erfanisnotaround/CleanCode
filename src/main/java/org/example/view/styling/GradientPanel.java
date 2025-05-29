package org.example.view.styling;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    Color StartColor;
    Color EndColor;
    public GradientPanel(Color StartColor, Color EndColor) {
        this.StartColor = StartColor;
        this.EndColor = EndColor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(
                0, 0, StartColor,
                0, h, EndColor
        );
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}