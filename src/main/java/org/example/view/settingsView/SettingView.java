package org.example.view.settingsView;

import org.example.model.UpdaterTextField;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.view.styling.StyleUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.event.DocumentListener;

public class SettingView extends JPanel {
    private  final UpdaterTextField Speed = new UpdaterTextField();
    private  final UpdaterTextField Columns = new UpdaterTextField();
    private  final UpdaterTextField Rows = new UpdaterTextField();
    private  final UpdaterTextField CellSize = new UpdaterTextField();
    private  final UpdaterTextField Height = new UpdaterTextField();
    private  final UpdaterTextField Width = new UpdaterTextField();
    private  final UpdaterTextField SidePanelWidth = new UpdaterTextField();
    private  final JCheckBox RotationAccess  = new JCheckBox() ;
    private  final JButton BackButton = StyleUtils.createStyledButton("Back");
    private  final JButton Save   = StyleUtils.createStyledButton("Save");
    public SettingView(int rows, int cols , int HorizontalGap, int VerticalGap) {
        setLayout(new GridLayout(rows , cols , HorizontalGap , VerticalGap));
        SetInitialValues();
        addingProperties();

    }
    public void SetInitialValues() {
        Constants constants = Constants.getInstance();
        Speed.setText(String.valueOf(constants.getSpeed()));
        Columns.setText(String.valueOf(constants.getColumns()));
        Rows.setText(String.valueOf(constants.getRows()));
        CellSize.setText(String.valueOf(constants.getThicknessOfSquares()));
        Height.setText(String.valueOf(constants.getHeight()));
        Width.setText(String.valueOf(constants.getWidth()));
        SidePanelWidth.setText(String.valueOf(constants.getThicknessOfSidePanel()));
        RotationAccess.setSelected(constants.isRotationAccess());
    }
    public void addingProperties(){
        addLabeled("Speed (ms)", Speed);
        addLabeled("Columns", Columns);
        addLabeled("Rows", Rows);
        addLabeled("Cell Size", CellSize);
        addLabeled("Board Height", Height);
        addLabeled("Board Width", Width);
        addLabeled("Side Panel Width", SidePanelWidth);
        addLabeled("Rotation",RotationAccess);
        add(BackButton);
        add(Save);
    }
    private void addLabeled(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5,0));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        add(panel);
    }
    public UpdaterTextField getSpeed() {return Speed;}
    public UpdaterTextField getColumns() {return Columns;}
    public UpdaterTextField getRows() {return Rows;}
    public UpdaterTextField getCellSize() {return CellSize;}
    public UpdaterTextField getHeightField(){return Height;}
    public UpdaterTextField getWidthField(){return Width;}
    public UpdaterTextField getSidePanelWidth() {return SidePanelWidth;}
    public JCheckBox getRotationAccess() {return RotationAccess;}

    public void BackButtonPressed(ActionListener listener ){BackButton.addActionListener(listener);}
    public void SaveButtonPressed(ActionListener listener ){Save.addActionListener(listener);}
}
