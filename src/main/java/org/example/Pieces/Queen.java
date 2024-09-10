package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Queen extends Piece{

    public Queen(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Queen";

        this.sprite = spriteSheet.getSubimage(0, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public boolean isValidMovement(int column, int row) {

        // Queen is a combination of both the rook and the bishop
        return this.column == column || this.row == row || Math.abs(this.column - column) == Math.abs(this.row - row);
    }

    @Override
    public boolean moveCollidesWithPiece(int column, int row) {

        // If the queen will behave like a rook:
        if (this.column == column || this.row == row){

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

        }
        // Else if moving like a bishop
        else {

            // Top left
            if(this.row > row && this.column > column){

                int c = this.column - 1;
                for(int r = this.row - 1; r > row; r--){
                    if (chessBoard.getPieceInGrid(c, r) != null){
                        return true;
                    }
                    c--;
                }
            }

            // Bottom left
            if(this.row < row && this.column > column){

                int c = this.column - 1;
                for(int r = this.row + 1; r < row; r++){
                    if (chessBoard.getPieceInGrid(c, r) != null){
                        return true;
                    }
                    c--;
                }
            }

            // Top right
            if(this.row > row && this.column < column){

                int r = this.row - 1;
                for(int c = this.column + 1; c < column; c++){
                    if (chessBoard.getPieceInGrid(c, r) != null){
                        return true;
                    }
                    r--;
                }
            }

            // Bottom right
            if(this.row < row && this.column < column){

                int r = this.row + 1;
                for(int c = this.column + 1; c < column; c++){
                    if (chessBoard.getPieceInGrid(c, r) != null){
                        return true;
                    }
                    r++;
                }
            }
        }

        return false;

    }
}
