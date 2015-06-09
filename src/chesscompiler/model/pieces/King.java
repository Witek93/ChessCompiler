package chesscompiler.model.pieces;

import chesscompiler.model.ChessBoard;
import chesscompiler.model.Coordinates;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class King extends Piece {

    public King(Color color) {
        this.color = color;
        this.moved = false;

        try {
            if (color.equals(Color.WHITE)) {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_klt60.png"));
            } else {
                img = ImageIO.read(new File(".\\resource\\images\\Chess_kdt60.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Bishop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public String[] getDefaultMoves(String coordiantes, ChessBoard board) {
        List<String> moves = getMoves(coordiantes, board);
        for (int i=0; i<moves.size(); i++){
            if (isCheck(board, coordiantes, moves.get(i))){
                moves.remove(moves.get(i));
                i--;
            }
        }
        return moves.toArray(new String[moves.size()]);
    }
    
    private List<String> getMoves(String coordiantes, ChessBoard board){
        List<String> moves = new LinkedList<>();
        moves.add(Coordinates.up(Coordinates.left(coordiantes)));
        moves.add(Coordinates.up(coordiantes));
        moves.add(Coordinates.up(Coordinates.right(coordiantes)));
        moves.add(Coordinates.right(coordiantes));
        moves.add(Coordinates.down(Coordinates.right(coordiantes)));
        moves.add(Coordinates.down(coordiantes));
        moves.add(Coordinates.down(Coordinates.left(coordiantes)));
        moves.add(Coordinates.left(coordiantes));

        while (moves.contains(null)) {
            moves.remove(null);
        }

        int i = 0;
        while (i < moves.size()) {
            if (board.areAllies(coordiantes, moves.get(i))) {
                moves.remove(i);
            } else {
                i++;
            }
        }        
        //moves.addAll(castling(board, coordiantes));
        return moves;
    }
    
    // from, to - miejsce początkowe i końcowe przy przesuwaniu króla
    public boolean isCheck(ChessBoard board, String from, String to){
        ChessBoard newBoard = new ChessBoard(board.getRowsCount(), board.getColumnsCount());
        for (int i=0; i<newBoard.getRowsCount(); i++)
            for(int j=0; j<newBoard.getColumnsCount(); j++)
                newBoard.addPiece(i, j, board.getPiece(i, j));
        
        newBoard.move(from, to);
        for (int i=0; i<newBoard.getRowsCount(); i++)
            for(int j=0; j<newBoard.getColumnsCount(); j++)
              if(newBoard.isOccupied(Coordinates.create(i, j)) && !Coordinates.create(i, j).equals(to)){
                Piece piece = newBoard.getPiece(i, j);
                if (newBoard.areEnemies(to, Coordinates.create(i,j)) && !(piece instanceof King)){
                    String[] enemyMoves = newBoard.getValidMoves(Coordinates.create(i, j));
                    if(Arrays.asList(enemyMoves).contains(to)) {
                        return true;
                    }                
                }
                else if (newBoard.areEnemies(to, Coordinates.create(i,j)) && piece instanceof King){
                    List<String> enemyKingMoves = getMoves(Coordinates.create(i,j), newBoard);
                    if (enemyKingMoves.contains(to)){
                        return true;
                    }
                }
                }
        return false;
    }
    
    public List<String> castling(ChessBoard board, String coordinates){
        List<String> moves = new LinkedList();
/*        if (coordinates.equals("E1") && !hasMoved("E1")){
            if(!board.isOccupied("F1") && !board.isOccupied("G1") && !hasMoved("H1"))
                moves.add("G1");
            if(!board.isOccupied("B1") && !board.isOccupied("C1") && !board.isOccupied("D1") && !hasMoved("A1"))
                moves.add("C1");
        }
        else if (coordinates.equals("E8") && !hasMoved("E8")){
            if(!board.isOccupied("F8") && !board.isOccupied("G8") && !hasMoved("H8"))
                moves.add("G8");
            if(!board.isOccupied("B8") && !board.isOccupied("C8") && !board.isOccupied("D8") && !hasMoved("A8"))
                moves.add("C8");    
        }
  */      return moves;
    }
    
    
}
