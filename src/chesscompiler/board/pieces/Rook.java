package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class Rook extends Piece {

    public Rook(Color color) {
        this.color = color;
        
        if(color.equals(Color.WHITE)){
            img = new ImageIcon(".\\resource\\images\\Chess_rlt60.png");
        }
        else{
            img = new ImageIcon(".\\resource\\images\\Chess_rdt60.png");
        }
    }
    @Override
    public String toString() {
        return this.color + " rook";
    }

    @Override
    public ImageIcon getImage() {
        return img;
    }
}
