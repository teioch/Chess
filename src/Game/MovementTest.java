package Game;

import Pieces.King;
import Pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/30/13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public class MovementTest {

    @Test
    public void shouldNotBeLegalForKing(){
        Pieces.King piece = new King(Color.WHITE);

        piece.setxAxis(3);
        piece.setyAxis(5);

        //New location
        int x = 6;
        int y = 2;
        assertFalse(piece.isValidMove(x, y));
        x = 3;
        y = 3;
        assertFalse(piece.isValidMove(x, y));
    }

    @Test
    public void shouldBeLegalForKing(){
        King piece = new King(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 4;
        int y = 3;
        assertTrue(piece.isValidMove(x, y));
        x = 3;
        y = 4;
        assertTrue(piece.isValidMove(x, y));
        x = 4;
        y = 4;
        assertTrue(piece.isValidMove(x, y));
    }

    @Test
    public void specialMoveForKingShouldBeLegal(){
        King piece = new King(Color.BLACK);
        piece.setxAxis(4);
        piece.setyAxis(1);

        //New location
        int x = 7;
        int y = 1;

        assertTrue(piece.isValidMove(x, y));
    }

    @Test
    public void shouldNotBeLegalForQueen(){
        Queen piece = new Queen(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 6;
        int y = 7;
        assertFalse(piece.isValidMove(x,y));
    }

    @Test
    public void shouldBeLegalForQueen(){
        Queen piece = new Queen(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 6;
        int y = 6;
        assertTrue(piece.isValidMove(x, y));
        x = 6;
        y = 3;
        assertTrue(piece.isValidMove(x, y));
        x = 3;
        y = 6;
        assertTrue(piece.isValidMove(x, y));
    }

    @Test
    public void shouldBeHorizontalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 4;
        int y = 3;

        assertTrue(Movement.isHorizontal(piece, x, y));
    }

    @Test
    public void shouldBeVerticalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 3;
        int y = 4;

        assertTrue(Movement.isVertical(piece, x, y));
    }

    @Test
    public void shouldBeDiagonalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setxAxis(3);
        piece.setyAxis(3);

        //New location
        int x = 4;
        int y = 4;

        assertTrue(Movement.isDiagonal(piece, x, y));
    }
}
