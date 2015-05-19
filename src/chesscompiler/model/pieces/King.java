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

public class King extends Piece {

    public King(Color color) {
        this.color = color;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_klt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_kdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return this.color + " king";
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes) {
        List<String> moves = new LinkedList<>();
        moves.add(Coordinates.up(Coordinates.left(coordiantes)));
        moves.add(Coordinates.up(coordiantes));
        moves.add(Coordinates.up(Coordinates.right(coordiantes)));
        moves.add(Coordinates.right(coordiantes));
        moves.add(Coordinates.down(Coordinates.right(coordiantes)));
        moves.add(Coordinates.down(coordiantes));
        moves.add(Coordinates.down(Coordinates.left(coordiantes)));
        moves.add(Coordinates.left(coordiantes));

        while (moves.contains(null)) {
            moves.remove(null);
        }

        return moves.toArray(new String[moves.size()]);
    }
}
