package chesscompiler.model.pieces;

import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Rook extends Piece {

    public Rook(Color color) {
        this.color = color;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_rlt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_rdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return this.color + " rook";
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes) {
        List<String> moves = new LinkedList();
        String[] rights = Coordinates.getValidMoves(coordiantes, Coordinates.Direction.RIGHT);
        moves.addAll(Arrays.asList(rights));
        String[] lefts = Coordinates.getValidMoves(coordiantes, Coordinates.Direction.LEFT);
        moves.addAll(Arrays.asList(lefts));
        String[] downs = Coordinates.getValidMoves(coordiantes, Coordinates.Direction.DOWN);
        moves.addAll(Arrays.asList(downs));
        String[] ups = Coordinates.getValidMoves(coordiantes, Coordinates.Direction.UP);
        moves.addAll(Arrays.asList(ups));
        
        String[] movesArray = moves.toArray(new String[moves.size()]);
        return movesArray;
    }
    
    
    
}
