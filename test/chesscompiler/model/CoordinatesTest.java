package chesscompiler.model;

import java.util.Arrays;
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

    @Test
    public void testGetValidMovesLeft() {
        String coordinates = "E5";
        Coordinates.Direction direction = Coordinates.Direction.LEFT;
        String[] expResult = {"A5", "B5", "C5", "D5"};

        String[] result = Coordinates.getValidMoves(coordinates, direction);

        Arrays.sort(expResult);
        Arrays.sort(result);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetValidMovesUp() {
        String coordinates = "E5";
        Coordinates.Direction direction = Coordinates.Direction.UP;
        String[] expResult = {"E1", "E2", "E3", "E4"};

        String[] result = Coordinates.getValidMoves(coordinates, direction);

        Arrays.sort(expResult);
        Arrays.sort(result);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetValidMovesRight() {
        String coordinates = "E5";
        Coordinates.Direction direction = Coordinates.Direction.RIGHT;
        String[] expResult = {"F5", "G5", "H5"};

        String[] result = Coordinates.getValidMoves(coordinates, direction);

        Arrays.sort(expResult);
        Arrays.sort(result);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetValidMovesDown() {
        String coordinates = "E5";
        Coordinates.Direction direction = Coordinates.Direction.DOWN;
        String[] expResult = {"E6", "E7", "E8"};

        String[] result = Coordinates.getValidMoves(coordinates, direction);

        Arrays.sort(expResult);
        Arrays.sort(result);
        assertArrayEquals(expResult, result);
    }

}
