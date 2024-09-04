package org.example;

import javax.swing.*;
import java.awt.*;

// JPanel follows a flow layout (left to right), kind of like lines on a piece of paper
public class ChessBoard extends JPanel {

    private final int tileSize = 85;

    private final int columns = 8;
    private final int rows = 8;

    public ChessBoard() {

        // Similar to "set size", however we have a layout manager (flow layout, along with minimum size)
        // So, setPreferredSize will give the initial size, while minimum size will only allow the user to make the window that small
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));

    }

    public int getTileSize() {
        return tileSize;
    }

    public void paintComponent(Graphics g){

        // Like turtle in Python, allows us to draw/paint in GUI
        Graphics2D graphics2D = (Graphics2D) g;

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < columns; j++){

                // Alternates, if i + j is even, colour is white, else black
                graphics2D.setColor((i + j) % 2 == 0 ? new Color(17, 0, 255) : new Color(130, 194, 255));

                graphics2D.fillRect(tileSize * j, tileSize * i, tileSize, tileSize);

            }

        }

    }
}
