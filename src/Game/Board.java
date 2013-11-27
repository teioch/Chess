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
        boolean noPieceSelected = true;

        do{
            System.out.println(player.getColor() + ": Input coordinates for piece selection: ");
            Coordinate coord = new Coordinate(input);

            selectedPiece = this.getPieceAt(coord.getXCoordinate(), coord.getYCoordinate());
            System.out.println("Selected piece type: " + selectedPiece.getType() + ", piece color: " + selectedPiece.getColor());

            if(selectedPiece.getColor() == player.getColor()){
                player.setHasSelectedPiece(true);
                return selectedPiece;
            }
            else{
                System.out.println("Not a legal selection. Please select different piece.");
            }
        }while(noPieceSelected);

        return new Blank(Color.BLANK);
    }

    public boolean selectDestination(BufferedReader input, Piece selectedPiece) throws IOException {
        System.out.println("Currently selected piece coordinates is " + selectedPiece.getCoordinate().toString());
        System.out.println("Input coordinates for destination: ");
        Coordinate coord = new Coordinate(input);
        int x = coord.getXCoordinate();
        int y = coord.getYCoordinate();

        if(selectedPiece.isValidMove(coord, this)){
            if(!pathIsBlocked(selectedPiece, new Coordinate(x,y))){
                System.out.println("Move is legal and path is clear.");
                if(movePiece(selectedPiece, new Coordinate(x,y))){
                    selectedPiece.setCoordinate(new Coordinate(x, y));
                    System.out.println("Coordinates accepted. Piece moved.");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean movePiece(Piece piece, Coordinate target){
        Coordinate prevCoord = piece.getCoordinate();
        int y = target.getYCoordinate();
        int x = target.getXCoordinate();
        if(board[y][x].getColor() != piece.getColor()){
            board[y][x] = piece;
            board[prevCoord.getYCoordinate()][prevCoord.getXCoordinate()] = new Blank(Color.BLANK);
            return true;
        }
        System.out.println("You cannot move your piece to a location already beset by your own piece");
        return false;
    }

    public boolean pathIsBlocked(Piece piece, Coordinate target){
        if(piece.getType() == Type.KNIGHT){
            return false;
        }
        else if(Movement.isDiagonal(piece, target)){
            System.out.println("Movement confirmed diagonal");
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
            if (verticalIsBlocked(piece, target)){
                return true;
            }
        }
        return false;
    }

    private boolean horizontalIsBlocked(Piece piece, Coordinate target) {
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());
        if(piece.getCoordinate().getXCoordinate() < target.getXCoordinate()){
            for(int i = piece.getCoordinate().getXCoordinate() + 1; i <= target.getXCoordinate(); i++){
                if (this.getPieceAt(i, target.getYCoordinate()).getColor() != Color.BLANK){
                    if(i == target.getXCoordinate() && (piece.isOpponentTo(targetPiece))){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        else if(piece.getCoordinate().getXCoordinate() > target.getXCoordinate()){
            for(int i = piece.getCoordinate().getXCoordinate() - 1; i >= target.getXCoordinate(); i--){
                if (this.getPieceAt(i, target.getYCoordinate()).getColor() != Color.BLANK){
                    if(i == target.getXCoordinate() && (piece.isOpponentTo(targetPiece))){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verticalIsBlocked(Piece piece, Coordinate target) {
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());

        if(piece.getCoordinate().getYCoordinate() < target.getYCoordinate()){
            for(int i = piece.getCoordinate().getYCoordinate() + 1; i <= target.getYCoordinate(); i++){
                if (this.getPieceAt(target.getXCoordinate(), i).getColor() != Color.BLANK){
                    if(i == target.getYCoordinate() && (piece.isOpponentTo(targetPiece))){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        else if(piece.getCoordinate().getYCoordinate() > target.getYCoordinate()){
            for(int i = piece.getCoordinate().getYCoordinate() - 1; i >= target.getYCoordinate(); i--){
                if (this.getPieceAt(target.getXCoordinate(), i).getColor() != Color.BLANK){
                    if(i == target.getYCoordinate() && (piece.isOpponentTo(targetPiece))){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean diagonalIsBlocked(Piece piece, Coordinate target) {
        int pieceX = piece.getCoordinate().getXCoordinate();
        int pieceY = piece.getCoordinate().getYCoordinate();

        if(pieceX < target.getXCoordinate()){
            if(pieceY < target.getYCoordinate()){
                System.out.println("South east blocked");
                return isSouthEastBlocked(piece, target);
            }
            else{
                System.out.println("North east blocked");
                return isNorthEastBlocked(piece, target);
            }
        }
        else{
            if(pieceY < target.getYCoordinate()){
                System.out.println("South west blocked");
                return isSouthWestBlocked(piece, target);
            }
            else{
                System.out.println("North west blocked");
                return isNorthWestBlocked(piece, target);
            }
        }
    }

    private boolean isNorthEastBlocked(Piece piece, Coordinate target){
        boolean boardEdgeBreached = false;
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());

        for(int i = 1; !boardEdgeBreached; i++){
            int pieceX = piece.getCoordinate().getXCoordinate();
            int pieceY = piece.getCoordinate().getYCoordinate();

            if((pieceX + i) >= AXIS || (pieceY - i) <= 0){
                //Edge of board breached
                break;
            }

            Piece nextPiece = getPieceAt((pieceX + i),(pieceY - i));

            if(nextPiece.getType() != Type.BLANK){
                if(nextPiece == targetPiece && piece.isOpponentTo(targetPiece)){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSouthEastBlocked(Piece piece, Coordinate target){
        boolean boardEdgeBreached = false;
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());

        for(int i = 1; !boardEdgeBreached; i++){
            int pieceX = piece.getCoordinate().getXCoordinate();
            int pieceY = piece.getCoordinate().getYCoordinate();

            if((pieceX + i) >= AXIS || (pieceY + i) >= AXIS){
                //Edge of board breached
                break;
            }

            Piece nextPiece = getPieceAt((pieceX + i),(pieceY + i));

            if(nextPiece.getType() != Type.BLANK){
                if(nextPiece == targetPiece && piece.isOpponentTo(targetPiece)){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSouthWestBlocked(Piece piece, Coordinate target){
        boolean boardEdgeBreached = false;
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());

        for(int i = 1; !boardEdgeBreached; i++){
            int pieceX = piece.getCoordinate().getXCoordinate();
            int pieceY = piece.getCoordinate().getYCoordinate();

            if((pieceX - i) <= 0 || (pieceY + i) >= AXIS){
                //Edge of board breached
                break;
            }

            Piece nextPiece = getPieceAt((pieceX - i),(pieceY + i));

            if(nextPiece.getType() != Type.BLANK){
                if(nextPiece == targetPiece && piece.isOpponentTo(targetPiece)){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNorthWestBlocked(Piece piece, Coordinate target){
        boolean boardEdgeBreached = false;
        Piece targetPiece = this.getPieceAt(target.getXCoordinate(), target.getYCoordinate());

        for(int i = 1; !boardEdgeBreached; i++){
            int pieceX = piece.getCoordinate().getXCoordinate();
            int pieceY = piece.getCoordinate().getYCoordinate();

            if((pieceX - i) <= 0 || (pieceY - i) <= 0){
                //Edge of board breached
                break;
            }

            Piece nextPiece = getPieceAt((pieceX - i),(pieceY + i));

            if(nextPiece.getType() != Type.BLANK){
                if(nextPiece == targetPiece && piece.isOpponentTo(targetPiece)){
                    return false;
                }
                else{
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
