package org.example.Pieces;

import org.example.ChessBoard;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(ChessBoard chessBoard, int column, int row, boolean isBlack) {

        super(chessBoard, column, row, isBlack);

        this.name = "Pawn";

        this.sprite = spriteSheet.getSubimage(sheetScale * 5, isBlack ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(chessBoard.getTileSize(), chessBoard.getTileSize(), BufferedImage.SCALE_SMOOTH);

    }
}
