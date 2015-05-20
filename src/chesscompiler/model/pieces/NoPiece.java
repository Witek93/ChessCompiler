package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import java.awt.Image;

public class NoPiece extends Piece {

    public NoPiece() {
    }

    @Override
    public String toString() {
        return "no piece";
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes, ChessBoard board) {
        return new String[0];
    }
}
