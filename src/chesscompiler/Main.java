package chesscompiler;

import chesscompiler.controller.ChessController;
import chesscompiler.model.ChessBoard;
import chesscompiler.model.pieces.Bishop;
import chesscompiler.model.pieces.King;
import chesscompiler.model.pieces.Knight;
import chesscompiler.model.pieces.Pawn;
import chesscompiler.model.pieces.Piece;
import chesscompiler.model.pieces.Queen;
import chesscompiler.model.pieces.Rook;
import chesscompiler.scanner.BoardScanner;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoardScanner scanner = new BoardScanner(".\\src\\examples\\full_chessboard_to_scan");
        ChessBoard board = scanner.getBoard();
  //      ChessBoard board = new ChessBoard(8, 8);

        ChessFrame frame = new ChessFrame(8, 8);

        ChessController controller = new ChessController(frame, board);
        controller.start();
        board.addPiece("C3", new Bishop(Piece.Color.BLACK));
        board.addPiece("E5", new Rook(Piece.Color.WHITE));

//        board.addPiece("C3", new King(Piece.Color.WHITE));
//        board.addPiece("D3", new Pawn(Piece.Color.WHITE));
//        board.addPiece("B1", new Rook(Piece.Color.BLACK));

        controller.updateView();

    }

}
