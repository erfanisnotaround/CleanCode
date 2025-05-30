package org.example.model.appModels;

import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Pattern;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Constants;
import org.example.model.configKeepingAndLoading.constantsAndSettingThem.Screens;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameModel {
    private final int rows, cols;
    private final boolean[][] board;
    private String currentShape;
    private int angle, x, y;
    private int score;
    private final CardLayout cardLayout;
    private final JPanel container;
    private Pattern currentPattern;

    private static final Random RNG = new Random();

    public GameModel(int rows, int cols , CardLayout cardLayout , JPanel container) {
        this.rows = rows;
        this.cols = cols;
        this.board = new boolean[rows][cols];
        this.cardLayout = cardLayout;
        this.container = container;
        reset();
    }

    public void reset() {
        for (boolean[] row : board) Arrays.fill(row, false);
        score = 0;
        spawn();
    }

    public void spawn() {
        x = cols/2 - 2;
        y = 0;
        angle = 0;
        String[] shapes = new String[Constants.getInstance().getPatterns().size()];
        makeShapes(shapes);
        int n = RNG.nextInt(shapes.length);
        currentShape = shapes[n];
        currentPattern = Constants.getInstance().getPatterns().get(n);
    }
    public void makeShapes(String[] shapes) {
        List<Pattern> patterns = Constants.getInstance().getPatterns();
        for (int i = 0; i < patterns.size(); i++) {
            shapes[i] = patterns.get(i).getName();
        }
    }

    public boolean step() {
        if (canMove(x, y+1, angle)) {
            y++;
            return true;
        }
        lockPiece();
        clearLines();
        spawn();
        return false;
    }

    public void moveLeft()  { if (canMove(x-1, y, angle)) x--; }
    public void moveRight() { if (canMove(x+1, y, angle)) x++; }
    public void rotate()    { if (canMove(x, y, (angle+1)%4) && Constants.getInstance().isRotationAccess()) angle=(angle+1)%4; }
    public void rotateCCW() { if (canMove(x, y, (angle+3)%4)) angle=(angle+3)%4; }

    private boolean canMove(int nx, int ny, int na) {
        Pattern pat = currentPattern;
        int[] xs = pat.getPatternX()[na];
        int[] ys = pat.getPatternY()[na];
        for (int i = 0; i < 4; i++) {
            int bx = nx + xs[i];
            int by = ny + ys[i];
            if (bx < 0 || bx >= cols || by < 0 || by >= rows) return false;
            if (board[by][bx]) return false;
        }
        return true;
    }

    private void lockPiece() {
        Pattern pat = currentPattern;
        int[] xs = pat.getPatternX()[angle];
        int[] ys = pat.getPatternY()[angle];
        for (int i = 0; i < 4; i++) {
            int bx = x + xs[i], by = y + ys[i];
            if (by >= 0 && by < rows && bx >= 0 && bx < cols) {
                board[by][bx] = true;
            }
        }
    }

    private void clearLines() {
        int cleared = 0;
        for (int row = rows-1; row >= 0; row--) {
            boolean full = true;
            for (int c = 0; c < cols; c++) {
                if (!board[row][c]) {
                    full = false;
                    break;
                }
            }
            if (full) {
                cleared++;
                for (int r = row; r > 0; r--) {
                    System.arraycopy(board[r-1], 0, board[r], 0, cols);
                }
                Arrays.fill(board[0], false);
                row++; // recheck this row index
            }
        }
        switch (cleared) {
            case 1 -> score += 100;
            case 2 -> score += 300;
            case 3 -> score += 500;
            case 4 -> score += 800;
        }
    }

    public boolean isGameOver() {
        for (int c = 0; c < cols; c++) {
            if (board[0][c]) return true;
        }
        return false;
    }

    public boolean[][] getBoard()        { return board; }
    public int[] getShapeXs()            {
        return currentPattern
                .getPatternX()[angle];
    }
    public int[] getShapeYs()            {
        return currentPattern
                .getPatternY()[angle];
    }
    public void Back(){cardLayout.show(container , Screens.MENU.getName());}
    public int getX()                    { return x; }
    public int getY()                    { return y; }
    public int getAngle()                { return angle; }
    public int getScore()                { return score; }
}
