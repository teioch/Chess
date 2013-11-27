package Game;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class Piece{
    private Color color;
    private Type type;
    private String icon;
    private Coordinate coordinate;
    private boolean hasMoved;

    public Piece(){

    }

    public Piece (Color color, Type type){
        this.color = color;
        this.type = type;
        this.hasMoved = false;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getIcon(){
        return icon;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public boolean isOpponentTo(Piece target){
        if(target.getColor() == Color.BLANK){
            return false;
        }
        else if(this.getColor() != target.getColor()){
            return true;
        }
        else{
            return false;
        }
    }

    public abstract boolean isValidMove(Coordinate target, Board board);
}
