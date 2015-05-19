package chesscompiler.model;

import java.util.LinkedList;
import java.util.List;

public class Coordinates {

    public static int[] toIntArray(String coordinates) {
        if (isValid(coordinates)) {
            coordinates = coordinates.toUpperCase();
            int[] array = {8 - (coordinates.charAt(1) - '0'), coordinates.charAt(0) - 'A'};
            return array;
        }
        return null; //TODO: exception maybe?
    }

    public static String fromArray(int[] coordinates) {
        char letter = (char) (coordinates[1] + 'A');
        char number = (char) (8 - coordinates[0] + '0');
        String str = "" + letter + number;
        return str;
    }

    private static boolean isValid(String coordinates) {
        if (coordinates.length() == 2) {
            coordinates = coordinates.toUpperCase();
            char letter = coordinates.charAt(0);
            char number = coordinates.charAt(1);
            if (letter >= 'A' && letter <= 'H') {
                if (number >= '1' && number <= '8') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[] coordinates) {
        if (coordinates.length == 2) {
            if (coordinates[0] >= 0 && coordinates[0] < 8) {
                if (coordinates[1] >= 0 && coordinates[1] < 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[] getValidMoves(String coordinates, Direction direction) {
        int[] array = toIntArray(coordinates);
        switch (direction) {
            case LEFT:
                return getLefts(array);
            case UP:
                return getUps(array);
            case RIGHT:
                return getRights(array);
            case DOWN:
                return getDowns(array);
            default:
                return null;
        }
    }

    private static String[] getLefts(int[] array) {
        List<String> moves = new LinkedList<>();
        array[1]--;
        while (isValid(array)) {
            moves.add(fromArray(array));
            array[1]--;
        }
        return moves.toArray(new String[moves.size()]);
    }

    private static String[] getUps(int[] array) {
        List<String> moves = new LinkedList<>();
        array[0]++;
        while (isValid(array)) {
            moves.add(fromArray(array));
            array[0]++;
        }
        return moves.toArray(new String[moves.size()]);
    }

    private static String[] getRights(int[] array) {
        List<String> moves = new LinkedList<>();
        array[1]++;
        while (isValid(array)) {
            moves.add(fromArray(array));
            array[1]++;
        }
        return moves.toArray(new String[moves.size()]);
    }

    private static String[] getDowns(int[] array) {
        List<String> moves = new LinkedList<>();
        array[0]--;
        while (isValid(array)) {
            moves.add(fromArray(array));
            array[0]--;
        }
        return moves.toArray(new String[moves.size()]);
    }

    public enum Direction {

        UP, RIGHT, DOWN, LEFT;
    }

}
