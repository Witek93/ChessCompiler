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
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String front;
        if (this.color.equals(Color.WHITE)) {
            front = Coordinates.up(coordinates);
            if (!board.isOccupied(front)) {
                moves.add(front);
                String frontfront = Coordinates.up(front);
                if (board.isAtInitialFile(coordinates) && canMoveTwice(board, frontfront)) {
                    moves.add(frontfront);
                }
            }
        } else {
            front = Coordinates.down(coordinates);
            if (!board.isOccupied(front)) {
                moves.add(front);
                String frontfront = Coordinates.down(front);
                if (board.isAtInitialFile(coordinates) && canMoveTwice(board, frontfront)) {
                    moves.add(frontfront);
                }
            }
        }

        String left = Coordinates.left(front);
        if (Coordinates.isValid(left) && board.areEnemies(coordinates, left)) {
            moves.add(left);
        }

        String right = Coordinates.right(front);
        if (Coordinates.isValid(right) && board.areEnemies(coordinates, right)) {
            moves.add(right);
        }

        while (moves.contains(
                null)) {
            moves.remove(null);
        }

        return moves.toArray(
                new String[moves.size()]);
    }

    private boolean canMoveTwice(ChessBoard board, String frontfront) {
        return !board.isOccupied(frontfront);
    }

    @Override
    public String toString() {
        return this.color + " pawn";
    }
}
