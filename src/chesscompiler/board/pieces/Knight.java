package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class Knight extends Piece {

    public Knight(Color color) {
        this.color = color;

        if (color.equals(Color.WHITE)) {
            img = new ImageIcon(".\\resource\\images\\Chess_nlt60.png");
        } else {
            img = new ImageIcon(".\\resource\\images\\Chess_ndt60.png");
        }
    }

    @Override
    public String toString() {
        return this.color + " knight";
    }

    @Override
    public ImageIcon getImage() {
        return img;
    }

}
