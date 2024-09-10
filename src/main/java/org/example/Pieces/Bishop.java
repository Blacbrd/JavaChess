package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{

    public Bishop(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Bishop";

        this.sprite = spriteSheet.getSubimage(sheetScale * 4, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMovement(int column, int row) {

        // Checks for diagonals
        // If column moves up by one, then row has to move up or down by one and so on
        // If their difference is equal
        return Math.abs(this.column - column) == Math.abs(this.row - row);
    }

    @Override
    public boolean moveCollidesWithPiece(int column, int row) {

        // *** DID THIS WITHOUT THE TUTORIAL!! ***

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


        return false;
    }
}
