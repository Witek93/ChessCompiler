package chesscompiler.view;
import chesscompiler.board.pieces.Piece;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liv
 */
public class BoardPanel extends JPanel {
    JPanel[][] fields;
    
    public BoardPanel() {
        fields = new JPanel[8][8];
        
        setLayout(new GridLayout(8, 8, 1, 1));
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                fields[i][j] = new JPanel();
                if((j%2==0 && i%2==1) || (j%2==1 && i%2==0)){
                    fields[i][j].setBackground(Color.darkGray);
                }
                else{
                    fields[i][j].setBackground(Color.white);
                }
                add(fields[i][j]);
            }
        }       
    }
    
    public void updateField(int row, int column, Piece piece) {
        JLabel label=new JLabel();
        label.setIcon(piece.getImage());
        label.setSize(getField(row,column).getWidth(), getField(row,column).getHeight());
        getField(row,column).add(label);
    }
    
    private JPanel getField(int row, int column) {
        return this.fields[row][column];
    }
    
}
