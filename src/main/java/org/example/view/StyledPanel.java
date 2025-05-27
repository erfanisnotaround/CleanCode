package org.example.view;

import javax.swing.*;
import java.awt.*;

public class StyledPanel extends JPanel {
    public StyledPanel(int rows, int columns, int horizontal, int verticalGap) {
        super(new GridLayout(rows, columns, horizontal, verticalGap));
        setOpaque(false);
    }
}
