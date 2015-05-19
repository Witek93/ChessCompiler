package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

    public Pawn(Color color) {
        this.color = color;
        
        if(color.equals(Color.WHITE)){
            img = new ImageIcon(".\\resource\\images\\Chess_plt60.png");
        }
        else{
            img = new ImageIcon(".\\resource\\images\\Chess_pdt60.png");
        }
    }
    @Override
    public String toString() {
        return this.color + " pawn";
    }

    @Override
    public ImageIcon getImage() {
        return img;}
}
