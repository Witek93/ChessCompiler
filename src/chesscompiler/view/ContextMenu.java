package chesscompiler.view;

import chesscompiler.model.pieces.King;
import chesscompiler.model.pieces.Piece;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class ContextMenu extends JPopupMenu{
    JMenu subMenuBlack, subMenuWhite;
    
    public ContextMenu() {
        subMenuBlack = new JMenu("Black");
        subMenuWhite = new JMenu("White");
        
        JMenuItem kingItem = new JMenuItem("King");
        JMenuItem queenItem = new JMenuItem("Queen");
        JMenuItem pawnItem = new JMenuItem("Pawn");
        JMenuItem bishopItem = new JMenuItem("Bishop");
        JMenuItem knightItem = new JMenuItem("Knight");
        JMenuItem rookItem = new JMenuItem("Rook");
        
        JMenuItem kingItemBlack= new JMenuItem("King");
        JMenuItem queenItemBlack = new JMenuItem("Queen");
        JMenuItem pawnItemBlack= new JMenuItem("Pawn");
        JMenuItem bishopItemBlack = new JMenuItem("Bishop");
        JMenuItem knightItemBlack = new JMenuItem("Knight");
        JMenuItem rookItemBlack= new JMenuItem("Rook");
        
        addNewPiece(kingItem);
        subMenuBlack.add(kingItemBlack);
        subMenuBlack.add(queenItemBlack);
        subMenuBlack.add(pawnItemBlack);
        subMenuBlack.add(bishopItemBlack);
        subMenuBlack.add(knightItemBlack);
        subMenuBlack.add(rookItemBlack);
        
        subMenuWhite.add(kingItem);
        subMenuWhite.add(queenItem);
        subMenuWhite.add(pawnItem);
        subMenuWhite.add(bishopItem);
        subMenuWhite.add(knightItem);
        subMenuWhite.add(rookItem);
        
        add(subMenuBlack);
        add(subMenuWhite);
    }

    private void addNewPiece(JMenuItem piece) {
        piece.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "You are the king!");
                //board.addPiece("C3", new King(Piece.Color.WHITE));
            }
        });
    }
    
}
