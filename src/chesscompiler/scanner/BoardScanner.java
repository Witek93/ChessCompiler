package chesscompiler.scanner;

import chesscompiler.board.ChessBoard;
import chesscompiler.board.ChessCoordinates;
import chesscompiler.board.PiecesCreator;
import chesscompiler.board.pieces.NoPiece;
import chesscompiler.board.pieces.Piece;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BoardScanner {
    private static final int BOARD_SIZE = 8;
    
    private static final Set<String> pieceTokens = initPieceTokens();
    private static final Set<String> colorTokens = initColorTokens();
    
    private Scanner scanner;
    private ChessBoard board;
    

    public BoardScanner(String pathToFile) {
        
        try {
            File fileToScan = new File(pathToFile);
            this.scanner = new Scanner(fileToScan);
            
            this.board = new ChessBoard(BOARD_SIZE, BOARD_SIZE);
            
            PiecesCreator creator = new PiecesCreator();
            
            int row = 0;
            while(scanner.hasNextLine() && row < BOARD_SIZE) {
                
                String[] tokens = scanner.nextLine().split(" ");
                
                if(tokens.length % BOARD_SIZE != 0) {
                    System.err.println("Niepoprawny format pliku");
                    return;
                }
                
                int col = 0;
                for(int i = 0; i < tokens.length;) {
                    if(isColorToken(tokens[i])) {
                        String color = tokens[i];
                        i++;
                        if(isPieceToken(tokens[i])) {
                            String name = tokens[i];
                            i++;
                            
                            Piece piece = creator.create(name, color); 
                            board.addPiece(new ChessCoordinates(col, row), piece);
                            col++;
                        }
                    } else {
                        if(isPieceToken(tokens[i])) {
                            i++;
                            Piece piece = new NoPiece();
                            board.addPiece(new ChessCoordinates(col, row), piece);
                            col++;
                        }
                    }
                }
                row++;
            }
            
            
        } catch (FileNotFoundException ex) {
            
            //TODO stosowny komunikat dla GUI
            System.err.println("Nie odnaleziono pliku: " + pathToFile);
            
        }
    }

    
    private boolean isPieceToken(String token) {
        return pieceTokens.contains(token.toLowerCase());
    }
    
    static private Set<String> initPieceTokens() {
        Set<String> tokens = new HashSet<>();
        tokens.add("rook");
        tokens.add("knight");
        tokens.add("bishop");
        tokens.add("king");
        tokens.add("queen");
        tokens.add("pawn");
        tokens.add("empty");
        
        return tokens;
    }
      
    private boolean isColorToken(String token) {
        return colorTokens.contains(token.toLowerCase());
    }  
    
    static private Set<String> initColorTokens() {
        Set<String> tokens = new HashSet<>();
        tokens.add("white");
        tokens.add("black");
        
        return tokens;
    }

    public ChessBoard getBoard() {
        return board;
    }

}
