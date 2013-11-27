package Game;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Movement {

    public static boolean isHorizontal(Piece piece, Coordinate target){
        if(piece.getCoordinate().getYCoordinate() == target.getYCoordinate()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isVertical(Piece piece, Coordinate target){
        if(piece.getCoordinate().getXCoordinate() == target.getXCoordinate()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isDiagonal(Piece piece, Coordinate target){
        int diffX = Math.abs(piece.getCoordinate().getXCoordinate() - target.getXCoordinate());
        int diffY = Math.abs(piece.getCoordinate().getYCoordinate() - target.getYCoordinate());
        if(diffX == diffY){
            return true;
        }
        return false;
    }
}
