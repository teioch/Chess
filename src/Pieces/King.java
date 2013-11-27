package Pieces;

import Game.Board;
import Game.Color;
import Game.Coordinate;
import Game.Piece;
import Game.Type;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/2/13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class King extends Piece{

    public King(Color color){
        this.setType(Type.KING);
        this.setColor(color);
        this.setHasMoved(false);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B:♔");
        }
        else{
            this.setIcon("W:♔");
        }
    }

    public boolean isValidMove(Coordinate target, Board board){

        if((Math.abs(this.getCoordinate().getYCoordinate() - target.getYCoordinate()) > 1 ) ||
                (Math.abs(this.getCoordinate().getXCoordinate() - target.getXCoordinate()) > 1 )){
            return false;
        }
        else if(!this.getHasMoved()){

            switch(this.getColor()){
                case BLACK:
                    if((target.getXCoordinate() == 7 ||
                            target.getXCoordinate() == 1) &&
                            target.getXCoordinate() == 8){
                        return true;
                    }
                case WHITE:
                    if((target.getXCoordinate() == 7 ||
                            target.getXCoordinate() == 1) &&
                            target.getXCoordinate() == 1){
                        return true;
                    }
                default:
                    //do nothing
                    break;
            }
        }
        return true;
    }
}
