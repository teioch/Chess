package Game;

import Pieces.Bishop;
import Pieces.Blank;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Queen;
import Pieces.Rook;

import java.io.BufferedReader;
import java.io.IOException;

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
        setWhitePieces();
        setBlackPieces();
        setRestOfBoard();
    }

    private void setBlackPieces() {
        board[0][0] = new Rook(Color.BLACK);
        board[0][1] = new Knight(Color.BLACK);
        board[0][2] = new Bishop(Color.BLACK);
        board[0][3] = new Queen(Color.BLACK);
        board[0][4] = new King(Color.BLACK);
        board[0][5] = new Bishop(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[0][7] = new Rook(Color.BLACK);
        for (int i = 0; i < 8; i++){
            board[1][i] = new Pawn(Color.BLACK);
            board[1][i].setCoordinate(new Coordinate(i, 1));
        }

        for(int i = 0; i < 8; i++){
            board[0][i].setCoordinate(new Coordinate(i, 0));
        }
    }

    private void setWhitePieces() {
        board[7][0] = new Rook(Color.WHITE);
        board[7][1] = new Knight(Color.WHITE);
        board[7][2] = new Bishop(Color.WHITE);
        board[7][3] = new Queen(Color.WHITE);
        board[7][4] = new King(Color.WHITE);
        board[7][5] = new Bishop(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);
        for (int i = 0; i < 8; i++){
            board[6][i] = new Pawn(Color.WHITE);
            board[6][i].setCoordinate(new Coordinate(i, 6));
        }

        for(int i = 0; i < 8; i++){
            board[7][i].setCoordinate(new Coordinate(i, 7));
        }
    }

    public void setRestOfBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 2; j < board[0].length-2; j++){
                board[j][i] = new Blank(Color.BLANK);
            }
        }
    }

    public Piece getPieceAt(int x, int y){
        return board[y][x];
    }

    public Piece selectPiece(BufferedReader input, Player player) throws IOException {
        Piece selectedPiece;
        System.out.println("Input coordinates for piece selection: ");
        Coordinate coord = new Coordinate(input);
        selectedPiece = this.getPieceAt(coord.getAlfaToNumeric(), coord.getDigit());
        System.out.println("Selected piece type: " + selectedPiece.getType() + ", piece color: " + selectedPiece.getColor());

        if(selectedPiece.getType() != Type.BLANK){
            if(selectedPiece.getColor() == player.getColor()){
                player.setHasSelectedPiece(true);
            }
        }
        return selectedPiece;
    }

    public boolean selectDestination(BufferedReader input, Piece selectedPiece, Player player) throws IOException {
        System.out.println("Currently selected piece coordinates is " + selectedPiece.getCoordinate().toString());
        System.out.println("Input coordinates for destination: ");
        Coordinate coord = new Coordinate(input);
        int x = coord.getAlfaToNumeric();
        int y = coord.getDigit();

        if(selectedPiece.isValidMove(coord)){
            if(selectedPiece.getType() == Type.KNIGHT){
                if(movePiece(selectedPiece, new Coordinate(x,y))){
                    selectedPiece.setCoordinate(new Coordinate(x, y));
                    System.out.println("Coordinates accepted. Piece moved.");
                    player.setHasDefinedLegalMove(true);
                    return true;
                }
            }
            else{
                if(!pathIsBlocked(selectedPiece, new Coordinate(x,y))){
                    if(movePiece(selectedPiece, new Coordinate(x,y))){
                        selectedPiece.setCoordinate(new Coordinate(x, y));
                        System.out.println("Coordinates accepted. Piece moved.");
                        player.setHasDefinedLegalMove(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean movePiece(Piece piece, Coordinate target){
        Coordinate prevCoord = piece.getCoordinate();
        int y = target.getDigit();
        int x = target.getAlfaToNumeric();
        if(board[y][x].getColor() != piece.getColor()){
            board[y][x] = piece;
            board[prevCoord.getDigit()][prevCoord.getAlfaToNumeric()] = new Blank(Color.BLANK);
            return true;
        }
        System.out.println("You cannot move your piece to a location already beset by your own piece");
        return false;
    }

    public boolean pathIsBlocked(Piece piece, Coordinate target){
        if(Movement.isDiagonal(piece, target)){
            if (diagonalIsBlocked(piece, target)){
                return true;
            }
        }
        else if(Movement.isHorizontal(piece, target)){
            if (horizontalIsBlocked(piece, target)){
                return true;
            }
        }
        else if(Movement.isVertical(piece, target)){
            if (verticalIsBlocked(piece, target)) return true;
        }
        return false;
    }

    private boolean horizontalIsBlocked(Piece piece, Coordinate target) {
        if(piece.getCoordinate().getDigit() < target.getDigit()){
            for(int i = piece.getCoordinate().getDigit(); i <= target.getDigit(); i++){
                if (this.getPieceAt(target.getAlfaToNumeric(), i).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        else if(piece.getCoordinate().getDigit() > target.getDigit()){
            for(int i = piece.getCoordinate().getDigit(); i >= target.getDigit(); i--){
                if (this.getPieceAt(target.getAlfaToNumeric(), i).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verticalIsBlocked(Piece piece, Coordinate target) {
        if(piece.getCoordinate().getAlfaToNumeric() < target.getAlfaToNumeric()){
            for(int i = piece.getCoordinate().getAlfaToNumeric(); i <= target.getAlfaToNumeric(); i++){
                if (this.getPieceAt(i, target.getDigit()).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        else if(piece.getCoordinate().getAlfaToNumeric() > target.getAlfaToNumeric()){
            for(int i = piece.getCoordinate().getAlfaToNumeric(); i >= target.getAlfaToNumeric(); i--){
                if (this.getPieceAt(i, target.getDigit()).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalIsBlocked(Piece piece, Coordinate target) {
        if(piece.getCoordinate().getAlfaToNumeric() < target.getAlfaToNumeric()){
            for(int i = 1; piece.getCoordinate().getAlfaToNumeric()+i <= target.getAlfaToNumeric(); i++){
                int tempX = piece.getCoordinate().getAlfaToNumeric();
                int tempY = piece.getCoordinate().getAlfaToNumeric();

                if(this.getPieceAt(tempX + i, tempY + i).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        else if(piece.getCoordinate().getAlfaToNumeric() > target.getAlfaToNumeric()){
            for(int i = -1; piece.getCoordinate().getAlfaToNumeric()+i >= target.getAlfaToNumeric(); i--){
                int tempX = piece.getCoordinate().getAlfaToNumeric();
                int tempY = piece.getCoordinate().getAlfaToNumeric();

                if(this.getPieceAt(tempX+i, tempY+i).getType() != Type.BLANK){
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard(){
        System.out.println(" ");
        System.out.println("  |  A  |  B  |  C  |  D  |  E  |  F  |  G  |  H  |");
        System.out.println("---------------------------------------------------");
        for(int i = 0; i < board.length; i++){
            System.out.print(i + 1 + " ");
            System.out.print("|");
            for(int j = 0; j < board[0].length; j++){
                System.out.print(" " + board[i][j].getIcon() + " |");
            }
            System.out.println("\n---------------------------------------------------");
        }
    }
}
