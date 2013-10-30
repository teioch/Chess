/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class Piece {
    private Color color;
    private Type type;
    private int xAxis;
    private int yAxis;

    public Piece(Color color, Type type){
        this.color = color;
        this.type = type;
    }

    public Color getColor(){
        return color;
    }

    public Type getType(){
        return type;
    }

    public int getxAxis(){
        return xAxis;
    }

    public int getyAxis(){
        return yAxis;
    }

    public void setxAxis(int xAxis){
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis){
        this.yAxis = yAxis;
    }
}
