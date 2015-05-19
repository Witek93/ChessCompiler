package chesscompiler.board.pieces;

import javax.swing.ImageIcon;

public class King extends Piece {

    public King(Color color) {
        this.color = color;
        
        if(color.equals(Color.WHITE)){
            img = new ImageIcon(".\\resource\\images\\Chess_klt60.png");
        }
        else{
            img = new ImageIcon(".\\resource\\images\\Chess_kdt60.png");
        }
        
    }
    @Override
    public String toString() {
        return this.color + " king";
    }
    
    @Override
    public ImageIcon getImage() {
        return img;
    }
}
