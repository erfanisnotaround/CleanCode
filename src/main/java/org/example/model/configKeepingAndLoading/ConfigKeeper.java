package org.example.model.configKeepingAndLoading;

import org.example.model.Pattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigKeeper {
    private int width;
    private int height;
    private int ThicknessOfSidePanel;
    private int ThicknessOfSquares;
    private int rows;
    private int columns;
    private List<Pattern> patterns;
    private double speed;

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

    public int getThicknessOfSidePanel() {
        return ThicknessOfSidePanel;
    }

    public void setThicknessOfSidePanel(int thicknessOfSidePanel) {
        ThicknessOfSidePanel = thicknessOfSidePanel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}