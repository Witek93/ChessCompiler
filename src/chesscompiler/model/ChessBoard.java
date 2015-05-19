package chesscompiler.model;

import chesscompiler.model.pieces.Piece;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ChessBoard {
    private final Field[][] fields;

    public ChessBoard(int rowsCount, int columnsCount) {
        this.fields = new Field[rowsCount][columnsCount];
        for(int i = 0; i < rowsCount; i++) {
            for(int j = 0; j < columnsCount; j++) {
                this.fields[i][j] = new Field();
            }
        }
    }

    public boolean addPiece(int row, int column, Piece piece) {
        getField(row, column).setPiece(piece);
        return true;
    }
    
    public int getRowsCount() {
        return fields.length;
    }

    public int getColumnsCount() {
        return fields[0].length;
    }
    
    public Image getPieceImage(int row, int column) {
        return getPiece(row, column).getImage();
    }
    
    private Field getField(int row, int column) {
        return fields[row][column];
    }
    
    private Piece getPiece(int row, int column) {
        return getField(row, column).getPiece();
    }
    
    public String fieldToString(int x, int y) {
        return fields[x][y].toString();
    }
    
    
}
