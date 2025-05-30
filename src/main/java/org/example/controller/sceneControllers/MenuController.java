package org.example.controller.sceneControllers;

import org.example.model.appModels.MenuModel;
import org.example.view.menuView.MenuView;

public class MenuController {
    private final MenuView view;
    private final MenuModel model;
    public MenuController(MenuView view , MenuModel model) {
        this.view = view;
        this.model = model;
        initController();
    }

    private void initController() {
        view.addLoadGameListener(e -> onLoadGame());
        view.addSettingsListener(e -> onSettings());
        view.addExitListener(e -> onExit());
    }

    private void onLoadGame() {
        model.PlayGame();
    }

    private void onSettings() {model.Setting();}

    private void onExit() {
        model.Exit();
    }
}
