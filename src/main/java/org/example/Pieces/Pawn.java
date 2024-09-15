package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Pawn";

        this.sprite = spriteSheet.getSubimage(sheetScale * 5, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMovement(int column, int row) {
        // Pawn can only move straight, so the column stays the same

        // If it's a black piece, set to -1, as --1 becomes +1, which allows the pawn to move up a row (downwards) and vise versa
        int colourIndex = isBlack ? -1 : 1;

        // Pawn moves one space
        if (this.column == column && row == this.row - colourIndex && chessBoard.getPieceInGrid(column, row) == null){
            return true;
        }

        // Pawn moves 2 spaces, only valid on the first move. Extra piece in grid condition to account for the possibility of moving one space anyway
        if(isFirstMove && this.column == column && (row == (this.row - colourIndex * 2)) && chessBoard.getPieceInGrid(column, row) == null && chessBoard.getPieceInGrid(column, row + colourIndex) == null){
            return true;
        }

        // Capture left
        if(column == this.column - 1 && row == this.row - colourIndex && chessBoard.getPieceInGrid(column, row) != null){
            return true;
        }

        // Capture right
        if(column == this.column + 1 && row == this.row - colourIndex && chessBoard.getPieceInGrid(column, row) != null){
            return true;
        }


        return false;

    }

    @Override
    public boolean moveCollidesWithPiece(int column, int row) {
        return false;
    }
}
