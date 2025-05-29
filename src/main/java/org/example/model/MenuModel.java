package org.example.model;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.view.AppFrame;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;

public class MenuModel {
    private AppFrame frame;
    private CardLayout cards;
    private JPanel container;
    public MenuModel(AppFrame frame , CardLayout cards , JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
    }
    public void Exit(){
        frame.dispose();
        System.exit(0);
    }
    public void PlayGame(){
        cards.show(container, Screens.GAME.getName());
    }
    public void Setting(){
        cards.show(container , Screens.SETTINGS.getName());
    }
}
