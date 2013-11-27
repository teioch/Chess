package Game;

import Pieces.Blank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public static void main(String[] args) throws IOException{
        Board board = new Board();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Piece selectedPiece = new Blank(Color.BLANK);
        Player playerWhite = new Player(input, Color.WHITE);
        Player playerBlack = new Player(input, Color.BLACK);
        List<Player> players = new ArrayList<Player>();
        players.add(playerWhite);
        players.add(playerBlack);
        boolean gameOver = false;
        boolean roundComplete = false;

        while(!gameOver){
            for(Player player: players){
                System.out.println("Before while: " + ((!player.hasSelectedPiece()) && (!player.hasDefinedLegalMove())));
                while(!roundComplete){
                    board.printBoard();
                    selectedPiece = board.selectPiece(input, player);
                    if(selectedPiece.getColor() == player.getColor()){
                        System.out.println("Selected piece is the correct color");
                        if(board.selectDestination(input, selectedPiece)){
                            System.out.println("Attempted move is legal");
                            player.setHasDefinedLegalMove(true);
                        }
                    }
                    if(player.hasSelectedPiece() && player.hasDefinedLegalMove()){
                        break;
                    }
                }

                resetPlayerStatus(player);

                //check: do any of the possible moves for the recently moved piece result in check or check mate?
                //next player turn
            }
        }
    }

    private static void resetPlayerStatus(Player player) {
        player.setHasSelectedPiece(false);
        player.setHasDefinedLegalMove(false);
    }






}
