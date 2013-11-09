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
public class Rook extends Piece{
    public Rook(Color color){
        this.setColor(color);
        this.setType(Type.ROOK);
        if(this.getColor() == Color.BLACK){
            this.setIcon("B.T");
        }
        else{
            this.setIcon("W.T");
        }
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

    public void setStartingPositionOne(){
        this.setxAxis(0);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }

    public void startingPositionTwo(){
        this.setxAxis(7);
        if(this.getColor() == Color.BLACK){
            this.setyAxis(7);
        }
        else{
            this.setyAxis(0);
        }
    }
}
