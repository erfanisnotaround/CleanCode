package org.example.controller;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.AppFrame;
import org.example.view.MenuView;

import javax.swing.*;

public class MenuController {
    private final MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        initController();
    }

    private void initController() {
//        view.addNewGameListener(e -> onNewGame());
        view.addLoadGameListener(e -> onLoadGame());
        view.addSettingsListener(e -> onSettings());
        view.addExitListener(e -> onExit());
    }
//
//    private void onNewGame() {
//        view.dispose();
//        SwingUtilities.invokeLater(() -> {
//            MessyTetris gameFrame = new MessyTetris();
//            gameFrame.setVisible(true);
//        });
//    }

    private void onLoadGame() {
        System.out.println("Load Game clicked");
    }

    private void onSettings() {
        System.out.println("Settings clicked");
    }

    private void onExit() {
        AppFrame frame = Constants.getInstance().getMainFrame();
        frame.dispose();
    }
}
