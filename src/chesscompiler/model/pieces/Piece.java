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

    public boolean hasMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        if(!this.moved) {
            System.out.println("This was a first move");
        }
        this.moved = moved;
    }
    
    abstract public String[] getDefaultMoves(String coordiantes, ChessBoard board);
    
    public abstract Image getImage();
    
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
