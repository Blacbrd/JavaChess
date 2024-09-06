package org.example;

import org.example.Movement.Move;
import org.example.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// JPanel follows a flow layout (left to right), kind of like lines on a piece of paper
public class ChessBoard extends JPanel {

    private final int tileSize = 85;

    private final int columns = 8;
    private final int rows = 8;

    private ArrayList<Piece> pieceArrayList = new ArrayList<>();

    private Piece selectedPiece;

    public ChessBoard() {

        // Similar to "set size", however we have a layout manager (flow layout, along with minimum size)
        // So, setPreferredSize will give the initial size, while minimum size will only allow the user to make the window that small
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));

        addPieces();

    }

    public int getTileSize() {
        return tileSize;
    }

    public Piece getSelectedPiece(){
        return selectedPiece;
    }

    public void setSelectedPiece(Piece piece){
        this.selectedPiece = piece;
    }

    public void addPieces(){

        // I added this myself to prevent rewriting code
        // Initialises all the chess pieces
        boolean tempBoolean;
        int tempWhatSideOfTheBoard = 0;
        int tempWhatSideOfTheBoardPawn = 1;

        for (int j = 0; j < 2; j++) {

            tempBoolean = j == 0;

            if(!tempBoolean){

                tempWhatSideOfTheBoard = 7;
                tempWhatSideOfTheBoardPawn = 6;

            }

            pieceArrayList.add(new Rook(this, 0, tempWhatSideOfTheBoard, tempBoolean));
            pieceArrayList.add(new Rook(this, 7, tempWhatSideOfTheBoard, tempBoolean));

            pieceArrayList.add(new Bishop(this, 1, tempWhatSideOfTheBoard, tempBoolean));
            pieceArrayList.add(new Bishop(this, 6, tempWhatSideOfTheBoard, tempBoolean));

            pieceArrayList.add(new Knight(this, 2, tempWhatSideOfTheBoard, tempBoolean));
            pieceArrayList.add(new Knight(this, 5, tempWhatSideOfTheBoard, tempBoolean));

            pieceArrayList.add(new Queen(this, 3, tempWhatSideOfTheBoard, tempBoolean));
            pieceArrayList.add(new King(this, 4, tempWhatSideOfTheBoard, tempBoolean));

            for (int i = 0; i < 8; i++) {

                pieceArrayList.add(new Pawn(this, i, tempWhatSideOfTheBoardPawn, tempBoolean));

            }
        }

    }

    // Goes through the piece array list to see what piece shares the same row and column as the piece we want
    // Returns piece in that grid, if no piece exists, returns nothing
    public Piece getPieceInGrid(int column, int row){

        for(Piece piece : pieceArrayList){

            if (piece.getRow() == row && piece.getColumn() == column){

                return piece;

            }

        }

        return null;

    }

    // Moves the piece to its new location
    public void makeMove(Move move){

        move.getPiece().setColumn(move.getNewColumn());

        // VIDEO IS AT 12 MINUTES!!!!!!!!!!!!!!!!!!!!

    }

    public boolean isValidMove(Move move){

        return true;

    }

    public void paintComponent(Graphics g){

        // Like turtle in Python, allows us to draw/paint in GUI
        Graphics2D graphics2D = (Graphics2D) g;

        // Draws in a rectangle for each row and column
        for(int i = 0; i < rows; i++){

            for(int j = 0; j < columns; j++){

                // Alternates, if i + j is even, colour is white, else black
                graphics2D.setColor((i + j) % 2 == 0 ? new Color(17, 0, 255) : new Color(130, 194, 255));

                graphics2D.fillRect(tileSize * j, tileSize * i, tileSize, tileSize);

            }

        }

        // For every piece in the piece array, draw it onto the chess board
        for (Piece piece : pieceArrayList){

            piece.paint((graphics2D));

        }

    }
}
