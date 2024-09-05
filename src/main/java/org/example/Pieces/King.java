package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.xPos = column * chessBoard.getTileSize();
        this.yPos = row * chessBoard.getTileSize();

        this.name = "King";

        this.sprite = spriteSheet.getSubimage(sheetScale, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }
}
