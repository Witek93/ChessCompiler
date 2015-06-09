package chesscompiler.view;

import chesscompiler.model.Coordinates;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Liv
 */
public class ChessFrame extends JFrame {

    private final BoardPanel board;
    private final JLabel statusLabel;
    private final JMenuItem resetItem, openFileItem;
    private final JRadioButtonMenuItem gameModeItem, editModeItem;

    public ChessFrame(int rows, int columns) {
        this.board = new BoardPanel(rows, columns);
        this.statusLabel = new JLabel("OK.", JLabel.CENTER);
        this.openFileItem = new JMenuItem("Open");
        this.resetItem = new JMenuItem("Reset");
        this.gameModeItem = new JRadioButtonMenuItem("Game Mode");
        this.editModeItem = new JRadioButtonMenuItem("Edit Mode");
        editModeItem.setSelected(true);

        setTitle("Chess game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        initMenuBar();
        
        JPanel statusPanel = new JPanel();
        statusPanel.add(statusLabel);
        statusPanel.setBackground(Color.white);
        add(statusPanel, BorderLayout.SOUTH);

        add(this.board, BorderLayout.CENTER);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(closeItem);
        fileMenu.add(openFileItem);

        gameMenu.add(resetItem);
        gameMenu.addSeparator();

        ButtonGroup group = new ButtonGroup();
        group.add(gameModeItem);
        group.add(editModeItem);
        gameMenu.add(gameModeItem);
        gameMenu.add(editModeItem);
    }

    public void addGameModeAction(ActionListener listener) {
        gameModeItem.addActionListener(listener);
    }
    
    public boolean isGameMode() {
        return gameModeItem.isSelected();
    }

    public boolean isEditMode() {
        return editModeItem.isSelected();
    }
    
    public void addOpenFileAction(ActionListener listener) {
        openFileItem.addActionListener(listener);
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
    
    public void setStatus(String text) {
        statusLabel.setText(text);
    }

}
