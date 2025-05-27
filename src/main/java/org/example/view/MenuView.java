package org.example.view;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
public class MenuView extends JPanel {
    private final JButton loadGameButton  = StyleUtils.createStyledButton("Load Game");
    private final JButton settingsButton  = StyleUtils.createStyledButton("Settings");
    private final JButton exitButton      = StyleUtils.createStyledButton("Exit");

    public MenuView() {
//        applyLookAndFeel();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        GradientPanel main = new GradientPanel();
        main.setLayout(new BorderLayout(0, 15));
        main.add(createTitle(),   BorderLayout.NORTH);
        main.add(createButtons(), BorderLayout.CENTER);
        add(main);
    }

    private JLabel createTitle() {
        JLabel title = new JLabel("TETRIS", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        return title;
    }

    private JPanel createButtons() {
        StyledPanel panel = new StyledPanel(3,1,0,15);
        panel.add(loadGameButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        panel.setOpaque(false);
        return panel;
    }

    // Hook methods:
    public void addLoadGameListener(ActionListener l)  { loadGameButton.addActionListener(l); }
    public void addSettingsListener(ActionListener l)  { settingsButton.addActionListener(l); }
    public void addExitListener(ActionListener l)      { exitButton.addActionListener(l); }
}
