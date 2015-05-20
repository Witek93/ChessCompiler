package chesscompiler.model;

import java.util.LinkedList;
import java.util.List;

public class Movements {

    public static String[] getValid(String coordinates, ChessBoard board, Type type) {
        int[] cordsArray = Coordinates.toIntArray(coordinates);
        List<String> result;
        switch (type) {
            case HORIZONTAL_AND_VERTICAL:
                result = getHorizontal(cordsArray);
                result.addAll(getVertical(cordsArray));
                return result.toArray(new String[result.size()]);
            case HORIZONTAL:
                result = getHorizontal(cordsArray);
                return result.toArray(new String[result.size()]);
            case VERTICAL:
                result = getVertical(cordsArray);
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

    private static List<String> getHorizontal(int[] coordinates) {
        List<String> moves = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            if (coordinates[1] != i) {
                moves.add(Coordinates.fromArray(new int[]{coordinates[0], i}));
            }
        }
        return moves;
    }

    private static List<String> getVertical(int[] coordinates) {
        List<String> moves = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            if (coordinates[0] != i) {
                moves.add(Coordinates.fromArray(new int[]{i, coordinates[1]}));
            }
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
            if (board.isOccupied(Coordinates.fromArray(array))) {
                if (board.areEnemies(Coordinates.fromArray(array), Coordinates.fromArray(original))) {
                    moves.add(Coordinates.fromArray(array));
                }
                break;
            } else {
                moves.add(Coordinates.fromArray(array));
            }
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
            if (board.isOccupied(Coordinates.fromArray(array))) {
                if (board.areEnemies(Coordinates.fromArray(array), Coordinates.fromArray(original))) {
                    moves.add(Coordinates.fromArray(array));
                }
                break;
            } else {
                moves.add(Coordinates.fromArray(array));
            }
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
            if (board.isOccupied(Coordinates.fromArray(array))) {
                if (board.areEnemies(Coordinates.fromArray(array), Coordinates.fromArray(original))) {
                    moves.add(Coordinates.fromArray(array));
                }
                break;
            } else {
                moves.add(Coordinates.fromArray(array));
            }
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
            if (board.isOccupied(Coordinates.fromArray(array))) {
                if (board.areEnemies(Coordinates.fromArray(array), Coordinates.fromArray(original))) {
                    moves.add(Coordinates.fromArray(array));
                }
                break;
            } else {
                moves.add(Coordinates.fromArray(array));
            }
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
