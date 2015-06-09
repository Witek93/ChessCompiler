package chesscompiler.view;

import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Liv
 */
public class ChessFrame extends JFrame {

    BoardPanel board;

    public ChessFrame(int rows, int columns) {
        this.board = new BoardPanel(rows, columns);
        setTitle("Chess game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        add(this.board);
    }

    public void updatePieceImage(int row, int column, Image image) {
        board.updateField(row, column, image);
    }

    public void showMenu(int row, int column, MouseEvent e) {
        board.showMenu(row, column, e);
    }

    public void highlightField(String coordinates) {
        int[] array = Coordinates.toIntArray(coordinates);
        board.highlightField(array[0], array[1]);
    }

    public boolean isHighlighted(int row, int column) {
        return board.isHighlighted(row, column);
    }

    public void resetHighlight() {
        board.resetHighlight();
    }

    public void setMouseListener(int row, int column, MouseListener listener) {
        board.setMouseListener(row, column, listener);
    }

    public void addActionListenerWhite(String text, int row, int column, ActionListener listener) {
        board.addActionListenerWhite(text, row, column, listener);
    }
    
    public void addActionListenerBlack(String text, int row, int column, ActionListener listener) {
        board.addActionListenerBlack(text, row, column, listener);
    }

}
