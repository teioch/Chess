package Game;

import Pieces.King;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/7/13
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class PieceTest {

    @Test
    public void shouldHaveMoved(){
        King piece = new King(Color.WHITE);
        assertFalse(piece.getHasMoved());
    }
}
