package org.example.view.ui.painters;

import java.awt.*;

public interface BoardPainter {
    void paint(Graphics g,
               boolean[][] board,
               int[] pieceXs, int[] pieceYs,
               int shapeX, int shapeY,
               int cellSize);
}

