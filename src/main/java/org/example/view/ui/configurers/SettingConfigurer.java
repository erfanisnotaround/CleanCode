package org.example.view.ui.configurers;

import org.example.controller.sceneControllers.SettingController;
import org.example.model.appModels.SettingsModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.AppFrame;
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
        SettingView view = new SettingView();
        SettingsModel model = new SettingsModel(cards , container);
        SettingController controller = new SettingController(view , model);
        container.add(view , Screens.SETTINGS.getName());
    }
}
