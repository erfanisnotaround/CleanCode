package org.example.view.ui.painters;


import java.awt.Color;
import java.awt.Graphics;

public class BlockPainter implements BoardPainter {
    @Override
    public void paint(Graphics g,
                      boolean[][] board,
                      int[] pieceXs, int[] pieceYs,
                      int shapeX, int shapeY,
                      int cellSize) {
        if (board != null) {
            g.setColor(Color.GREEN);
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c]) {
                        g.fill3DRect(
                                c*cellSize, r*cellSize,
                                cellSize-1, cellSize-1, true
                        );
                    }
                }
            }
        }
        if (pieceXs != null && pieceYs != null) {
            g.setColor(Color.BLUE);
            for (int i = 0; i < pieceXs.length; i++) {
                int cx = shapeX + pieceXs[i];
                int cy = shapeY + pieceYs[i];
                g.fill3DRect(
                        cx*cellSize, cy*cellSize,
                        cellSize-1, cellSize-1, true
                );
            }
        }
    }
}
