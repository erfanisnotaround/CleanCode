package org.example.model.configKeepingAndLoading.constantsAndSettingThem;

import org.example.model.configKeepingAndLoading.Patterns;
import org.example.view.AppFrame;

import java.util.ArrayList;

public class Constants {
    private AppFrame MainFrame;
    private int ThicknessOfSquares;
    private int rows;
    private int columns;
    private ArrayList<Patterns> patterns;
    private double speed;
    private Constants() {}
    private static final Constants INSTANCE = new Constants();
    public static Constants getInstance() {
        return INSTANCE;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public ArrayList<Patterns> getPatterns() {
        return patterns;
    }

    public void setPatterns(ArrayList<Patterns> patterns) {
        this.patterns = patterns;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getThicknessOfSquares() {
        return ThicknessOfSquares;
    }

    public void setThicknessOfSquares(int thicknessOfSquares) {
        ThicknessOfSquares = thicknessOfSquares;
    }

    public AppFrame getMainFrame() {
        return MainFrame;
    }

    public void setMainFrame(AppFrame mainFrame) {
        MainFrame = mainFrame;
    }
}
