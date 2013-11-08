package Pieces;

import Game.Color;
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
    }

    public boolean isValidMove(int x, int y){
        if(Movement.isVertical(this, x, y)){
            if(Math.abs(this.getxAxis()-x) == 1){
                return true;
            }
            else if((Math.abs(this.getxAxis()-x) == 2) && (!this.getHasMoved())){
                return true;
            }
        }
        return false;
    }

    public void setStartingPosition(int x){
        this.setxAxis(x);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(6);
        }
        else{
            this.setyAxis(1);
        }
    }
}
