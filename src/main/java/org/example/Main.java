package org.example;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.SendingInfosToConfigs;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SendingInfosToConfigs configs = new SendingInfosToConfigs();
        try {
            configs.LoadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StartTheGame starter = new StartTheGame();
        starter.start();
    }
}