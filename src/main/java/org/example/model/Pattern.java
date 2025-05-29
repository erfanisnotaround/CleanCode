package org.example.model;

public class Pattern {
    private String name;
    private int[][] patternX;
    private int[][] patternY;
    public int[][] getPatternX() {
        return patternX;
    }

    public void setPatternX(int[][] patternX) {
        this.patternX = patternX;
    }

    public int[][] getPatternY() {
        return patternY;
    }

    public void setPatternY(int[][] patternY) {
        this.patternY = patternY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
