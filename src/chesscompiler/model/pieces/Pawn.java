package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Pawn extends Piece {

    public Pawn(Color color) {
        this.color = color;
        this.moved = false;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_plt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_pdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Image getImage() {
        return img;
    }

    //TODO 
    public boolean hasMoved(String from, String to){
        return true;
    }
    
    @Override
    public String[] getDefaultMoves(String coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String front;
        if (this.color.equals(Color.WHITE)) {
            front = Coordinates.up(coordinates);
            if (front!= null && !board.isOccupied(front)) {
                moves.add(front);
                String frontfront = Coordinates.up(front);
                if (board.isAtInitialFile(coordinates) && canMoveTwice(board, frontfront)) {
                    moves.add(frontfront);
                }
            }
        } else {
            front = Coordinates.down(coordinates);
            if (front != null && !board.isOccupied(front)) {
                moves.add(front);
                String frontfront = Coordinates.down(front);
                if (board.isAtInitialFile(coordinates) && canMoveTwice(board, frontfront)) {
                    moves.add(frontfront);
                }
            }
        }

        String left = Coordinates.left(front);
        if (Coordinates.isValid(left) && board.areEnemies(coordinates, left)) {
            moves.add(left);
        }

        String right = Coordinates.right(front);
        if (Coordinates.isValid(right) && board.areEnemies(coordinates, right)) {
            moves.add(right);
        }

        while (moves.contains(
                null)) {
            moves.remove(null);
        }

        return moves.toArray(
                new String[moves.size()]);
    }

    private boolean canMoveTwice(ChessBoard board, String frontfront) {
        return !board.isOccupied(frontfront);
    }
    //TODO funkcja z bezposrednio sprawdzajaca czy ruch byl pierwszym ruchem :< i cy zaden inny pionek sie nie ruszal
    public boolean isEnPassantBlack(ChessBoard board, String frontfront) {
            for (int j = 0; j < board.getColumnsCount(); j++) {
                if (board.areEnemies(Coordinates.create(3, j+1), Coordinates.create(3, j))) {
                    Piece pieceBlack = board.getPiece(3, j+1);
                    Piece pieceWhite = board.getPiece(3, j);
                //    if (((pieceBlack instanceof Pawn) && pieceBlack.hasMoved()) && 
                  //     (pieceWhite instanceof Pawn) && pieceWhite.hasMoved(Coordinates.create(1, j), Coordinates.create(3, j))){
                        return true; 
                  //  }
                }
            }
        return false;
    }
    
    public boolean isEnPassantWhite(ChessBoard board, String frontfront) {
        for (int j = 0; j < board.getColumnsCount(); j++) {
            if (board.areEnemies(Coordinates.create(4, j+1), Coordinates.create(4, j))) {
                Piece pieceWhite = board.getPiece(4, j+1);
                Piece pieceBlack = board.getPiece(4, j);
                //if (((pieceWhite instanceof Pawn) && !pieceWhite.hasMoved()) && pieceBlack.hasMoved(Coordinates.create(7, j), Coordinates.create(4, j))){
                    return true;    
                //}
            }
        }
        return false;
    }

}
