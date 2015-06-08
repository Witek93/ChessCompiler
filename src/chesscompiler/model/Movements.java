package chesscompiler.model;

import java.util.LinkedList;
import java.util.List;

public class Movements {

    public static String[] getValid(String coordinates, ChessBoard board, Type type) {
        int[] cordsArray = Coordinates.toIntArray(coordinates);
        List<String> result;
        switch (type) {
            case HORIZONTAL_AND_VERTICAL:
                result = getHorizontal(cordsArray, board);
                result.addAll(getVertical(cordsArray, board));
                return result.toArray(new String[result.size()]);
            case HORIZONTAL:
                result = getHorizontal(cordsArray, board);
                return result.toArray(new String[result.size()]);
            case VERTICAL:
                result = getVertical(cordsArray, board);
                return result.toArray(new String[result.size()]);
            case BOTH_SLANTS:
                result = getLeftSlant(cordsArray, board);
                result.addAll(getRightSlant(cordsArray, board));
                return result.toArray(new String[result.size()]);
            case LEFT_SLANT:
                result = getLeftSlant(cordsArray, board);
                return result.toArray(new String[result.size()]);
            case RIGHT_SLANT:
                result = getRightSlant(cordsArray, board);
                return result.toArray(new String[result.size()]);
            default:
                return null;
        }

    }

    private static List<String> getHorizontal(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getLefts(coordinates.clone(), board));
        moves.addAll(getRights(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getLefts(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] destination = original.clone();
        destination[1]++;
        while (Coordinates.isValid(destination)) {
            if (getValue(board, destination, original, moves)) break;
            destination[1]++;
        }
        return moves;
    }

    private static boolean getValue(ChessBoard board, int[] destination, int[] original, List<String> moves) {
        if (board.isOccupied(Coordinates.fromArray(destination))) {
            if (board.areEnemies(Coordinates.fromArray(destination), Coordinates.fromArray(original))) {
                moves.add(Coordinates.fromArray(destination));
            }
            return true;
        } else {
            moves.add(Coordinates.fromArray(destination));
        }
        return false;
    }

    private static List<String> getRights(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] destination = original.clone();
        destination[1]--;
        while (Coordinates.isValid(destination)) {
            if (getValue(board, destination, original, moves)) break;
            destination[1]--;
        }
        return moves;
    }

    private static List<String> getVertical(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUps(coordinates.clone(), board));
        moves.addAll(getDowns(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUps(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] destination = original.clone();
        destination[0]--;
        while (Coordinates.isValid(destination)) {
            if (getValue(board, destination, original, moves)) break;
            destination[0]--;
        }
        return moves;
    }

    private static List<String> getDowns(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] destination = original.clone();
        destination[0]++;
        while (Coordinates.isValid(destination)) {
            if (getValue(board, destination, original, moves)) break;
            destination[0]++;
        }
        return moves;
    }

    private static List<String> getLeftSlant(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUpperLeftSlant(coordinates.clone(), board));
        moves.addAll(getLowerLeftSlant(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUpperLeftSlant(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] array = original.clone();
        upperLeft(array);
        while (Coordinates.isValid(array)) {
            if (getValue(board, array, original, moves)) break;
            upperLeft(array);
        }
        return moves;
    }

    private static void upperLeft(int[] array) {
        array[0]--;
        array[1]++;
    }

    private static List<String> getLowerLeftSlant(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] array = original.clone();
        lowLeft(array);
        while (Coordinates.isValid(array)) {
            if (getValue(board, array, original, moves)) break;
            lowLeft(array);
        }
        return moves;
    }

    private static void lowLeft(int[] array) {
        array[0]++;
        array[1]--;
    }

    private static List<String> getRightSlant(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUpperRightSlant(coordinates.clone(), board));
        moves.addAll(getLowerRightSlant(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUpperRightSlant(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] array = original.clone();
        upperRight(array);
        while (Coordinates.isValid(array)) {
            if (getValue(board, array, original, moves)) break;
            upperRight(array);
        }
        return moves;
    }

    private static void upperRight(int[] array) {
        array[0]++;
        array[1]++;
    }

    private static List<String> getLowerRightSlant(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        int[] array = original.clone();
        lowerRight(array);
        while (Coordinates.isValid(array)) {
        if (getValue(board, array, original, moves)) break;
        lowerRight(array);
    }
        return moves;
    }

    private static void lowerRight(int[] array) {
        array[0]--;
        array[1]--;
    }

    public enum Type {

        HORIZONTAL_AND_VERTICAL,
        HORIZONTAL,
        VERTICAL,
        BOTH_SLANTS,
        LEFT_SLANT, // '\'
        RIGHT_SLANT // '/'
    }
}
