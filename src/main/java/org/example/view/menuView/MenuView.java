package org.example.view.menuView;

import org.example.view.styling.GradientPanel;
import org.example.view.styling.StyleUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
public class MenuView extends JPanel {
    private final JButton loadGameButton  = StyleUtils.createStyledButton("Load Game");
    private final JButton settingsButton  = StyleUtils.createStyledButton("Settings");
    private final JButton exitButton      = StyleUtils.createStyledButton("Exit");

    public MenuView() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, 0, 0, 0));
        GradientPanel main = new GradientPanel(new Color(10, 10, 30) , new Color(40, 0, 60));
        main.setLayout(new BorderLayout(0, 15));
        main.add(createTitle(),   BorderLayout.NORTH);
        main.add(createButtons(), BorderLayout.CENTER);
        add(main , BorderLayout.CENTER);
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("TETRIS", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        return title;
    }

    private JPanel createButtons() {
        JPanel panel = StyleUtils.createStyledPanel(3,1,0,15);
        panel.setOpaque(false);   // if you want it transparent
        panel.add(loadGameButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        return panel;
    }


    public void addLoadGameListener(ActionListener l)  { loadGameButton.addActionListener(l); }
    public void addSettingsListener(ActionListener l)  { settingsButton.addActionListener(l); }
    public void addExitListener(ActionListener l)      { exitButton.addActionListener(l); }
}
