package chesscompiler.board;

import chesscompiler.board.pieces.NoPiece;
import chesscompiler.board.pieces.Piece;


public class Field {
    private Piece piece;

    public Field() {
        this.piece = new NoPiece();
    }
    
    public Field(Piece piece) {
        this.piece = piece;
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
