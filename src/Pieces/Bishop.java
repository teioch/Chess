package Pieces;

import Game.Board;
import Game.Coordinate;
import Game.Movement;
import Game.Piece;
import Game.Color;
import Game.Type;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/8/13
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public class Bishop extends Piece{
    public Bishop(Color color){
        this.setColor(color);
        this.setType(Type.BISHOP);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♗");
        }
        else{
            this.setIcon("W:♗");
        }
    }

    public boolean isValidMove(Coordinate target, Board board){
        if(Movement.isDiagonal(this, target)){
            return true;
        }
        else{
            return false;
        }
    }
}
