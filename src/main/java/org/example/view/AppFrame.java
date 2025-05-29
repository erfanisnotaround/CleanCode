package org.example.view;

import org.example.view.ui.UIManager;

import javax.swing.*;

public class AppFrame extends JFrame {

    public AppFrame() {
        new UIManager().initialize(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
