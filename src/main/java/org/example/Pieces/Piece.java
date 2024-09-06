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
    boolean isBlack;
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

    public Piece(ChessBoard chessBoard, int column, int row, boolean isBlack){

        this.chessBoard = chessBoard;
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;

        // This is the position of the Knight chess piece
        // if in 5th row, 6th column, then position is (510, 425)
        this.xPos = column * chessBoard.getTileSize();
        this.yPos = row * chessBoard.getTileSize();


    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getxPos(){
        return  xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos){
        this.xPos = xPos;
    }

    public void setyPos(int yPos){
        this.yPos = yPos;
    }

    public void paint(Graphics2D graphics2D){

        graphics2D.drawImage(sprite, xPos, yPos, null);

    }

}
