package chesscompiler;

import chesscompiler.controller.ChessController;
import chesscompiler.model.ChessBoard;
import chesscompiler.model.pieces.*;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        BoardScanner scanner = new BoardScanner(".\\src\\examples\\full_chessboard_to_scan");
//        ChessBoard board = scanner.getBoard();
        ChessBoard board = new ChessBoard(8, 8);

        ChessFrame frame = new ChessFrame(8, 8);

        ChessController controller = new ChessController(frame, board);
        controller.start();

        board.addPiece("E1", new King(Piece.Color.WHITE));
        board.addPiece("H1", new Rook(Piece.Color.BLACK));
        board.addPiece("A1", new Rook(Piece.Color.WHITE));
        board.addPiece("B1", new Pawn(Piece.Color.WHITE));

        controller.updateView();

    }

}
