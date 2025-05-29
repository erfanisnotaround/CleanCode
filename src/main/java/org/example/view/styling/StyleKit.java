package org.example.view.styling;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public final class StyleKit {
    // your color palette – tweak as you like:
    private static final Color PANEL_BG        = new Color(40, 40, 40);
    private static final Color BTN_BG          = new Color(60, 60, 60);
    private static final Color BTN_BG_HOVER    = new Color(80, 80, 80);
    private static final Color BTN_BG_PRESSED  = new Color(100,100,100);
    private static final Color BTN_FG          = Color.WHITE;
    private static final Font  BTN_FONT        = new Font("Segoe UI", Font.BOLD, 14);

    private StyleKit() {}

    public static void applyButton(JButton b , int arc) {
        b.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                AbstractButton btn = (AbstractButton)c;
                ButtonModel buttonModel = btn.getModel();
                Color backGroundColor = BTN_BG;
                if (buttonModel.isArmed() && buttonModel.isPressed())      backGroundColor = BTN_BG_PRESSED;
                else if (buttonModel.isRollover())               backGroundColor = BTN_BG_HOVER;
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(backGroundColor);
                g2.fillRoundRect(0,0,c.getWidth(), c.getHeight(), arc, arc);
                g2.dispose();
                super.paint(g, c);
            }
        });

        b.setContentAreaFilled(false);
        b.setBorder(new EmptyBorder(8, 16, 8, 16));
        b.setFont(BTN_FONT);
        b.setForeground(BTN_FG);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFocusPainted(false);
        b.setRolloverEnabled(true);  // so we get the hover state
    }

    public static void applyPanel(JPanel p) {
        p.setBackground(PANEL_BG);
        p.setOpaque(true);
        p.setBorder(new EmptyBorder(10,10,10,10));
    }

    public static void applyLabel(JLabel l, float size, boolean bold, Color fg) {
        int style = bold ? Font.BOLD : Font.PLAIN;
        l.setFont(l.getFont().deriveFont(style, size));
        l.setForeground(fg);
    }
}
