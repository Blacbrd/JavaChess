package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(ChessBoard chessBoard, int column, int row, boolean isWhite) {

        super(chessBoard);

        this.column = column;
        this.row = row;

        // This is the position of the Knight chess piece
        // if in 5th row, 6th column, then position is (510, 425)
        this.xPos = column * chessBoard.getTileSize();
        this.yPos = row * chessBoard.getTileSize();

        this.name = "Knight";

        this.isWhite = isWhite;

        // getSubImage(top left x, top left y, size of square x,  size of square y)
        // 3 * sheetScale gives us the 4th image in the sprite sheet, which is the knight
        // Get scaled instance resizes the image
        this.sprite = spriteSheet.getSubimage(sheetScale * 3, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);



    }
}
