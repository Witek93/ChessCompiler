package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import java.awt.Image;


public abstract class Piece {
    Color color;
    Image img;

    public Color getColor() {
        return color;
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
