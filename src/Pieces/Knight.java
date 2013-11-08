package Pieces;

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
    }

    public boolean isValidMove(int x, int y){
        int horizontalSteps = Math.abs(this.getxAxis()-x);
        int verticalSteps = Math.abs(this.getyAxis()-y);

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

    public void setStartingPositionOne(){
        this.setxAxis(1);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }

    public void startingPositionTwo(){
        this.setxAxis(6);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }
}
