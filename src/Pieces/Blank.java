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
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public class Blank extends Piece{

    public Blank(Color color){
        this.setColor(color);
        this.setType(Type.BLANK);
        this.setIcon("   ");
    }

    public boolean isValidMove(Coordinate target, Board board){
        return false;
    }
}
