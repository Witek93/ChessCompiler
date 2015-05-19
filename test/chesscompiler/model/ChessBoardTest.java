package chesscompiler.model;

import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wit
 */
public class ChessBoardTest {

    public ChessBoardTest() {
    }

    @Test
    public void testGetValidMoves_WhitePawn_AloneFirstMove() {
        // definiujemy planszę
        ChessBoard board = new ChessBoard(8, 8);
        
        // wrzucamy pionka na pole A2
        board.addPiece("A2", new Pawn(Piece.Color.WHITE));
        
        // pobieramy prawidłowe ruchy wg napisanego algorytmu
        String[] result = board.getValidMoves("A2");
        
        String[] expResult = {"A3", "A4"};
        // sprawdzamy czy się zgadza
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//pierwszy ruch pionka bez wrogow
    public void testGetValidMoves_BlackPawn_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A7", new Pawn(Piece.Color.BLACK));

        String[] result = board.getValidMoves("A7");
        
        String[] expResult = {"A6", "A5"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    
    @Test
    public void testGetValidMoves_WhitePawn_FirstMoveOneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A2", new Pawn(Piece.Color.WHITE));
        board.addPiece("B3", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("A2");
        
        String[] expResult = {"A3", "A4", "B3"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetValidMoves_WhitePawn_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A3", new Pawn(Piece.Color.WHITE));
        board.addPiece("B4", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("A3");
        
        String[] expResult = {"A4", "B4"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie drugiego pionka
    public void testGetValidMoves_BlackPawn_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A7", new Pawn(Piece.Color.BLACK));
        board.addPiece("B6", new Pawn(Piece.Color.WHITE));
        
        String[] result = board.getValidMoves("A7");
        
        String[] expResult = {"A6", "B6"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//blokada ruchow
    public void testGetValidMoves_BlackPawn_FirstMoveOneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("C7", new Pawn(Piece.Color.BLACK));
        board.addPiece("C6", new Pawn(Piece.Color.WHITE));
        
        String[] result = board.getValidMoves("C7");
        
        String[] expResult = {};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie lub ruch o 2
    public void testGetValidMoves_BlackPawn_FirstMoveOneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B7", new Pawn(Piece.Color.BLACK));
        board.addPiece("C6", new Pawn(Piece.Color.WHITE));
        
        String[] result = board.getValidMoves("B7");
        
        String[] expResult = {"C6","B6","B5"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie lub ruch o 2
    public void testGetValidMoves_WhitePawn_FirstMoveOneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B2", new Pawn(Piece.Color.WHITE));
        board.addPiece("C3", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("B7");
        
        String[] expResult = {"C3","B3","B4"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia do tylu
    public void testGetValidMoves_BlackPawn_MoveOneEnemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("D4", new Pawn(Piece.Color.BLACK));
        board.addPiece("C5", new Pawn(Piece.Color.WHITE));
        
        String[] result = board.getValidMoves("D4");
        
        String[] expResult = {"D3"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia do tylu
    public void testGetValidMoves_WhitePawn_MoveOneEnemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("D4", new Pawn(Piece.Color.WHITE));
        board.addPiece("C3", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("D4");
        
        String[] expResult = {"D5"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }

}
