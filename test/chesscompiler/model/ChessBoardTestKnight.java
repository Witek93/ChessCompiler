package chesscompiler.model;

import chesscompiler.model.pieces.Knight;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Marlenka
 */
public class ChessBoardTestKnight {
    
    public ChessBoardTestKnight() {
    }

    @Test
    //pierwszy ruch
    public void testGetValidMoves_WhiteKnight_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B2", new Knight(Piece.Color.WHITE));
        String[] result = board.getValidMoves("B2");
        String[] expResult = {"A3", "C3"};
        assertArrayEquals(expResult, result);
    }
    
    @Test
    //pierwszy ruch
    public void testGetValidMoves_BlackKnight_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("B8", new Knight(Piece.Color.BLACK));
        String[] result = board.getValidMoves("B8");
        String[] expResult = {"A6", "C6"};
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
        assertArrayEquals(expResult, result);
    }
    
    
}