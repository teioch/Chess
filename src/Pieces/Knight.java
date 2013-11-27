package Pieces;

import Game.Board;
import Game.Coordinate;
import Game.Piece;
import Game.Color;
import Game.Type;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/8/13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class Knight extends Piece{

    public Knight(Color color){
        this.setColor(color);
        this.setType(Type.KNIGHT);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♘");
        }
        else{
            this.setIcon("W:♘");
        }
    }

    public boolean isValidMove(Coordinate target, Board board){
        int horizontalSteps = Math.abs(this.getCoordinate().getXCoordinate() - target.getXCoordinate());
        int verticalSteps = Math.abs(this.getCoordinate().getYCoordinate() - target.getYCoordinate());

        if(horizontalSteps == 2 && verticalSteps == 1){
            return true;
        }
        else if(horizontalSteps == 1 && verticalSteps == 2){
            return true;
        }
        else{
            return false;
        }
    }
}
