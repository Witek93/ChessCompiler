package chesscompiler.model;

import chesscompiler.model.pieces.Queen;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liv
 */
public class ChessBoardQueenTest {
    
    public ChessBoardQueenTest() {
    }
    
    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_BlackQueen_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.BLACK));

        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_WhiteQueen_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.WHITE));

        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie po prostej
    public void testGetValidMoves_BlackQueen_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.BLACK));
        board.addPiece("B4", new Queen(Queen.Color.WHITE));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie po prostej
    public void testGetValidMoves_WhiteQueen_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.WHITE));
        board.addPiece("B4", new Queen(Queen.Color.BLACK));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie po przekatnej
    public void testGetValidMoves_BlackQueen_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.BLACK));
        board.addPiece("C6", new Queen(Queen.Color.WHITE));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","A4","B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie po przekatnej
    public void testGetValidMoves_WhiteQueen_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.WHITE));
        board.addPiece("C6", new Queen(Queen.Color.BLACK));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","A4","B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie w bliskim otoczeniu
    public void testGetValidMoves_WhiteQueen_OneEnemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.WHITE));
        board.addPiece("E5", new Queen(Queen.Color.BLACK));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E5","E1","E2","E3", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie w bliskim otoczeniu
    public void testGetValidMoves_BlackQueen_OneEnemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.BLACK));
        board.addPiece("E5", new Queen(Queen.Color.WHITE));
        
        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E5","E1","E2","E3", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia
    public void testGetValidMoves_WhiteQueen_OneEnemy4() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.WHITE));
        board.addPiece("C5", new Queen(Queen.Color.BLACK));

        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia
    public void testGetValidMoves_BlackQueen_OneEnemy4() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Queen(Queen.Color.BLACK));
        board.addPiece("C5", new Queen(Queen.Color.WHITE));

        String[] result = board.getValidMoves("E4");
        
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7", "A4", "B4","C4","D4","F4","G4","H4",
                "E1", "E2","E3","E5","E6","E7","E8", "A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
}
