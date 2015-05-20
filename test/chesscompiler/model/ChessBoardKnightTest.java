package chesscompiler.model;

import chesscompiler.model.pieces.Knight;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Marlenka
 */
public class ChessBoardKnightTest {
    
    public ChessBoardKnightTest() {
    }

    @Test
    //pierwszy ruch
    public void testGetValidMoves_WhiteKnight_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B1", new Knight(Piece.Color.WHITE));
        board.addPiece("D2", new Pawn(Piece.Color.WHITE));
        String[] result = board.getValidMoves("B1");
        String[] expResult = {"A3", "C3"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //pierwszy ruch
    public void testGetValidMoves_BlackKnight_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B8", new Knight(Piece.Color.BLACK));
        board.addPiece("D7", new Pawn(Piece.Color.BLACK));
        String[] result = board.getValidMoves("B8");
        String[] expResult = {"A6", "C6"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //stoi w srodku, ma jednego wroga i jednego przeyjaciela 
    public void testGetValidMoves_WhiteKnight_OneEnemy_OneFriend() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B5", new Knight(Piece.Color.WHITE));
        board.addPiece("C3", new Pawn(Piece.Color.WHITE));
        board.addPiece("C7", new Pawn(Piece.Color.BLACK));
        String[] result = board.getValidMoves("B5");
        String[] expResult = {"A3", "D4", "D6", "C7", "A7"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //stoi w srodku, ma 2 wrogów, 1 przyjaciel
    public void testGetValidMoves_BlackKnight_TwoEnemies_OneFriend() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Knight(Piece.Color.BLACK));
        board.addPiece("C3", new Pawn(Piece.Color.WHITE));
        board.addPiece("D2", new Pawn(Piece.Color.WHITE));
        board.addPiece("C5", new Pawn(Piece.Color.BLACK));
        String[] result = board.getValidMoves("E4");
        String[] expResult = {"C3", "D2", "D6", "F2", "F6", "G3", "G5"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //stoi w rogu, ma 2 wrogów
    public void testGetValidMoves_BlackKnight_TwoEnemies() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A1", new Knight(Piece.Color.BLACK));
        board.addPiece("C2", new Pawn(Piece.Color.WHITE));
        board.addPiece("B3", new Pawn(Piece.Color.WHITE));
        String[] result = board.getValidMoves("A1");
        String[] expResult = {"C2", "B3"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //stoi w rogu, ma 2 wrogów
    public void testGetValidMoves_WhiteKnight_TwoEnemies() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("H7", new Knight(Piece.Color.WHITE));
        board.addPiece("F8", new Pawn(Piece.Color.BLACK));
        board.addPiece("F6", new Pawn(Piece.Color.WHITE));
        String[] result = board.getValidMoves("H7");
        String[] expResult = {"G5", "F8"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
}