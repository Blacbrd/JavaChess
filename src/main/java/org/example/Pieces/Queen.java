package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Queen extends Piece{

    public Queen(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.xPos = column * chessBoard.getTileSize();
        this.yPos = row * chessBoard.getTileSize();

        this.name = "Queen";

        this.sprite = spriteSheet.getSubimage(0, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }
}
