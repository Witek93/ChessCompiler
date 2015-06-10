package chesscompiler.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PromotionFrame extends JFrame {

    JButton queen, rook, bishop, knight;

    public PromotionFrame() {
        super("Pawn promotion");
        setSize(400, 100);
        setLayout(new GridLayout(1, 0));
        this.queen = new JButton("Queen");
        this.rook = new JButton("Rook");
        this.bishop = new JButton("Bishop");
        this.knight = new JButton("Knight");
        
        add(queen);
        add(rook);
        add(bishop);
        add(knight);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public void onQueenClick(ActionListener listener) {
        queen.addActionListener(listener);
    }

    public void onRookClick(ActionListener listener) {
        rook.addActionListener(listener);
    }

    public void onBishopClick(ActionListener listener) {
        bishop.addActionListener(listener);
    }

    public void onKnightClick(ActionListener listener) {
        knight.addActionListener(listener);
    }

}
