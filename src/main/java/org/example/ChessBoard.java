package org.example;

import javax.swing.*;
import java.awt.*;

// JPanel follows a flow layout (left to right), kind of like lines on a piece of paper
public class ChessBoard extends JPanel {

    private final int tileSize = 85;

    public ChessBoard() {

        int columns = 8;
        int rows = 8;

        // Similar to "set size", however we have a layout manager (flow layout, along with minimum size)
        // So, setPreferredSize will give the initial size, while minimum size will only allow the user to make the window that small
        this.setPreferredSize(new Dimension(columns + tileSize, rows + tileSize));

        this.setBackground(Color.gray);

    }

    public int getTileSize() {
        return tileSize;
    }
}
