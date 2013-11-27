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
        Board board = new Board();
        Pieces.King piece = new King(Color.WHITE);
        piece.setCoordinate(new Coordinate(3, 5));

        //New location
        Coordinate target = new Coordinate(6,3);
        assertFalse(piece.isValidMove(target, board));

        target.setNewCoordinate(new Coordinate(3,3));
        assertFalse(piece.isValidMove(target, board));
    }

    @Test
    public void shouldBeLegalForKing(){
        Board board = new Board();
        King piece = new King(Color.BLACK);
        piece.setCoordinate(new Coordinate(3, 3));

        //New location
        Coordinate target = new Coordinate(4,3);
        assertTrue(piece.isValidMove(target, board));

        target.setNewCoordinate(new Coordinate(3,4));
        assertTrue(piece.isValidMove(target, board));

        target.setNewCoordinate(new Coordinate(4,4));
        assertTrue(piece.isValidMove(target, board));
    }

    @Test
    public void specialMoveForKingShouldBeLegal(){
        Board board = new Board();
        King piece = new King(Color.BLACK);
        piece.setCoordinate(new Coordinate(4, 1));

        //New location
        Coordinate target = new Coordinate(7,1);

        assertTrue(piece.isValidMove(target, board));
    }

    @Test
    public void shouldNotBeLegalForQueen(){
        Board board = new Board();
        Queen piece = new Queen(Color.BLACK);
        piece.setCoordinate(new Coordinate(3,3));

        //New location
        Coordinate target = new Coordinate(6,7);
        assertFalse(piece.isValidMove(target, board));
    }

    @Test
    public void shouldBeLegalForQueen(){
        Board board = new Board();
        Queen piece = new Queen(Color.BLACK);
        piece.setCoordinate(new Coordinate(3,3));

        //New location
        Coordinate target = new Coordinate(6,6);
        assertTrue(piece.isValidMove(target, board));

        target.setNewCoordinate(new Coordinate(6,3));
        assertTrue(piece.isValidMove(target, board));

        target.setNewCoordinate(new Coordinate(3,6));
        assertTrue(piece.isValidMove(target, board));
    }

    @Test
    public void shouldBeHorizontalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setCoordinate(new Coordinate(3,3));

        //New location
        Coordinate target = new Coordinate(4,3);

        assertTrue(Movement.isHorizontal(piece, target));
    }

    @Test
    public void shouldBeVerticalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setCoordinate(new Coordinate(3,3));

        //New location
        Coordinate target = new Coordinate(3,4);

        assertTrue(Movement.isVertical(piece, target));
    }

    @Test
    public void shouldBeDiagonalMove(){
        Queen piece = new Queen(Color.BLACK);
        piece.setCoordinate(new Coordinate(3,3));

        //New location
        Coordinate target = new Coordinate(4,4);

        assertTrue(Movement.isDiagonal(piece, target));
    }
}
