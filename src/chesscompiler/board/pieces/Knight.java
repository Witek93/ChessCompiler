package chesscompiler.board.pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Knight extends Piece {

    public Knight(Color color) {
        this.color = color;
        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_nlt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_ndt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String toString() {
        return this.color + " knight";
    }

    @Override
    public Image getImage() {
        return img;
    }

}
