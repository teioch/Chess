package Pieces;

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
    }

    public boolean isValidMove(int x, int y){
        if(Movement.isVertical(this, x, y) || Movement.isHorizontal(this, x, y) || Movement.isDiagonal(this, x, y)){
            return true;
        }
        else{
            return false;
        }
    }

    public void setStartingPosition(){
        this.setxAxis(3);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }
}
