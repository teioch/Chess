package Pieces;

import Game.Color;
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
    }

    public boolean isValidMove(int x, int y){

        if((Math.abs(this.getyAxis() - y) > 1 ) ||
                (Math.abs(this.getxAxis() - x) > 1 )){
            return false;
        }
        else if(!this.getHasMoved()){

            switch(this.getColor()){
                case BLACK:
                    if((x == 7 || x==1) && y == 8){
                        return true;
                    }
                case WHITE:
                    if((x == 7 || x==1) && y == 1){
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