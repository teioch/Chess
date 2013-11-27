package Pieces;

import Game.Board;
import Game.Color;
import Game.Coordinate;
import Game.Movement;
import Game.Type;
import Game.Piece;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/8/13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class Pawn extends Piece{

    public Pawn(Color color){
        this.setColor(color);
        this.setType(Type.PAWN);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♙");
        }
        else{
            this.setIcon("W:♙");
        }
    }

    public boolean isValidMove(Coordinate target, Board board){
        int x = target.getXCoordinate();
        int y = target.getYCoordinate();

        if(board.getPieceAt(x,y).getType() == Type.BLANK){
            if(Movement.isVertical(this, target)){
                if(Math.abs(this.getCoordinate().getYCoordinate() - target.getYCoordinate()) == 1){
                    return true;
                }
                else if((Math.abs(this.getCoordinate().getYCoordinate() - target.getYCoordinate()) == 2) && (!this.getHasMoved())){
                    return true;
                }
            }
        }
        else{
            if(board.getPieceAt(x,y).getColor() != this.getColor()){
                if(Movement.isDiagonal(this, target)){
                    int diffX = Math.abs(this.getCoordinate().getXCoordinate() - target.getXCoordinate());
                    int diffY = this.getCoordinate().getYCoordinate() - target.getYCoordinate();

                    if(this.getColor() == Color.WHITE){
                        if(diffY == 1 && diffX == 1){
                            return true;
                        }
                    }
                    else {
                        if(diffY == -1 && diffX == 1){
                            return true;
                        }
                    }
                }
                else{
                    System.out.println("Pawn cannot assault this way. Movement is not diagonal");
                }
            }
        }
        System.out.println("Illegal pawn movement");
        return false;
    }
}
