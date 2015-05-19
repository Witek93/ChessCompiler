package chesscompiler.model;

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

    public static boolean isValid(String coordinates) {
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

    public static boolean isValid(int[] coordinates) {
        if (coordinates.length == 2) {
            if (coordinates[0] >= 0 && coordinates[0] < 8) {
                if (coordinates[1] >= 0 && coordinates[1] < 8) {
                    return true;
                }
            }
        }
        return false;
    }

}
