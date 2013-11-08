package Pieces;

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
    }

    public boolean isValidMove(int x, int y){
        if(Movement.isDiagonal(this, x, y)){
            return true;
        }
        else{
            return false;
        }
    }
}
