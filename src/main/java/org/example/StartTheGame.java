package org.example;

import javax.swing.SwingUtilities;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;

public class StartTheGame {

    public void start() {
        SwingUtilities.invokeLater(() -> {
            AppFrame frame = new AppFrame();
            frame.setVisible(true);
            Constants.getInstance().setMainFrame(frame);
        });
    }
}
