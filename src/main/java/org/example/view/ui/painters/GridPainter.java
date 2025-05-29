package org.example.view.ui.painters;

import java.awt.Color;
import java.awt.Graphics;

public class GridPainter implements BoardPainter {
    @Override
    public void paint(Graphics g,
                      boolean[][] board,
                      int[] pieceXs, int[] pieceYs,
                      int shapeX, int shapeY,
                      int cellSize) {
        int width  = g.getClipBounds().width;
        int height = g.getClipBounds().height;

        // background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // grid lines
        g.setColor(Color.DARK_GRAY);
        for (int x = 0; x <= width; x += cellSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y <= height; y += cellSize) {
            g.drawLine(0, y, width, y);
        }
    }
}

