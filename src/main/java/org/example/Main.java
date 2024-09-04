package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // A JFrame is a container that can contain other visual components
        JFrame frame = new JFrame();

        // Allows to close using x button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets a minimum size for our window, the Dimension class allows us to define (width, height)
        // Cannot reduce window size smaller than these dimensions
        frame.setMinimumSize(new Dimension(1000, 1000));

        // Has the window open in the middle of the screen
        frame.setLocationRelativeTo(null);

        ChessBoard chessBoard = new ChessBoard();

        frame.add(chessBoard);

        frame.setVisible(true);

    }


}