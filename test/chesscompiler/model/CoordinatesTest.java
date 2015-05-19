package chesscompiler.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wit
 */
public class CoordinatesTest {

    public CoordinatesTest() {
    }

    /**
     * Test of toIntArray method, of class Coordinates.
     */
    @Test
    public void testToIntArray() {
        String coordinates = "A8";
        int[] expResult = {0, 0};
        int[] result = Coordinates.toIntArray(coordinates);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of fromArray method, of class Coordinates.
     */
    @Test
    public void testFromArray() {
        int[] coordinates = {7, 7};
        String result = Coordinates.fromArray(coordinates);
        assertEquals("H1", result);
    }

}
