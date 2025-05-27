package org.example.model.configKeepingAndLoading;

import org.example.model.managers.JsonManager;

import java.io.IOException;

public class JsonFileLoader {
    String path;
    JsonManager jsonManager;
    public ConfigKeeper LoadConfig() throws IOException {
        path = "src/main/resources/configInfo/Info.Json";
        jsonManager = new JsonManager(path);
        ConfigKeeper configKeeper = jsonManager.readObject(ConfigKeeper.class);
        return configKeeper;
    }
}
