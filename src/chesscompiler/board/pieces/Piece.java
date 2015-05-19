package chesscompiler.board.pieces;

import javax.swing.ImageIcon;


public abstract class Piece {
    Color color;
    ImageIcon img;
    
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public abstract ImageIcon getImage();
    
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
