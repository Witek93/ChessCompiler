package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class Bishop extends Piece {

    public Bishop(Color color) {
        this.color = color;

        if (color.equals(Color.WHITE)) {
            img = new ImageIcon(".\\resource\\images\\Chess_blt60.png");
        } else {
            img = new ImageIcon(".\\resource\\images\\Chess_bdt60.png");
        }
    }

    @Override
    public String toString() {
        return this.color + " bishop";
    }

    @Override
    public ImageIcon getImage() {
        return this.img;
    }

}
