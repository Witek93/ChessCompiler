package chesscompiler.model;

import chesscompiler.model.pieces.NoPiece;
import chesscompiler.model.pieces.Piece;


public class Field {
    private Piece piece;

    public Field() {
        this.piece = new NoPiece();
    }

    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return piece.toString();
    }
   
}
