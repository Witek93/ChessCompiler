package chesscompiler;

import chesscompiler.board.ChessBoard;
import chesscompiler.scanner.BoardScanner;
import chesscompiler.view.ChessFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChessFrame frame = new ChessFrame(8, 8);
        frame.setVisible(true);

        BoardScanner scanner = new BoardScanner(".\\src\\examples\\full_chessboard_to_scan");
        ChessBoard board = scanner.getBoard();
        
        updateView(board, frame);

//        board.move("B1", "C1");
    }

    private static void updateView(ChessBoard board, ChessFrame frame) {
        for (int i = 0; i < board.getRowsCount(); i++) {
            for (int j = 0; j < board.getColumnsCount(); j++) {
                frame.updatePieceImage(i, j, board.getPieceImage(i, j));
            }
        }
        frame.repaint();
    }

}
