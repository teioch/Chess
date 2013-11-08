package Game;

import Pieces.Bishop;
import Pieces.Blank;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Tower;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private static final int AXIS = 8;
    private Piece[][] board = new Piece[AXIS][AXIS];

    public Board(){
        setBoardWithPiece(new Tower(Color.WHITE), 0, 7);
        setBoardWithPiece(new Knight(Color.WHITE), 1, 7);
        setBoardWithPiece(new Bishop(Color.WHITE), 2, 7);
        setBoardWithPiece(new Queen(Color.WHITE), 3, 7);
        setBoardWithPiece(new King(Color.WHITE), 4, 7);
        setBoardWithPiece(new Bishop(Color.WHITE), 5, 7);
        setBoardWithPiece(new Knight(Color.WHITE), 6, 7);
        setBoardWithPiece(new Tower(Color.WHITE), 7, 7);
        for (int i = 0; i < 8; i++){
            setBoardWithPiece(new Pawn(Color.WHITE), i, 6);
        }

        setBoardWithPiece(new Tower(Color.BLACK), 0, 0);
        setBoardWithPiece(new Knight(Color.BLACK), 1, 0);
        setBoardWithPiece(new Bishop(Color.BLACK), 2, 0);
        setBoardWithPiece(new Queen(Color.BLACK), 3, 0);
        setBoardWithPiece(new King(Color.BLACK), 4, 0);
        setBoardWithPiece(new Bishop(Color.BLACK), 5, 0);
        setBoardWithPiece(new Knight(Color.BLACK), 6, 0);
        setBoardWithPiece(new Tower(Color.BLACK), 7, 0);
        for (int i = 0; i < 8; i++){
            setBoardWithPiece(new Pawn(Color.BLACK), i, 1);
        }
        setRestOfBoard();
    }

    public void setBoardWithPiece(Piece piece, int y, int x){
        board[x][y] = piece;
    }

    public void setRestOfBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 2; j < board[0].length-2; j++){
                setBoardWithPiece(new Blank(Color.BLANK), i, j);
            }
        }
    }

    public void printBoard(){
        System.out.println("-------------------------------------------------");
        for(int i = 0; i < board.length; i++){
            System.out.print("|");
            for(int j = 0; j < board[0].length; j++){
                System.out.print(" " + board[i][j].getIcon() + " |");
            }
            System.out.println("\n-------------------------------------------------");
        }
    }
}
