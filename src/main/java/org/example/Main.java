package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // A JFrame is a container that can contain other visual components
        JFrame frame = new JFrame();

        // Allows to close using x button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adds title to the window
        frame.setTitle("Java Chess");

        // This layout allows us full control of where we put our GUI elements as each grid can be a different size
        frame.setLayout(new GridBagLayout());

        // Initialise chessBoard class
        ChessBoard chessBoard = new ChessBoard();

        frame.setBackground(Color.black);

        // Sets a minimum size for our window, the Dimension class allows us to define (width, height)
        // Cannot reduce window size smaller than these dimensions
        frame.setMinimumSize(new Dimension(1200, 1200));

        // Has the window open in the middle of the screen
        frame.setLocationRelativeTo(null);

        frame.add(chessBoard);

        frame.setVisible(true);

    }


}