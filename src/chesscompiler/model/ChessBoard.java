package chesscompiler.model;

import chesscompiler.model.pieces.NoPiece;
import chesscompiler.model.pieces.Piece;
import java.awt.Image;

public class ChessBoard {

    private final Field[][] fields;

    public ChessBoard(int rowsCount, int columnsCount) {
        this.fields = new Field[rowsCount][columnsCount];
        initializeFields();
    }
    
    public void reset() {
        initializeFields();
    }

    private void initializeFields() {
        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                this.fields[i][j] = new Field();
            }
        }
    }

    public String[] getValidMoves(int[] array) {
        Field field = getField(array[0], array[1]);
        String[] moves = field.getPiece().getDefaultMoves(Coordinates.fromArray(array), this);
        return moves;
    }

    public String[] getValidMoves(String coordinates) {
        int array[] = Coordinates.toIntArray(coordinates);
        Field field = getField(array[0], array[1]);
        String[] moves = field.getPiece().getDefaultMoves(coordinates, this);
        return moves;
    }

    private void move(int fromRow, int fromColumn, int toRow, int toColumn) {
        Field source = getField(fromRow, fromColumn);
        Field destination = getField(toRow, toColumn);
        Piece sourcePiece = source.getPiece();
        source.setPiece(new NoPiece());
        sourcePiece.setMoved(true);
        destination.setPiece(sourcePiece);
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
        if (coordinates != null) {
            addPiece(coordinates[0], coordinates[1], piece);
        }
    }

    public boolean areAllies(String piece_str, String other_str) {
        int[] piece_array = Coordinates.toIntArray(piece_str);
        Piece piece = getPiece(piece_array[0], piece_array[1]);
        int[] other_array = Coordinates.toIntArray(other_str);
        Piece other = getPiece(other_array[0], other_array[1]);
        return piece.getColor().equals(other.getColor());
    }

    public boolean areEnemies(String piece, String other) {
        return isOccupied(piece) && isOccupied(other) && !areAllies(piece, other);
    }

    public boolean isAtInitialFile(String coordiantes) {
        if (isOccupied(coordiantes)) {
            int[] array = Coordinates.toIntArray(coordiantes);
            Piece piece = getField(array[0], array[1]).getPiece();
            if (piece.getColor().equals(Piece.Color.BLACK) && array[0] == 1) {
                return true;
            }
            if (piece.getColor().equals(Piece.Color.WHITE) && array[0] == 6) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupied(String coordinates) {
        int[] ar = Coordinates.toIntArray(coordinates);
        if (getPiece(ar[0], ar[1]) instanceof NoPiece) {
            return false;
        }
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

    public Piece getPiece(int row, int column) {
        return getField(row, column).getPiece();
    }
}
