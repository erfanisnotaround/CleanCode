package org.example.view;

import javax.swing.*;
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
}

