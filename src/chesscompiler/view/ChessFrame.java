package chesscompiler.view;

import chesscompiler.board.pieces.Bishop;
import chesscompiler.board.pieces.Piece;
import chesscompiler.board.pieces.Piece.Color;
import javax.swing.JFrame;

/**
 *
 * @author Liv
 */
public class ChessFrame extends JFrame {

    BoardPanel board;

    public ChessFrame() {
        this.board = new BoardPanel();
        setTitle("Chess game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        this.board.updateField(2, 2, new Bishop(Color.WHITE));
        this.board.updateField(2, 5, new Bishop(Color.BLACK));

        add(this.board);
    }

    public void updateField(int row, int column, Piece piece) {
        board.updateField(row, column, piece);
    }

    public static void main(String[] args) {
        ChessFrame view = new ChessFrame();
        view.setVisible(true);

    }

}
