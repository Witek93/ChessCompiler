package chesscompiler.board;

public class ChessCoordinates {
    int row;
    int column;

    public ChessCoordinates(int row, int column) {
        //TODO we should be able to create only coordinates in range [1..8, 1..8] 
        this.row = row;
        this.column = column;
    }
    
    public ChessCoordinates(String coordinates) {
        
        char columnChar = coordinates.toUpperCase().charAt(0);
        if(columnChar >= 'A' && columnChar <= 'H') {
            this.column = columnChar - 'A';
        } else {
            //TODO throw exception
        }
        
        char rowChar = coordinates.charAt(1);
        if(rowChar >= '1' && rowChar <= '8') {
            this.row = rowChar - '1';
        } else {
            //TODO throw exception
        }
        
    }

    @Override
    public String toString() {
        char columnChar = (char) ('A' + this.column);
        return String.valueOf(columnChar) + String.valueOf(this.row+1);
    }
    
    
    
}
