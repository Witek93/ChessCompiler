package chesscompiler.model.pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Pawn extends Piece {

    public Pawn(Color color) {
        this.color = color;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_plt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_pdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return this.color + " pawn";
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
