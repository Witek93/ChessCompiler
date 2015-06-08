package chesscompiler.controller;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import chesscompiler.view.ChessFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ChessController {

    private final ChessFrame view;
    private final ChessBoard model;
    private static int[] lastCoordinates = new int[2];

    public ChessController(ChessFrame view, ChessBoard model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        this.view.setVisible(true);
        setListeners();
    }

    public void setListeners() {
        for (int i = 0; i < model.getRowsCount(); i++) {
            for (int j = 0; j < model.getColumnsCount(); j++) {
                setListener(i, j);
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

    public void updateView() {
        for (int i = 0; i < model.getRowsCount(); i++) {
            for (int j = 0; j < model.getColumnsCount(); j++) {
                view.updatePieceImage(i, j, model.getPieceImage(i, j));
            }
        }
        view.repaint();
    }

}
