package org.example.view.gameView;

import org.example.view.ui.painters.BoardPainter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameView extends JPanel {
    private boolean[][] board;
    private int[] pieceXs, pieceYs;
    private int shapeX, shapeY;
    private final int cellSize;
    private final List<BoardPainter> painters;

    public GameView(int rows, int cols, int cellSize ,List<BoardPainter> painters) {
        this.cellSize = cellSize;
        this.painters = painters;
        setPreferredSize(new Dimension(cols*cellSize, rows*cellSize));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void render(boolean[][] board,
                       int[] pieceXs, int[] pieceYs,
                       int shapeX, int shapeY,
                       int angle ) {
        this.board   = board;
        this.pieceXs = pieceXs;
        this.pieceYs = pieceYs;
        this.shapeX  = shapeX;
        this.shapeY  = shapeY;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BoardPainter p : painters) {
            p.paint(g, board, pieceXs, pieceYs, shapeX, shapeY, cellSize);
        }
    }
}
