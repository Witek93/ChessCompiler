package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Knight extends Piece {

    public Knight(Color color) {
        this.color = color;
        this.moved = false;
        
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
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.add(Coordinates.up(Coordinates.up(Coordinates.left(coordiantes))));
        moves.add(Coordinates.up(Coordinates.up(Coordinates.right(coordiantes))));
        moves.add(Coordinates.down(Coordinates.down(Coordinates.left(coordiantes))));
        moves.add(Coordinates.down(Coordinates.down(Coordinates.right(coordiantes))));
        moves.add(Coordinates.left(Coordinates.left(Coordinates.up(coordiantes))));
        moves.add(Coordinates.left(Coordinates.left(Coordinates.down(coordiantes))));
        moves.add(Coordinates.right(Coordinates.right(Coordinates.up(coordiantes))));
        moves.add(Coordinates.right(Coordinates.right(Coordinates.down(coordiantes))));

        while (moves.contains(null)) {
            moves.remove(null);
        }

        int i = 0;
        while (i < moves.size()) {
            if (board.areAllies(coordiantes, moves.get(i))) {
                moves.remove(i);
            } else {
                i++;
            }
        }

        return moves.toArray(new String[moves.size()]);
    }

}
