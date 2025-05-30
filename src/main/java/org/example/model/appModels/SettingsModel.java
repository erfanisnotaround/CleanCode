package org.example.model.appModels;

import org.example.model.configKeepingAndLoading.ConfigKeeper;
import org.example.model.configKeepingAndLoading.JsonFileLoader;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.SendingInfosToConfigs;
import org.example.StartTheGame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingsModel {
    private final SendingInfosToConfigs configs = new SendingInfosToConfigs();
    private final ConfigKeeper configKeeper = new ConfigKeeper();
    private final JsonFileLoader jsonFileLoader = new JsonFileLoader();
    // ... existing fields
    private final CardLayout cards;
    private final JPanel container;

    // 🔽 --- ADD THESE FIELDS ---
    private int suggestedWidth;
    private int suggestedHeight;

    public SettingsModel(CardLayout cards, JPanel container) {
        this.cards = cards;
        this.container = container;
        initialize();
    }

    public void initialize() {
        Constants constants = Constants.getInstance();
        configKeeper.setPatterns(constants.getPatterns());
        configKeeper.setWidth(constants.getWidth());
        configKeeper.setHeight(constants.getHeight());
        configKeeper.setRows(constants.getRows());
        configKeeper.setColumns(constants.getColumns());
        configKeeper.setSpeed(constants.getSpeed());
        configKeeper.setRotationAccess(constants.isRotationAccess());
    }

    // 🔽 --- ADD THIS ENTIRE METHOD ---
    public void suggestOptimalBoardSize(String colsStr, String rowsStr) {
        try {
            int cols = Integer.parseInt(colsStr);
            int rows = Integer.parseInt(rowsStr);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            double safeAreaPercentage = 0.85;
            int availableWidth = (int) (screenWidth * safeAreaPercentage);
            int availableHeight = (int) (screenHeight * safeAreaPercentage);

//            int blockSizeByWidth = availableWidth / cols;
            int blockSizeByHeight = availableHeight / rows;

            int optimalBlockSize = blockSizeByHeight;

            this.suggestedWidth = cols * optimalBlockSize + Constants.getInstance().getPrefersThicknessOfSidePanel();
            this.suggestedHeight = rows * optimalBlockSize;



        } catch (NumberFormatException e) {
            System.err.println("Invalid input for columns or rows. Using default dimensions.");
            this.suggestedWidth = Constants.getInstance().getWidth();
            this.suggestedHeight = Constants.getInstance().getHeight();
        }
    }

    public int getSuggestedWidth() {
        return suggestedWidth;
    }

    public int getSuggestedHeight() {
        return suggestedHeight;
    }

    public void Save() throws IOException {
        jsonFileLoader.WriteConfig(configKeeper);
        new SendingInfosToConfigs().LoadConfig();
        StartTheGame startTheGame = new StartTheGame();
        Constants.getInstance().getMainFrame().dispose();
        startTheGame.start();
    }

    public void Back() throws IOException {
        cards.show(container, Screens.MENU.getName());
    }

    // ... rest of your Setters remain the same
    public void SetSpeed(String speed) {
        try {
            configKeeper.setSpeed(Double.parseDouble(speed));
        } catch (Exception e) {
            System.out.println("Speed error: Invalid format.");
        }
    }
    public void SetHeight(String h) {
        try {
            configKeeper.setHeight(Integer.parseInt(h));
        } catch (Exception e) {
            System.out.println("Height error: Invalid format.");
        }
    }
    public void SetWidth(String w) {
        try {
            configKeeper.setWidth(Integer.parseInt(w));
        } catch (Exception e) {
            System.out.println("Width error: Invalid format.");
        }
    }
    public void SetColumns(String cols) {
        try {
            configKeeper.setColumns(Integer.parseInt(cols));
        } catch (Exception e) {
            System.out.println("Columns error: Invalid format.");
        }
    }
    public void SetRows(String r) {
        try {
            configKeeper.setRows(Integer.parseInt(r));
        } catch (Exception e) {
            System.out.println("Rows error: Invalid format.");
        }
    }
    public void setRotationAccess(boolean r) {
        configKeeper.setRotationAccess(r);
    }
}