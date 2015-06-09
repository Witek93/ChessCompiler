package chesscompiler.controller;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import chesscompiler.model.pieces.*;
import chesscompiler.scanner.BoardScanner;
import chesscompiler.view.ChessFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ChessController {

    private final ChessFrame view;
    private final ChessBoard model;
    private final int[] lastCoordinates;

    public ChessController(ChessFrame view, ChessBoard model) {
        this.view = view;
        this.model = model;
        this.lastCoordinates = new int[2];
    }

    public void start() {
        this.view.setVisible(true);
        setListeners();
    }

    public void setListeners() {
        for (int i = 0; i < model.getRowsCount(); i++) {
            for (int j = 0; j < model.getColumnsCount(); j++) {
                setListener(i, j);
                addActionListener(i, j);
            }
        }
        this.view.addResetAction((ActionEvent e) -> {
            model.reset();
            updateView();
        });
        this.view.addOpenFileAction((ActionEvent e) -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                try {
                    BoardScanner scanner = new BoardScanner(fc.getSelectedFile().getAbsolutePath());
                    ChessBoard board = scanner.getBoard();
                    model.reset();
                    for (int i = 0; i < board.getRowsCount(); i++) {
                        for (int j = 0; j < board.getColumnsCount(); j++) {
                            model.addPiece(i, j, board.getPiece(i, j));
                        }
                    }
                    updateView();
                } catch (BoardScanner.BadFileFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Wrong file format!",
                            "Open file error", JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(view, "File does not exists!",
                            "Open file error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void setListener(final int row, final int column) {
        view.setMouseListener(row, column, new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (view.isGameMode()) {
                        processLMBInGameMode();
                    } else {
                        processLMBInEditMode();
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    processRightClick(e);
                }
            }

            private void processLMBInGameMode() {
                if (view.isHighlighted(row, column)) {
                    movePieceAndResetHighlight(row, column);
                } else {
                    view.resetHighlight();
                    lastCoordinates[0] = row;
                    lastCoordinates[1] = column;
                    System.out.println(Arrays.toString(model.getValidMoves(lastCoordinates)));
                    for (String fieldCoordinates : model.getValidMoves(lastCoordinates)) {
                        view.highlightField(fieldCoordinates);
                    }
                }
            }

            private void processLMBInEditMode() {
                if (view.isHighlighted(lastCoordinates[0], lastCoordinates[1])) {
                    movePieceAndResetHighlight(row, column);
                } else {
                    view.highlightField(Coordinates.create(row, column));
                    lastCoordinates[0] = row;
                    lastCoordinates[1] = column;
                }
            }

            private void processRightClick(MouseEvent e) {
                if (view.isEditMode()) {
                    view.showMenu(row, column, e);
                }
            }

        });
    }

    private void movePieceAndResetHighlight(int row, int column) {
        model.move(Coordinates.fromArray(lastCoordinates), Coordinates.create(row, column));
        view.resetHighlight();
        updateView();
    }

    public void addActionListener(final int row, final int column) {
        addBlackPieces(row, column);
        addWhitePieces(row, column);
    }

    private void addBlackPieces(int row, int column) {
        view.addActionListenerBlack("King", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new King(Piece.Color.BLACK));
        });
        view.addActionListenerBlack("Queen", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Queen(Piece.Color.BLACK));
        });
        view.addActionListenerBlack("Bishop", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Bishop(Piece.Color.BLACK));
        });
        view.addActionListenerBlack("Rook", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Rook(Piece.Color.BLACK));
        });
        view.addActionListenerBlack("Knight", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Knight(Piece.Color.BLACK));
        });
        view.addActionListenerBlack("Pawn", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Pawn(Piece.Color.BLACK));
        });
    }

    private void addWhitePieces(int row, int column) {
        view.addActionListenerWhite("King", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new King(Piece.Color.WHITE));
        });
        view.addActionListenerWhite("Queen", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Queen(Piece.Color.WHITE));
        });
        view.addActionListenerWhite("Bishop", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Bishop(Piece.Color.WHITE));
        });
        view.addActionListenerWhite("Rook", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Rook(Piece.Color.WHITE));
        });
        view.addActionListenerWhite("Knight", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Knight(Piece.Color.WHITE));
        });
        view.addActionListenerWhite("Pawn", row, column, (ActionEvent e) -> {
            updatePieceOnField(row, column, new Pawn(Piece.Color.WHITE));
        });
    }

    private void updatePieceOnField(final int row, final int column, Piece piece) {
        model.addPiece(row, column, piece);
        updateView();
    }

    public void updateView() {
        for (int i = 0; i < model.getRowsCount(); i++) {
            for (int j = 0; j < model.getColumnsCount(); j++) {
                view.updatePieceImage(i, j, model.getPieceImage(i, j));
            }
        }
        view.repaint();
    }

}
