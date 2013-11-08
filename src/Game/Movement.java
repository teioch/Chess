package Game;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Movement {

    public static boolean isHorizontal(Piece piece, int x, int y){
        if(piece.getyAxis() == y){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isVertical(Piece piece, int x, int y){
        if(piece.getxAxis() == x){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isDiagonal(Piece piece, int x, int y){
        int diffX = Math.abs(piece.getxAxis() - x);
        int diffY = Math.abs(piece.getyAxis()-y);
        if(diffX == diffY){
            return true;
        }
        return false;
    }
}
