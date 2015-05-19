package chesscompiler.view;

import java.awt.Image;
import javax.swing.ImageIcon;
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

}
