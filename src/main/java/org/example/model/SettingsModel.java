package org.example.model;

import org.example.model.configKeepingAndLoading.ConfigKeeper;
import org.example.model.configKeepingAndLoading.JsonFileLoader;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.SendingInfosToConfigs;
import org.example.model.managers.JsonManager;
import org.example.view.settingsView.SettingView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingsModel {
    private SendingInfosToConfigs configs = new SendingInfosToConfigs();
    private ConfigKeeper configKeeper = new ConfigKeeper();
    private JsonFileLoader jsonFileLoader = new JsonFileLoader();
    private double Speed = Constants.getInstance().getSpeed();
    private int width = Constants.getInstance().getWidth();
    private int height = Constants.getInstance().getHeight();
    private int cellSize = Constants.getInstance().getThicknessOfSquares();
    private int columns = Constants.getInstance().getColumns();
    private int rows = Constants.getInstance().getRows();
    private int SidePanelWidth = Constants.getInstance().getThicknessOfSidePanel();
    private boolean RotationAccess = Constants.getInstance().isRotationAccess();
    private final CardLayout cards;
    private final JPanel container;
    public SettingsModel(CardLayout cards, JPanel container) {
        this.cards = cards;
        this.container = container;
        initialize();
    }
    public void initialize() {
        configKeeper.setPatterns(Constants.getInstance().getPatterns());
        configKeeper.setWidth(width);
        configKeeper.setHeight(height);
        configKeeper.setThicknessOfSquares(cellSize);
        configKeeper.setRows(rows);
        configKeeper.setColumns(columns);
        configKeeper.setSpeed(Speed);
    }
    public void Save(){

    }
    public void Back() throws IOException {
        cards.show(container, Screens.MENU.getName());
        jsonFileLoader.WriteConfig(configKeeper);
        configs.LoadConfig();
        System.out.println(Constants.getInstance().getThicknessOfSquares());

    }
    public void SetSpeed(String speed){

        try {
            configKeeper.setSpeed(Double.parseDouble(speed));
        }
        catch (Exception e){

        }
    }
    public void SetHeight(String h){
        try {
            configKeeper.setHeight(Integer.parseInt(h));
        }
        catch (Exception e){

        }
    }
    public void SetWidth(String w){
        int newWidth = width;
        try {
            configKeeper.setWidth(Integer.parseInt(w));
        }
        catch (Exception e){

        }
    }
    public void SetCellSize(String cellS){
        try {
            configKeeper.setThicknessOfSquares(Integer.parseInt(cellS));
        }
        catch (Exception e){

        }
    }
    public void SetColumns(String cols){
        try {
            configKeeper.setColumns(Integer.parseInt(cols));
        }
        catch (Exception e){

        }
    }
    public void SetRows(String r){
        try {
            configKeeper.setRows(Integer.parseInt(r));
        }
        catch (Exception e){

        }
    }
    public void SetSidePanelWidth(String sidePanel){
        try {
            configKeeper.setThicknessOfSidePanel(Integer.parseInt(sidePanel));
        }
        catch (Exception e){

        }
    }
}
