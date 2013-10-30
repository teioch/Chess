import org.junit.Test;

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
    public void shouldBeLegal(){
        Piece piece = new Piece(Color.BLACK, Type.KING);
        Movement movement = new Movement();
        piece.setxAxis(3);
        piece.setyAxis(5);

        //New location
        int x = 6;
        int y = 2;

        assertTrue(movement.isLegal(piece, x, y));
    }
}
