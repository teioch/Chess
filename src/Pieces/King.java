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
        if(this.getColor() == Color.BLACK){
            this.setIcon("B.K");
        }
        else{
            this.setIcon("W.K");
        }
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

    public void setStartingPosition(){
        this.setyAxis(4);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }
}
