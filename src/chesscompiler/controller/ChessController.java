package chesscompiler.controller;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import chesscompiler.model.pieces.*;
import chesscompiler.view.ChessFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ChessController {

    private final ChessFrame view;
    private final ChessBoard model;
    private static final int[] lastCoordinates = new int[2];

    public ChessController(ChessFrame view, ChessBoard model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        this.view.setVisible(true);
        setListeners();
        this.view.addResetAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset();
                updateView();
            }
        });
    }

    public void setListeners() {
        for (int i = 0; i < model.getRowsCount(); i++) {
            for (int j = 0; j < model.getColumnsCount(); j++) {
                setListener(i, j);
                addActionListener(i, j);
            }
        }
    }

    public void setListener(final int row, final int column) {
        view.setMouseListener(row, column, new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (view.isHighlighted(row, column)) {
                        model.move(Coordinates.fromArray(lastCoordinates), Coordinates.create(row, column));
                        view.resetHighlight();
                        updateView();
                    } else {
                        view.resetHighlight();
                        lastCoordinates[0] = row;
                        lastCoordinates[1] = column;
                        System.out.println(Arrays.toString(model.getValidMoves(lastCoordinates)));
                        for (String fieldCoordinates : model.getValidMoves(lastCoordinates)) {
                            view.highlightField(fieldCoordinates);
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    view.showMenu(row, column, e);
                }
            }

        });
    }
    
    public void addActionListener(final int row, final int column) {
        addBlackPieces(row, column);
        addWhitePieces(row, column);
    }
    
    private void addBlackPieces(int row, int column){
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

    private void addWhitePieces(int row, int column){
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
