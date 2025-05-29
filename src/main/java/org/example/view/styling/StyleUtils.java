package org.example.view.styling;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyleUtils {
    public static JButton createStyledButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        b.setForeground(Color.WHITE);
        b.setBackground(new Color(45, 45, 45));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true));
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { b.setBackground(new Color(65, 65, 65)); }
            public void mouseExited(MouseEvent e)  { b.setBackground(new Color(45, 45, 45)); }
        });
        return b;
    }
    public static void applyPanelStyle(JComponent c) {
        c.setOpaque(true);
        c.setBackground(new Color(40, 40, 40));
        c.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    public static JPanel createStyledPanel(int rows, int cols, int hgap, int vgap) {
        JPanel p = new JPanel(new GridLayout(rows,cols,hgap,vgap));
        applyPanelStyle(p);
        return p;
    }
}

