package chesscompiler.model;

import chesscompiler.model.pieces.NoPiece;
import chesscompiler.model.pieces.Pawn;
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

    public String[] getValidMoves(String coordinates) {
        int array[] = Coordinates.toIntArray(coordinates);
        String[] moves = getField(array[0], array[1]).getPiece().getDefaultMoves(coordinates);
        return moves;
    }

    private void move(int fromRow, int fromColumn, int toRow, int toColumn) {
        Field source = getField(fromRow, fromColumn);
        Field destination = getField(toRow, toColumn);
        destination.setPiece(source.getPiece());
        source.setPiece(new NoPiece());
    }

    public void move(String from, String to) {
        int[] source = Coordinates.toIntArray(from);
        int[] destination = Coordinates.toIntArray(to);
        if (source != null && destination != null) {
            move(source[0], source[1], destination[0], destination[1]);
        }
    }

    public boolean addPiece(int row, int column, Piece piece) {
        getField(row, column).setPiece(piece);
        return true;
    }

    public void addPiece(String a1, Piece piece) {
        int[] coordinates = Coordinates.toIntArray(a1);
        if(coordinates != null) {
            addPiece(coordinates[0], coordinates[1], piece);
        }
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
