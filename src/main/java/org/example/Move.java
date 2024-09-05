package org.example;

import org.example.Pieces.Piece;

public class Move {

    private int oldColumn;
    private int oldRow;

    private int newColumn;
    private int newRow;

    Piece piece;
    Piece capture;

    public Move(ChessBoard chessBoard, Piece piece, int newColumn, int newRow){

        // Where the piece is travelling to
        this.newColumn = newColumn;
        this.newRow = newRow;

        // Where the piece was originally
        this.oldColumn = piece.getColumn();
        this.oldRow = piece.getRow();

        this.piece = piece;



    }





}
