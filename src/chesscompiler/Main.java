package chesscompiler;

import chesscompiler.controller.ChessController;
import chesscompiler.model.ChessBoard;
import chesscompiler.model.pieces.*;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ChessBoard board = new ChessBoard(8, 8);
        ChessFrame frame = new ChessFrame(8, 8);

        ChessController controller = new ChessController(frame, board);
        controller.start();

        board.addPiece("E8", new King(Piece.Color.BLACK));
        board.addPiece("A8", new Rook(Piece.Color.BLACK));
        board.addPiece("H8", new Rook(Piece.Color.BLACK));
        board.addPiece("D7", new Rook(Piece.Color.WHITE));
        board.addPiece("B2", new Pawn(Piece.Color.WHITE));
        board.addPiece("C4", new Pawn(Piece.Color.BLACK));

        controller.updateView();

    }

}
