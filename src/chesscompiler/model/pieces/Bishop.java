package chesscompiler.model.pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Bishop extends Piece {

    public Bishop(Color color) {
        this.color = color;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_blt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_bdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String toString() {
        return this.color + " bishop";
    }

    @Override
    public Image getImage() {
        return this.img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
