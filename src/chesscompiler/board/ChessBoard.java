package chesscompiler.board;

import chesscompiler.board.pieces.Piece;

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

    public boolean addPiece(ChessCoordinates coordinates, Piece piece) {
        Field field = getField(coordinates);
        if(field.getPiece() != null) {
            return false;
        } else {
            field.setPiece(piece);
            return true;
        }
    }
    
    public int getRowsCount() {
        return fields.length;
    }

    public int getColumnsCount() {
        return fields[0].length;
    }
    
    private Field getField(ChessCoordinates coordinates) {
        return this.fields[coordinates.column][coordinates.row];
    }
    
    private Field getField(int row, int column) {
        return fields[row][column];
    }
    
    public String fieldToString(int x, int y) {
        return fields[x][y].toString();
    }
    
    
}
