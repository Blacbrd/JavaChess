package org.example.Movement;

import org.example.ChessBoard;
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

        // The piece we are capturing, uses the getPieceInGrid method to see if there is another piece in that spot
        // If there is another piece, it gets captured
        this.capture = chessBoard.getPieceInGrid(newColumn, newRow);


    }

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public int getNewColumn() {
        return newColumn;
    }

    public int getNewRow(){
        return  newRow;
    }





}
