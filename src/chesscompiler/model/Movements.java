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
    
    private static List<String> cutMoves(List<String> moves, ChessBoard board, int[] original){
        List<String> moves2 = new LinkedList<>();
        for(String destination : moves){
            if (board.isOccupied(destination)) {
                if (board.areEnemies(destination, Coordinates.fromArray(original))) {
                    moves2.add(destination);
                }
                break;
            } else {
                moves2.add(destination);
            }
        }   
        return moves2;
    }
    
    private static List<String> getHorizontal(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getLefts(coordinates.clone(), board));
        moves.addAll(getRights(coordinates.clone(), board));
        return moves;
    }
    
    private static List<String> getLefts(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.left(coordinates))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getRights(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.right(coordinates))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getVertical(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUps(coordinates.clone(), board));
        moves.addAll(getDowns(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUps(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.up(coordinates))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getDowns(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.down(coordinates))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getLeftSlant(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUpperLeftSlant(coordinates.clone(), board));
        moves.addAll(getLowerLeftSlant(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUpperLeftSlant(int[] original, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.up(Coordinates.left(coordinates)))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getLowerLeftSlant(int[] original, ChessBoard board) {
       List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.down(Coordinates.left(coordinates)))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getRightSlant(int[] coordinates, ChessBoard board) {
        List<String> moves = new LinkedList<>();
        moves.addAll(getUpperRightSlant(coordinates.clone(), board));
        moves.addAll(getLowerRightSlant(coordinates.clone(), board));
        return moves;
    }

    private static List<String> getUpperRightSlant(int[] original, ChessBoard board) {
       List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.up(Coordinates.right(coordinates)))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
    }

    private static List<String> getLowerRightSlant(int[] original, ChessBoard board) {
       List<String> moves = new LinkedList<>();
        String coordinates = Coordinates.fromArray(original);
        while((coordinates=Coordinates.down(Coordinates.right(coordinates)))!=null){
            moves.add(coordinates);
        }
        return cutMoves(moves, board, original);
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