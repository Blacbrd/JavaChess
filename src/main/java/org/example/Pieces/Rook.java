package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Rook extends Piece{

    public Rook(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Rook";

        this.sprite = spriteSheet.getSubimage(sheetScale * 2, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);
    }
}
