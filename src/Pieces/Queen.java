package Pieces;

import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Type;
import Game.Movement;
import Game.Color;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/8/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class Queen extends Piece {

    public Queen(Color color){
        this.setColor(color);
        this.setType(Type.QUEEN);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♕");
        }
        else{
            this.setIcon("W:♕");
        }
    }

    public boolean isValidMove(Coordinate target, Board board){
        if(Movement.isVertical(this, target) || Movement.isHorizontal(this, target) || Movement.isDiagonal(this, target)){
            return true;
        }
        else{
            System.out.println("Movement failed. Could not move piece from " + getCoordinate().toString() + " to " + target.toString());
            return false;
        }
    }
}
