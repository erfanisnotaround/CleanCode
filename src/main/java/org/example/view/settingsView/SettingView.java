package org.example.view.settingsView;

import org.example.model.configKeepingAndLoading.UpdaterTextField;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.styling.StyleUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingView extends JPanel {
    private final JComboBox<String> resolutionCombo = new JComboBox<>();
    private final UpdaterTextField Speed = new UpdaterTextField();
    private final UpdaterTextField Columns = new UpdaterTextField();
    private final UpdaterTextField Rows = new UpdaterTextField();
    private final UpdaterTextField Height = new UpdaterTextField();
    private final UpdaterTextField Width = new UpdaterTextField();
    private final JCheckBox RotationAccess = new JCheckBox();
    private final JButton BackButton = StyleUtils.createStyledButton("Back");
    private final JButton Save = StyleUtils.createStyledButton("Save");
    // 🔽 --- ADD THIS NEW BUTTON ---
    private final JButton suggestSizeButton = StyleUtils.createStyledButton("Suggest Size");

    public SettingView() { // Constructor no longer needs arguments
        // Use a more flexible layout manager like BoxLayout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Add padding
        SetInitialValues();
        addingProperties();
    }

    public void SetInitialValues() {
        Constants constants = Constants.getInstance();
        Speed.setText(String.valueOf(constants.getSpeed()));
        Columns.setText(String.valueOf(constants.getColumns()));
        Rows.setText(String.valueOf(constants.getRows()));
        Height.setText(String.valueOf(constants.getHeight()));
        Width.setText(String.valueOf(constants.getWidth()));
        RotationAccess.setSelected(constants.isRotationAccess());
    }

    // 🔄 --- REPLACE a`ddingProperties` METHOD WITH THIS ---
    public void addingProperties() {
        addLabeled("Speed (ms)", Speed);
        addLabeled("Columns", Columns);
        addLabeled("Rows", Rows);
        addLabeled("Enable Rotation", RotationAccess);

        // Create a dedicated panel for board dimensions
        JPanel dimensionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dimensionPanel.setBorder(BorderFactory.createTitledBorder("Board Dimensions"));

        // Set preferred size for text fields to keep them neat
        Width.setColumns(5);
        Height.setColumns(5);

        dimensionPanel.add(new JLabel("Width:"));
        dimensionPanel.add(Width);
        dimensionPanel.add(new JLabel("Height:"));
        dimensionPanel.add(Height);
        dimensionPanel.add(suggestSizeButton); // Add the new button here
        add(dimensionPanel);

        // Panel for Back and Save buttons
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        controlPanel.add(BackButton);
        controlPanel.add(Save);
        add(controlPanel);
    }

    private void addLabeled(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.setMaximumSize(new Dimension(300, 40)); // Constrain size for alignment
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        if (field instanceof JCheckBox) {
            // Adjust layout for checkboxes to look better
            JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            checkBoxPanel.add(field);
            panel.add(checkBoxPanel, BorderLayout.CENTER);
        } else {
            panel.add(field, BorderLayout.CENTER);
        }
        add(panel);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
    }

    public UpdaterTextField getSpeed() { return Speed; }
    public UpdaterTextField getColumns() { return Columns; }
    public UpdaterTextField getRows() { return Rows; }
    public UpdaterTextField getHeightField() { return Height; }
    public UpdaterTextField getWidthField() { return Width; }
    public JCheckBox getRotationAccess() { return RotationAccess; }

    public void BackButtonPressed(ActionListener listener) { BackButton.addActionListener(listener); }
    public void SaveButtonPressed(ActionListener listener) { Save.addActionListener(listener); }

    // 🔽 --- ADD THIS METHOD ---
    public void addSuggestSizeListener(ActionListener listener) {
        suggestSizeButton.addActionListener(listener);
    }
}