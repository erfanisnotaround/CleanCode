package org.example.model.configKeepingAndLoading.constantsAndSettingThem;

import org.example.model.configKeepingAndLoading.ConfigKeeper;
import org.example.model.configKeepingAndLoading.JsonFileLoader;

import java.io.IOException;

public class SendingInfosToConfigs {
    JsonFileLoader loader = new JsonFileLoader();
    Constants constants = Constants.getInstance();
    public void LoadConfig() throws IOException {
        ConfigKeeper configKeeper = loader.LoadConfig();
        constants.setColumns(configKeeper.getColumns());
        constants.setRows(configKeeper.getRows());
        constants.setPatterns(configKeeper.getPatterns());
        constants.setSpeed(configKeeper.getSpeed());
//        constants.setThicknessOfSquares(configKeeper.getThicknessOfSquares());
//        constants.setThicknessOfSidePanel(configKeeper.getThicknessOfSidePanel());
        constants.setHeight(configKeeper.getHeight());
        constants.setWidth(configKeeper.getWidth());
        constants.setRotationAccess(configKeeper.isRotationAccess());
    }
}
