package chesscompiler.model;

import chesscompiler.model.pieces.NoPiece;
import chesscompiler.model.pieces.Piece;
import java.awt.Image;

public class ChessBoard {

    private final Field[][] fields;

    public ChessBoard(int rowsCount, int columnsCount) {
        this.fields = new Field[rowsCount][columnsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                this.fields[i][j] = new Field();
            }
        }
    }

    private void move(int fromRow, int fromColumn, int toRow, int toColumn) {
        Field source = getField(fromRow, fromColumn);
        Field destination = getField(toRow, toColumn);
        destination.setPiece(source.getPiece());
        source.setPiece(new NoPiece());
    }

    public void move(String from, String to) {
        int[] source = getCoordinates(from);
        int[] destination = getCoordinates(to);
        if (source != null && destination != null) {
            move(source[0], source[1], destination[0], destination[1]);
        }
    }

    private int[] getCoordinates(String s) {
        if (s.length() == 2) {
            s = s.toUpperCase();
            char letter = s.charAt(0);
            char number = s.charAt(1);
            if (letter >= 'A' && letter <= 'H') {
                if (number >= '1' && number <= '8') {
                    int[] coordinates = new int[2];
                    int _row = 8 - (number - '0'); //number
                    int _column = letter - 'A'; //letter
                    coordinates[0] = _row;
                    coordinates[1] = _column;
                    return coordinates;
                }
            }
        }
        return null;
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
