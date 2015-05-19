package chesscompiler;

import chesscompiler.controller.ChessController;
import chesscompiler.model.ChessBoard;
import chesscompiler.scanner.BoardScanner;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoardScanner scanner = new BoardScanner(".\\src\\examples\\full_chessboard_to_scan");
        ChessBoard board = scanner.getBoard();

        ChessFrame frame = new ChessFrame(8, 8);

        ChessController controller = new ChessController(frame, board);
        controller.start();

        controller.updateView();

    }

}
