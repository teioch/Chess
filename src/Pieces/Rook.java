package Pieces;

import Game.Coordinate;
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
public class Rook extends Piece{

    public Rook(Color color){
        this.setColor(color);
        this.setType(Type.ROOK);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♖");
        }
        else{
            this.setIcon("W:♖");
        }
    }

    public boolean isValidMove(Coordinate target){
        if(Movement.isVertical(this, target) && !Movement.isHorizontal(this, target)){
            return true;
        }
        else if(!Movement.isVertical(this, target) && Movement.isHorizontal(this, target)){
            return true;
        }
        else{
            return true;
        }
    }
}
