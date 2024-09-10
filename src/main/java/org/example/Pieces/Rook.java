package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Rook extends Piece{

    public Rook(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Rook";

        this.sprite = spriteSheet.getSubimage(sheetScale * 2, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public boolean isValidMovement(int column, int row) {

        // Rook can move across entire row or column
        return this.column == column || this.row == row;
    }

    @Override
    public boolean moveCollidesWithPiece(int column, int row) {

        // Check if we can move to the left
        // If the column we're currently in is greater than the column we're moving to
        // Column decreases therefore moving to the left
        if (this.column > column){

            // Checks every column to the left of current column
            // Minus 1 since we don't count current spot
            for (int c = this.column - 1; c > column; c--){

                // If there is a piece in the way, stop for loop and make it so that the piece can't move any further
                // It checks every column in the same row, (0,1), (1, 1), (2, 1) etc., and as soon as there's a piece, return true
                if (chessBoard.getPieceInGrid(c, this.row) != null){
                    return true;
                }
            }
        }

        // Check if we can move right
        if (this.column < column){

            // Checks every column to the right
            for (int c = this.column + 1; c < column; c++){

                if(chessBoard.getPieceInGrid(c, this.row) != null){
                    return true;
                }
            }
        }

        // Check if we can move up
        if (this.row > row){

            // Checks every row going up
            for (int r = this.row - 1; r > row; r--){

                if(chessBoard.getPieceInGrid(this.column, r) != null){
                    return true;
                }
            }
        }

        // Checks if we can move down
        if (this.row < row){

            // Checks every row going down
            for (int r = this.row + 1; r < row; r++){

                if(chessBoard.getPieceInGrid(this.column, r) != null){
                    return true;
                }
            }
        }

        return false;
    }

}