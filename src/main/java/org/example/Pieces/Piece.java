package org.example.Pieces;

import org.example.ChessBoard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Piece {

    // Where the piece is
    int column, row;
    int xPos, yPos;

    // What team it's on, its name, and what value it holds
    boolean isWhite;
    String name;
    int value;

    // Loads in the sprite sheet
    BufferedImage spriteSheet;

    {
        try {

            spriteSheet = ImageIO.read(new File("src/main/java/org/example/Images/ChessPiecesArray.png"));


        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    // The image of the individual chess piece from the sprite sheet
    Image sprite;

    // Divide by 6 so that we can get dimension of each piece
    protected int sheetScale = spriteSheet.getWidth()/6;

    // Allows use of chess board object
    ChessBoard chessBoard;

    public Piece(ChessBoard chessBoard){

        this.chessBoard = chessBoard;

    }

    public void paint(Graphics2D graphics2D){

        graphics2D.drawImage(sprite, xPos, yPos, null);

    }

}
