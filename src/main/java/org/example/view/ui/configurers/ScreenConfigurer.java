package org.example.view.ui.configurers;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.AppFrame;

import javax.swing.*;
import java.awt.*;

public interface ScreenConfigurer {
    Screens getScreen();
    void configure(AppFrame frame, JPanel container, CardLayout cards);
}
