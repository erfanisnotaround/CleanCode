package org.example.model.configKeepingAndLoading.constantsAndSettingThem;

import org.example.AppFrame;

import java.util.List;

public class Constants {
    private boolean RotationAccess;
    private int height;
    private int width;
    private AppFrame MainFrame;
    private int PrefersThicknessOfSidePanel = 100;
    private int ThicknessOfSquares;
    private int rows;
    private int columns;
    private List<Pattern> patterns;
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

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isRotationAccess() {
        return RotationAccess;
    }

    public void setRotationAccess(boolean rotationAccess) {
        RotationAccess = rotationAccess;
    }

    public int getPrefersThicknessOfSidePanel() {
        return PrefersThicknessOfSidePanel;
    }

    public void setPrefersThicknessOfSidePanel(int prefersThicknessOfSidePanel) {
        PrefersThicknessOfSidePanel = prefersThicknessOfSidePanel;
    }
}
