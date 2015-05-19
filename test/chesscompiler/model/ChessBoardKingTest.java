package chesscompiler.model;

import chesscompiler.model.pieces.Bishop;
import chesscompiler.model.pieces.King;
import chesscompiler.model.pieces.Knight;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
import chesscompiler.model.pieces.Rook;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author Marlenka
 */
public class ChessBoardKingTest {

    public ChessBoardKingTest() {
    }
    
    @Test
    //idąc w przód byłby zablokowany
    public void testGetValidMoves_BlackKing_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E8", new King(Piece.Color.BLACK));
        board.addPiece("F8", new Bishop(Piece.Color.WHITE));
        String[] result = board.getValidMoves("E8");
        String[] expResult = {"D8", "D7", "F8", "F7"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //zablokowany przez konika
    public void testGetValidMoves_WhiteKing_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("D4", new King(Piece.Color.WHITE));
        board.addPiece("C5", new Knight(Piece.Color.BLACK));
        board.addPiece("D3", new Bishop(Piece.Color.WHITE));
        String[] result = board.getValidMoves("D4");
        String[] expResult = {"C3", "C4", "E3", "D5", "E5"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }

    @Test
    //zablokowany przez wieze
    public void testGetValidMoves_WhiteKing_OneEnemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("C3", new King(Piece.Color.WHITE));
        board.addPiece("D3", new Pawn(Piece.Color.WHITE));
        board.addPiece("B1", new Rook(Piece.Color.BLACK));
        String[] result = board.getValidMoves("C3");
        String[] expResult = {"C2", "D2", "C4", "D4"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //0 wrogów
    public void testGetValidMoves_BlacKing_NoEnemies() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E7", new King(Piece.Color.BLACK));
        String[] result = board.getValidMoves("E7");
        String[] expResult = {"D6", "E6", "F6", "D7", "F7", "D8", "E8", "F8"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //zablkowany przez gońca
    public void testGetValidMoves_BlacKing_Enemy3() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("D5", new King(Piece.Color.BLACK));
        board.addPiece("C6", new Pawn(Piece.Color.BLACK));
        board.addPiece("D4", new Bishop(Piece.Color.WHITE));
        board.addPiece("A6", new Bishop(Piece.Color.WHITE));
        String[] result = board.getValidMoves("D5");
        String[] expResult = {"D4", "E4", "D6", "E6"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
}

