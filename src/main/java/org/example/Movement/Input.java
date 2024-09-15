package org.example.Movement;

import org.example.ChessBoard;
import org.example.Pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Extending MouseAdapter lets us use only the mouse events that we want, prevents cluttering
public class Input extends MouseAdapter {

    ChessBoard chessBoard;

    public Input(ChessBoard chessBoard){

        this.chessBoard = chessBoard;

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

        // This gets the row and column of where the mouse was clicked, eg (437, 658) would give row 7, column 5
        int column = mouseEvent.getX() / chessBoard.getTileSize();
        int row = mouseEvent.getY() / chessBoard.getTileSize();

        Piece pieceInThisGrid = chessBoard.getPieceInGrid(column, row);

        // If the grid is empty, make the piece you selected move, e.g. moving a pawn to an empty location
        if (pieceInThisGrid == null) {
            return;
        }

        chessBoard.setSelectedPiece(pieceInThisGrid);

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        // Finds the row and column of where the mouse is dragged to
        int column = mouseEvent.getX() / chessBoard.getTileSize();
        int row = mouseEvent.getY() / chessBoard.getTileSize();

        // If there is no chess piece, ignore
        if (chessBoard.getSelectedPiece() == null){
            return;
        }

        // New movement
        Move move = new Move(chessBoard, chessBoard.getSelectedPiece(), column, row);

        // If valid move, make the move, if not, move the chess piece back to its original position
        // To us, it'll look like the chess piece hasn't moved
        if (chessBoard.isValidMove(move)){
            chessBoard.makeMove(move);
        } else  {

            // Moves back to original location
            chessBoard.getSelectedPiece().setXPos(chessBoard.getSelectedPiece().getColumn() * chessBoard.getTileSize());
            chessBoard.getSelectedPiece().setYPos(chessBoard.getSelectedPiece().getRow() * chessBoard.getTileSize());
        }

        // Deselect current chess piece once mouse has been released to allow for selection of different piece
        chessBoard.setSelectedPiece(null);

        // Update the chessboard
        chessBoard.repaint();

    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

        if (chessBoard.getSelectedPiece() == null) {
            return;
        }

        // We take away tile size / 2 since this will centre the chess piece
        chessBoard.getSelectedPiece().setXPos(mouseEvent.getX() - (chessBoard.getTileSize() / 2));
        chessBoard.getSelectedPiece().setYPos(mouseEvent.getY() - (chessBoard.getTileSize() / 2));

        // We need to repaint the board to show the new location of the chess piece
        chessBoard.repaint();

    }



}
