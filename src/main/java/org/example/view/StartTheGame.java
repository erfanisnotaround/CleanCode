package org.example.view;

import javax.swing.SwingUtilities;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.MenuView;
import org.example.controller.MenuController;

public class StartTheGame {

    public void start() {
        SwingUtilities.invokeLater(() -> {
            AppFrame frame = new AppFrame();
//            MenuController menuController = new MenuController(menuView);
            Constants.getInstance().setMainFrame(frame);
            frame.showMenu();

        });
    }
}
