package Pieces;

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

    public boolean isValidMove(Coordinate target){
        if(Movement.isVertical(this, target)){
            if(Math.abs(this.getCoordinate().getDigit() - target.getDigit()) == 1){
                return true;
            }
            else if((Math.abs(this.getCoordinate().getDigit() - target.getDigit()) == 2) && (!this.getHasMoved())){
                return true;
            }
        }
        System.out.println("Target destination does not lead to a vertical move. Selected piece at " + getCoordinate().toString() + "cannot move to target at " + target.toString());
        return false;
    }
}
