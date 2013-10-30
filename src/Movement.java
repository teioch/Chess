/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class Movement {

    public boolean isLegal(Piece piece, int x, int y){
        switch(piece.getType()){
            case KING:
                if(moveIsHorizontal(piece, x, y) && !moveIsVertical(piece, x, y)){
                    if(Math.abs(piece.getxAxis()-x) == 1){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else if(!moveIsHorizontal(piece, x, y) && moveIsVertical(piece, x, y)){
                    if(Math.abs(piece.getyAxis()-y) == 1){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return true;
                }
            case QUEEN:
                if(moveIsVertical(piece, x, y) || moveIsHorizontal(piece, x, y) || moveIsDiagonal(piece, x , y)){
                    return true;
                }
                else{
                    return false;
                }
            case BISHOP:
                if(moveIsDiagonal(piece, x, y)){
                    return true;
                }
                else{
                    return false;
                }
            case KNIGHT:
                int horizontalSteps = Math.abs(piece.getxAxis()-x);
                int verticalSteps = Math.abs(piece.getyAxis()-y);

                if(horizontalSteps == 2 && verticalSteps == 1){
                    return true;
                }
                else if(horizontalSteps == 1 && verticalSteps == 2){
                    return true;
                }
                else{
                    return false;
                }

            case TOWER:
                if(moveIsVertical(piece, x, y) && !moveIsHorizontal(piece, x, y)){
                    return true;
                }
                else if(!moveIsVertical(piece, x, y) && moveIsHorizontal(piece, x , y)){
                    return true;
                }
                else{
                    return true;
                }
            case PAWN:
                if(moveIsVertical(piece, x, y)){
                    if(Math.abs(piece.getxAxis()-x) == 1){
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public boolean moveIsHorizontal(Piece piece, int x, int y){
        if(piece.getxAxis() == x){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveIsVertical(Piece piece, int x, int y){
        if(piece.getyAxis() == y){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveIsDiagonal(Piece piece, int x, int y){
        int diffX = Math.abs(piece.getxAxis()-x);
        int diffY = Math.abs(piece.getyAxis()-y);
        if(diffX == diffY){
            return true;
        }
        return false;
    }
}
