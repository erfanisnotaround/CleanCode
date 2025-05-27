package org.example.model.configKeepingAndLoading;

import java.util.ArrayList;

public class ConfigKeeper {
    private int ThicknessOfSquares;
    private int rows;
    private int columns;
    private ArrayList<Patterns> patterns;
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
}