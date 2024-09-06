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
}
