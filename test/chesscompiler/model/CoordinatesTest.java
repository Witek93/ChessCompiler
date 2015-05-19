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

    @Test
    public void testToIntArray() {
        String coordinates = "A8";
        int[] expResult = {0, 0};
        int[] result = Coordinates.toIntArray(coordinates);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testFromArray() {
        int[] coordinates = {7, 7};
        String result = Coordinates.fromArray(coordinates);
        assertEquals("H1", result);
    }

    @Test
    public void testUp() {
        String coordinates = "A1";
        String expResult = "A2";
        String result = Coordinates.up(coordinates);
        assertEquals(expResult, result);
    }

    @Test
    public void testDown() {
        String coordinates = "A2";
        String expResult = "A1";
        String result = Coordinates.down(coordinates);
        assertEquals(expResult, result);
    }

    @Test
    public void testLeft() {
        String coordinates = "B1";
        String expResult = "A1";
        String result = Coordinates.left(coordinates);
        assertEquals(expResult, result);
    }

    @Test
    public void testRight() {
        String coordinates = "A1";
        String expResult = "B1";
        String result = Coordinates.right(coordinates);
        assertEquals(expResult, result);
    }

}
