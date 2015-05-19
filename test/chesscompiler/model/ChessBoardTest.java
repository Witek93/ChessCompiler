package chesscompiler.model;

import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
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
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetValidMoves_WhitePawn_FirstMoveOneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A2", new Pawn(Piece.Color.WHITE));
        board.addPiece("B3", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("A2");
        
        String[] expResult = {"A3", "A4", "B3"};
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetValidMoves_WhitePawn_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("A3", new Pawn(Piece.Color.WHITE));
        board.addPiece("B4", new Pawn(Piece.Color.BLACK));
        
        String[] result = board.getValidMoves("A3");
        
        String[] expResult = {"A4", "B4"};
        assertArrayEquals(expResult, result);
    }
    

}
