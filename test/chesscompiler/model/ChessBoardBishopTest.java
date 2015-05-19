/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesscompiler.model;

import chesscompiler.model.pieces.Bishop;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liv
 */
public class ChessBoardBishopTest {
    
    public ChessBoardBishopTest() {
    }

    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_BlackBishop_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.BLACK));

        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_BlackBishop_AloneFirstMove2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("D4", new Bishop(Bishop.Color.BLACK));

        String[] result = board.getValidMoves("D4");
        
        String[] expResult = {"A1","B2","C3","F5","G6","H7","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//pierwszy ruch bez wrogow
    public void testGetValidMoves_WhiteBishop_AloneFirstMove() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.WHITE));

        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","G6","H7","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie
    public void testGetValidMoves_WhiteBishop_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.WHITE));
        board.addPiece("F5", new Bishop(Bishop.Color.BLACK));
        
        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//bicie
    public void testGetValidMoves_BlackBishop_OneEnemy() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.BLACK));
        board.addPiece("F5", new Bishop(Bishop.Color.WHITE));
        
        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia
    public void testGetValidMoves_BlackBishop_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.BLACK));
        board.addPiece("E5", new Bishop(Bishop.Color.WHITE));
        
        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
    @Test//brak bicia
    public void testGetValidMoves_WhiteBishop_OneEnemy2() {
        ChessBoard board = new ChessBoard(8, 8);
        board.addPiece("E4", new Bishop(Bishop.Color.WHITE));
        board.addPiece("E5", new Bishop(Bishop.Color.BLACK));
        
        String[] result = board.getValidMoves("E4");
        
        String[] expResult = {"B1","C2","D3","F5","A8","B7","C6","D5","F3","G2","H1"};
        Arrays.sort(result);
        Arrays.sort(expResult);
        assertArrayEquals(expResult, result);
    }
    
}
