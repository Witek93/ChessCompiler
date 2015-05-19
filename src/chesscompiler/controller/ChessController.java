package chesscompiler.controller;

import chesscompiler.model.ChessBoard;
import chesscompiler.view.ChessFrame;

public class ChessController {

    private final ChessFrame view;
    private final ChessBoard model;

    public ChessController(ChessFrame view, ChessBoard model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        this.view.setVisible(true);
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
