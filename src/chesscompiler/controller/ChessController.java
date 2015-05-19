package chesscompiler.controller;

import chesscompiler.model.ChessBoard;
import chesscompiler.view.ChessFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ChessController {

    private final ChessFrame view;
    private final ChessBoard model;

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
                int coordinates[] = {row, column}; 
                System.out.println(Arrays.toString(model.getValidMoves(coordinates)));
                view.resetHighlight();
                for(String fieldCoordinates: model.getValidMoves(coordinates)) {
                    view.highlightField(fieldCoordinates);
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
