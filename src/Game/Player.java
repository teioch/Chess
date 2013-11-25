package Game;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/9/13
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;
    private Color color;
    private boolean hasSelectedPiece;
    private boolean hasDefinedLegalMove;

    public Player(BufferedReader input, Color color) throws IOException {
        System.out.println("Enter name: ");
        name = input.readLine();
        hasSelectedPiece = false;
        this.color = color;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setHasSelectedPiece(boolean status){
        this.hasSelectedPiece = status;
    }

    public boolean getHasSelectedPiece(){
        return hasSelectedPiece;
    }

    public void setHasDefinedLegalMove(boolean status){
        this.hasDefinedLegalMove = status;
    }

    public boolean getHasDefinedLegalMove(){
        return hasDefinedLegalMove;
    }
}
