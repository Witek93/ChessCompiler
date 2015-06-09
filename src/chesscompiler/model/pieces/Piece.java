package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import java.awt.Image;

public abstract class Piece {

    protected Color color;
    protected Image img;
    protected boolean moved;

    public Color getColor() {
        return color;
    }

    public boolean isBlack() {
        if (color != null) {
            return color.equals(Color.BLACK);
        }
        return false;
    }

    public boolean isWhite() {
        if (color != null) {
            return color.equals(Color.WHITE);
        }
        return false;
    }

    public boolean hasMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    abstract public String[] getDefaultMoves(String coordiantes, ChessBoard board);

    public abstract Image getImage();

    //TODO
    boolean hasMoved(String coordinates) {
        return false;
    }

    public enum Color {

        WHITE {
                    @Override
                    public String toString() {
                        return "white";
                    }
                },
        BLACK {
                    @Override
                    public String toString() {
                        return "black";
                    }
                };

    }
}
