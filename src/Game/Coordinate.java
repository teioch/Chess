package Game;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/22/13
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public class Coordinate {
    private String alfa;
    private int digit;

    public Coordinate(BufferedReader input) throws IOException {
        String coords = input.readLine();
        alfa = (""+coords.charAt(0)).toUpperCase();
        digit = Integer.parseInt(""+coords.charAt(1))-1;
    }

    public Coordinate(int x, int y){
        alfa = getNumericToAlfa(x).toUpperCase();
        digit = y;
    }

    public String getAlfa(){
        return alfa;
    }

    public void setAlfa(String alfa){
        this.alfa = alfa;
    }

    public int getDigit(){
        return digit;
    }

    public void setDigit(int digit){
        this.digit = digit;
    }

    public void setNewCoordinate(Coordinate newCoordinate){
        this.alfa = newCoordinate.getAlfa();
        this.digit = newCoordinate.getDigit();
    }

    public int getAlfaToNumeric(){
        switch(alfa.charAt(0)){
            case('A'):
                return 0;
            case('B'):
                return 1;
            case('C'):
                return 2;
            case('D'):
                return 3;
            case('E'):
                return 4;
            case('F'):
                return 5;
            case('G'):
                return 6;
            case('H'):
                return 7;
            default:
                return -1;
        }
    }

    public String getNumericToAlfa(int numeric){
        switch(numeric){
            case(0):
                return "A";
            case(1):
                return "B";
            case(2):
                return "C";
            case(3):
                return "D";
            case(4):
                return "E";
            case(5):
                return "F";
            case(6):
                return "G";
            case(7):
                return "H";
            default:
                return "X";
        }
    }

    public String toString(){
        return "" + alfa + (digit+1);
    }
}
