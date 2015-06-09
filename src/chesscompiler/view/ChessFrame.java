package chesscompiler.view;

import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Liv
 */
public class ChessFrame extends JFrame {

    private BoardPanel board;
    private JMenuItem resetItem;
    private JRadioButtonMenuItem gameModeItem;

    public ChessFrame(int rows, int columns) {
        this.board = new BoardPanel(rows, columns);
        this.resetItem = new JMenuItem("Reset");
        this.gameModeItem = new JRadioButtonMenuItem("Game Mode");
        
        setTitle("Chess game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        
        initMenuBar();
        
        add(this.board);
    }
    
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
        
        gameMenu.add(resetItem);
        gameMenu.add(gameModeItem);
    }
    
    public boolean isGameMode() {
        return gameModeItem.isSelected();
    }
    
    public void addResetAction(ActionListener listener) {
        resetItem.addActionListener(listener);
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
