package Pieces;

import Game.Movement;
import Game.Piece;
import Game.Color;
import Game.Type;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/8/13
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public class Tower extends Piece{
    public Tower(Color color){
        this.setColor(color);
        this.setType(Type.TOWER);
    }

    public boolean isValidMove(int x, int y){
        if(Movement.isVertical(this, x, y) && !Movement.isHorizontal(this, x, y)){
            return true;
        }
        else if(!Movement.isVertical(this, x, y) && Movement.isHorizontal(this, x, y)){
            return true;
        }
        else{
            return true;
        }
    }
}
