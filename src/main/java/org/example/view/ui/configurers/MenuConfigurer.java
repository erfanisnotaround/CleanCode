package org.example.view.ui.configurers;

import org.example.controller.sceneControllers.MenuController;
import org.example.model.MenuModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.view.AppFrame;
import org.example.view.menuView.MenuView;

import javax.swing.*;
import java.awt.*;

public class MenuConfigurer implements ScreenConfigurer {

    @Override
    public Screens getScreen() {
        return Screens.MENU;
    }


    @Override
    public void configure(AppFrame frame, JPanel container, CardLayout cards) {
        MenuView menu = new MenuView();
        MenuModel model = new MenuModel(frame , cards , container);
        MenuController controller = new MenuController(menu , model);
        container.add(menu, Screens.MENU.getName());
    }
}
