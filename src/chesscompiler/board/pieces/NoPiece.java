package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class NoPiece extends Piece {

    public NoPiece() {
        this.img = new ImageIcon(".\\resource\\images\\tlob.png");
    }
   
    @Override
    public String toString() {
        return "no piece";
    }    

    @Override
    public ImageIcon getImage() {
        return img;
    }
}
