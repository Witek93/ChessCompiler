package chesscompiler.model;

import chesscompiler.model.pieces.Queen;
import chesscompiler.model.pieces.Piece;
import chesscompiler.model.pieces.Rook;
import chesscompiler.model.pieces.Bishop;
import chesscompiler.model.pieces.Knight;
import chesscompiler.model.pieces.King;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.NoPiece;

public class PiecesCreator {
    
    public Piece create(String name, String colorName) {
        try {
            Piece.Color color = getColor(colorName);

            switch (name.toLowerCase()) {
                case "bishop":
                    return new Bishop(color);
                case "king":
                    return new King(color);
                case "knight": 
                    return new Knight(color);
                case "pawn":
                    return new Pawn(color);
                case "queen":
                    return new Queen(color);
                case "rook":
                    return new Rook(color);
                default: 
                    return new NoPiece();
            }

        } catch (BadPieceColorException e) {
            return new NoPiece();
        }
    }

    private Piece.Color getColor(String name) throws BadPieceColorException {
        switch (name.toLowerCase()) {
            case "white":
                return Piece.Color.WHITE;
            case "black":
                return Piece.Color.BLACK;
            default:
                throw new BadPieceColorException();
        }

    }

    private class BadPieceColorException extends Exception {
    }

}
