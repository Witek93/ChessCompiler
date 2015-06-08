package chesscompiler.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Liv
 */
public class BoardPanel extends JPanel {

    Field[][] fields;  
    ContextMenu contextMenu;
       
    public BoardPanel(int rowsCount, int columnsCount) {
        fields = new Field[rowsCount][columnsCount];

        setLayout(new GridLayout(rowsCount, columnsCount, 1, 1));

        initFields();       
        initContextMenu();
    }

    private void initFields() {
        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
                    fields[i][j] = new Field(new Color(80, 48, 45));
                } else {
                    fields[i][j] = new Field(new Color(237, 203, 118));
                }
                add(fields[i][j]);
            }
        }
    }
    
        
    public void initContextMenu(){
        contextMenu = new ContextMenu();
    }

    public int getRowsCount() {
        return fields.length;
    }

    public int getColumnsCount() {
        return fields[0].length;
    }

    public void highlightField(int row, int column) {
        getField(row, column).highlight();
    }

    public void updateField(int row, int column, Image image) {
        getField(row, column).setImage(image);
    }

    public void setMouseListener(int row, int column, MouseListener listener) {
        getField(row, column).addMouseListener(listener);
    }

    private Field getField(int row, int column) {
        return this.fields[row][column];
    }

    public void resetHighlight() {
        for (Field[] row : fields) {
            for (Field field : row) {
                field.reset();
            }
        }
    }
    
    public void showMenu(int row, int column, MouseEvent e){
        getField(row,column).showMenu(e);
    }
    
    private class Field extends JPanel {

        private Image image;
        private final Color backgroundColor;

        public Field(Color backgroundColor) {
            this.image = null;
            this.backgroundColor = backgroundColor;
            setBackground(backgroundColor);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }

        public void setImage(Image image) {
            this.image = image;
        }

        private void reset() {
            setBackground(backgroundColor);
        }

        public void highlight() {
            setBackground(new Color(80, 179, 45));
        }
        
        public void showMenu(MouseEvent e){
            contextMenu.show(Field.this, e.getX(), e.getY());
        }
    }

}
