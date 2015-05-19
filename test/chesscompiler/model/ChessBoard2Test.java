package chesscompiler.model;

import chesscompiler.model.pieces.Rook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liv
 */
public class ChessBoard2Test {
    //ROOK TESTS
    //todo roszada
    public ChessBoard2Test() {
    }

    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_BlackRook_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A8", new Rook(Rook.Color.BLACK));

        String[] result = board.getValidMoves("A8");
        
        String[] expResult = {"A6", "A5","A1","A2","A3","A4","A7","B8","C8","D8","E8","F8","G8","H8"};
        assertArrayEquals(expResult, result);
    }
    
    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_WhiteRook_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A1", new Rook(Rook.Color.BLACK));

        String[] result = board.getValidMoves("A1");
        
        String[] expResult = {"A6", "A5","A8","A2","A3","A4","A7","B1","C1","D1","E1","F1","G1","H1"};
        assertArrayEquals(expResult, result);
    }
    
    @Test//ruch z biciem
    public void testGetValidMoves_WhiteRook_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A4", new Rook(Rook.Color.WHITE));
        board.addPiece("A5", new Rook(Rook.Color.BLACK));
        
        String[] result = board.getValidMoves("A4");
        
        String[] expResult = {"A1", "A5","A2","A3","B4","C4","D4","E4","F4","G4","H4"};
        assertArrayEquals(expResult, result);
    }
    
    @Test//ruch z biciem
    public void testGetValidMoves_BlackRook_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A5", new Rook(Rook.Color.BLACK));
        board.addPiece("A4", new Rook(Rook.Color.WHITE));
        
        String[] result = board.getValidMoves("A5");
        
        String[] expResult = {"A6", "A7","A8","A4","B5","C5","D5","E5","F5","G5","H5"};
        assertArrayEquals(expResult, result);
    }
    
    @Test//ruch bez bicia
    public void testGetValidMoves_BlackRook_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A5", new Rook(Rook.Color.BLACK));
        board.addPiece("B4", new Rook(Rook.Color.WHITE));
        
        String[] result = board.getValidMoves("A5");
        
        String[] expResult = {"A6", "A7","A8","A4","A3","A2","A1","B5","C5","D5","E5","F5","G5","H5"};
        assertArrayEquals(expResult, result);
    }
    
    @Test//ruch bez bicia
    public void testGetValidMoves_WhiteRook_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A5", new Rook(Rook.Color.WHITE));
        board.addPiece("B4", new Rook(Rook.Color.BLACK));
        
        String[] result = board.getValidMoves("A5");
        
        String[] expResult = {"A6", "A7","A8","A4","A3","A2","A1","B5","C5","D5","E5","F5","G5","H5"};
        assertArrayEquals(expResult, result);
    }
}
