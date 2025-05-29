package org.example.view.ui;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.view.AppFrame;
import org.example.view.ui.configurers.GameConfigurer;
import org.example.view.ui.configurers.MenuConfigurer;
import org.example.view.ui.configurers.ScreenConfigurer;
import org.example.view.ui.configurers.SettingConfigurer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UIManager {
    private final List<ScreenConfigurer> screenConfigurers;

    public UIManager(ScreenConfigurer... configurers) {
        this.screenConfigurers = List.of(configurers);
    }
    public UIManager() {
        this(
                new MenuConfigurer(),
                new GameConfigurer(),
                new SettingConfigurer()
        );
    }

    public void initialize(AppFrame frame) {
        frame.setTitle("Tetris");
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int w = org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants
                .getInstance().getColumns()
                * org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants
                .getInstance().getThicknessOfSquares()
                +Constants.getInstance().getThicknessOfSidePanel();
        int h = org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants
                .getInstance().getRows()
                * org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants
                .getInstance().getThicknessOfSquares();
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);
        Constants.getInstance().setMainFrame(frame);
        CardLayout cards = new CardLayout();
        JPanel container = new JPanel(cards);

        for (ScreenConfigurer cfg : screenConfigurers) {
            cfg.configure(frame, container, cards);
        }

        frame.setContentPane(container);
        Constants.getInstance().setMainFrame(frame);
        cards.show(container, Screens.MENU.getName());
    }
}
