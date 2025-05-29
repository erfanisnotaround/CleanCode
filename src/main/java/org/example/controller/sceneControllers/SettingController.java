package org.example.controller.sceneControllers;

import org.example.model.SettingsModel;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.settingsView.SettingView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;

public class SettingController {
    private final SettingView view;
    private final SettingsModel model;
    public SettingController(SettingView view, SettingsModel model) {
        this.view = view;
        this.model = model;
        givingResponsibilityToButtons();
        AddingConsumerListeners();
    }
    public void givingResponsibilityToButtons(){
        view.SaveButtonPressed(e -> model.Save());
        view.BackButtonPressed(e -> {
            try {
                model.Back();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public void AddingConsumerListeners(){
        view.getColumns().setOnTextChanged(txt -> {
            view.getColumns().setText(txt);
            model.SetColumns(txt);
        });
        view.getRows().setOnTextChanged(txt -> {
            view.getRows().setText(txt);
            model.SetRows(txt);
        });
        view.getSpeed().setOnTextChanged(txt -> {
            view.getSpeed().setText(txt);
            model.SetSpeed(txt);
        });
        view.getCellSize().setOnTextChanged(txt -> {
            view.getCellSize().setText(txt);
            model.SetCellSize(txt);
        });
        view.getHeightField().setOnTextChanged(txt -> {
            view.getHeightField().setText(txt);
            model.SetHeight(txt);
        });
        view.getWidthField().setOnTextChanged(txt -> {
            view.getWidthField().setText(txt);
            model.SetWidth(txt);
        });
        view.getSidePanelWidth().setOnTextChanged(txt -> {
            view.getSidePanelWidth().setText(txt);
            model.SetSidePanelWidth(txt);
        });
//        view.getRotationAccess();
    }
}

