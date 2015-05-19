package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class Queen extends Piece {

    public Queen(Color color) {
        this.color = color;
        
        if(color.equals(Color.WHITE)){
            img = new ImageIcon(".\\resource\\images\\Chess_qlt60.png");
        }
        else{
            img = new ImageIcon(".\\resource\\images\\Chess_qdt60.png");
        }
    }
    @Override
    public String toString() {
        return this.color + " queen";
    }

    @Override
    public ImageIcon getImage() {
        return img;
    }
}
