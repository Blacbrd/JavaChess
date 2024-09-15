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

    // Checks if this is the piece's first move
    boolean isFirstMove;

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

        this.isFirstMove = true;


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

    public String getName(){
        return this.name;
    }

    public void setXPos(int xPos){
        this.xPos = xPos;
    }

    public void setYPos(int yPos){
        this.yPos = yPos;
    }

    public boolean getIsBlack(){
        return isBlack;
    }

    public boolean getIsFirstMove(){
        return this.isFirstMove;
    }

    public void setIsFirstMove(boolean isFirstMove){
        this.isFirstMove = isFirstMove;
    }

    // These two methods are going to be overridden, therefore they are abstract
    // isValidMovement allows the piece to only move in a certain way (to abide by the rules of the game)
    // moveCollidesWithPiece prevents pieces from jumping over other pieces (to abide by the rules of the game)
    public abstract boolean isValidMovement(int column, int row);
    public abstract boolean moveCollidesWithPiece(int column, int row);

    public void paint(Graphics2D graphics2D){

        graphics2D.drawImage(sprite, xPos, yPos, null);

    }

}
