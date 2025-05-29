package org.example.model.configKeepingAndLoading;

import org.example.model.managers.JsonManager;

import java.io.IOException;

public class JsonFileLoader {
    String path;
    JsonManager jsonManager;
    String configPath = "src/main/resources/configInfo/Info.Json";
    public ConfigKeeper LoadConfig() throws IOException {
        jsonManager = new JsonManager(configPath);
        ConfigKeeper configKeeper = jsonManager.readObject(ConfigKeeper.class);
        return configKeeper;
    }
    public void WriteConfig(ConfigKeeper configKeeper) throws IOException {
        jsonManager = new JsonManager(configPath);
        jsonManager.writeObject(configKeeper);
    }
}
