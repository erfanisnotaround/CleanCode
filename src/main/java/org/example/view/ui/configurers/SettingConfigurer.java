package org.example.view.ui.configurers;

import org.example.controller.sceneControllers.SettingController;
import org.example.model.SettingsModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.view.AppFrame;
import org.example.view.settingsView.SettingView;

import javax.swing.*;
import java.awt.*;

public class SettingConfigurer implements ScreenConfigurer{
    @Override
    public Screens getScreen() {
        return Screens.SETTINGS;
    }

    @Override
    public void configure(AppFrame frame, JPanel container, CardLayout cards) {
        SettingView view = new SettingView(9 , 2 , 10 , 20);
        SettingsModel model = new SettingsModel(cards , container);
        SettingController controller = new SettingController(view , model);
        container.add(view , Screens.SETTINGS.getName());
    }
}
