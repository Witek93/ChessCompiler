package chesscompiler.model.pieces;

import java.awt.Image;


public abstract class Piece {
    Color color;
    Image img;
    
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    abstract public String[] getDefaultMoves(String coordiantes);
    
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
