package org.example;

import org.example.Movement.Input;
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

    private Input input = new Input(this);

    public ChessBoard() {

        // Similar to "set size", however we have a layout manager (flow layout, along with minimum size)
        // So, setPreferredSize will give the initial size, while minimum size will only allow the user to make the window that small
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));

        this.addMouseListener(input);
        this.addMouseMotionListener(input);

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

        // *** DID THIS WITHOUT THE TUTORIAL ***
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

        // Updates the pieces x and y position, as well as what grid it is a part of
        move.getPiece().setColumn(move.getNewColumn());
        move.getPiece().setRow(move.getNewRow());
        move.getPiece().setXPos(move.getNewColumn() * tileSize);
        move.getPiece().setYPos(move.getNewRow() * tileSize);

        move.getPiece().setIsFirstMove(false);

        // Remove the piece from the board
        capture(move);


    }

    public void capture(Move move){

        // Removes piece from the list, meaning that it does not exist in the game anymore
        pieceArrayList.remove(move.getCapture());

    }

    public boolean isValidMove(Move move){

        // If on same team, return false as it is not a valid move
        if(sameTeam(move.getPiece(), move.getCapture())){
            return false;
        }

        // If the piece does not make a legal move set out in its class, then it won't move there
        if(!move.getPiece().isValidMovement(move.getNewColumn(), move.getNewRow())){
            return false;
        }

        // If the piece comes into contact with another piece, it cannot move past it
        if(move.getPiece().moveCollidesWithPiece(move.getNewColumn(), move.getNewRow())){
            return false;
        }

        return true;

    }

    public boolean sameTeam(Piece piece1, Piece piece2){

        if(piece1 == null || piece2 == null){
            return false;
        }

        // If both on the same team, return true, as true == true
        return piece1.getIsBlack() == piece2.getIsBlack();

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

        // For every row and column (each grid), and if a piece is selected
        if(selectedPiece != null) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                    if (!isValidMove(new Move(this, selectedPiece, j, i))) {
                        continue;
                    }
                    // If it is a valid move, set the colour of the grid to green, to indicate that you can move there
                    graphics2D.setColor(new Color(0, 255, 81, 173));
                    graphics2D.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
                }

            }
        }

        // For every piece in the piece array, draw it onto the chess board
        for (Piece piece : pieceArrayList){

            piece.paint((graphics2D));

        }

    }
}
