package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Knight";

        // getSubImage(top left x, top left y, size of square x,  size of square y)
        // 3 * sheetScale gives us the 4th image in the sprite sheet, which is the knight
        // Get scaled instance resizes the image
        this.sprite = spriteSheet.getSubimage(sheetScale * 3, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);

    }

    @Override
    public boolean isValidMovement(int column, int row) {

        // The difference between the column being moved to and the current column multiplied by the row being moved to minus the current row
        // A knight can only move in an L shape, 1 then 2 or 2 then 1
        // Therefore, if the difference multiplies to 2 (2 * 1, 1 * 2), then it is a valid move
        return Math.abs(column - this.column) * Math.abs(row - this.row) == 2;
    }

    // This stays like this as the Knight can jump over pieces
    @Override
    public boolean moveCollidesWithPiece(int column, int row) {
        return false;
    }


}
