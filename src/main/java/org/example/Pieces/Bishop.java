package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{

    public Bishop(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Bishop";

        this.sprite = spriteSheet.getSubimage(sheetScale * 4, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);

    }
}
