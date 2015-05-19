package chesscompiler;

import chesscompiler.controller.ChessController;
import chesscompiler.model.ChessBoard;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;    
import chesscompiler.scanner.BoardScanner;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoardScanner scanner = new BoardScanner(".\\src\\examples\\full_chessboard_to_scan");
        ChessBoard board = scanner.getBoard();

        ChessFrame frame = new ChessFrame(8, 8);

        ChessController controller = new ChessController(frame, board);
        controller.start();

        board.addPiece("D5", new Pawn(Piece.Color.WHITE));

        
        controller.updateView();

    }

}
