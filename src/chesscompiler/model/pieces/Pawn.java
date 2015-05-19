package chesscompiler.model.pieces;

import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
        List<String> moves = new LinkedList<>();
        String front;
        if (this.color.equals(Color.WHITE)) {
            front = Coordinates.up(coordiantes);
            moves.add(front);
            moves.add(Coordinates.up(front));
        } else {
            front = Coordinates.down(coordiantes);
            moves.add(front);
            moves.add(Coordinates.down(front));
        }
        moves.add(Coordinates.left(front));
        moves.add(Coordinates.right(front));
        
        while (moves.contains(null)) {
            moves.remove(null);
        }

        return moves.toArray(new String[moves.size()]);
    }
}
