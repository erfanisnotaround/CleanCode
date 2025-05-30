package org.example.controller.sceneControllers;

import org.example.model.appModels.SettingsModel;
import org.example.view.settingsView.SettingView;

import java.io.IOException;

public class SettingController {
    private final SettingView view;
    private final SettingsModel model;

    public SettingController(SettingView view, SettingsModel model) {
        this.view = view;
        this.model = model;
        givingResponsibilityToButtons();
    }

    private void givingResponsibilityToButtons() {
        view.SaveButtonPressed(e -> {
            givingFieldsSave();
            try {
                model.Save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        view.BackButtonPressed(e -> {
            try {
                model.Back();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        view.addSuggestSizeListener(e -> {
            String colsText = view.getColumns().getText();
            String rowsText = view.getRows().getText();

            model.suggestOptimalBoardSize(colsText, rowsText);

            view.getWidthField().setText(String.valueOf(model.getSuggestedWidth()));
            view.getHeightField().setText(String.valueOf(model.getSuggestedHeight()));
        });
    }

    public void givingFieldsSave() {
        model.SetSpeed(view.getSpeed().getText());
        model.SetColumns(view.getColumns().getText());
        model.SetRows(view.getRows().getText());
        model.SetHeight(view.getHeightField().getText());
        model.SetWidth(view.getWidthField().getText());
        model.setRotationAccess(view.getRotationAccess().isSelected());
    }
}