package org.example.view;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(10, 10, 30),
                0, h, new Color(40, 0, 60)
        );
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}