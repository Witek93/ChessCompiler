package chesscompiler.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Liv
 */
public class BoardPanel extends JPanel {

    Field[][] fields;

    public BoardPanel(int rowsCount, int columnsCount) {
        fields = new Field[rowsCount][columnsCount];

        setLayout(new GridLayout(rowsCount, columnsCount, 1, 1));

        initFields();
    }

    private void initFields() {
        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                fields[i][j] = new Field();
                if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
                    fields[i][j].setBackground(Color.darkGray);
                } else {
                    fields[i][j].setBackground(Color.white);
                }
                add(fields[i][j]);
            }
        }
    }

    public int getRowsCount() {
        return fields.length;
    }

    public int getColumnsCount() {
        return fields[0].length;
    }

    public void updateField(int row, int column, Image image) {
        getField(row, column).setImage(image);
    }

    private Field getField(int row, int column) {
        return this.fields[row][column];
    }

    private class Field extends JPanel {

        private Image image;

        public Field() {
            this.image = null;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }

        public void setImage(Image image) {
            this.image = image;
        }

    }

}
