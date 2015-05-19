package chesscompiler.board.pieces;

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
}
