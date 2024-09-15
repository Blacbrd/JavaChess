package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "King";

        this.sprite = spriteSheet.getSubimage(sheetScale, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public boolean isValidMovement(int column, int row) {
        // If both are 1 (diagonal), or if one is 1 and the other is 0 (to the side or straight up)
        return Math.abs(column - this.column) * Math.abs(row - this.row) == 1 || Math.abs(column - this.column) + Math.abs(row - this.row) == 1;
    }

    @Override
    public boolean moveCollidesWithPiece(int column, int row) {
        return false;
    }
}
