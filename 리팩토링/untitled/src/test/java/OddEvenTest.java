import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenTest {

    @Test
    void testMixedNumbers() {
        OddEven oe = new OddEven();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 0));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("X", "O", "X", "O"));
        assertEquals(expected, oe.getResult(input));
    }

    @Test
    void testAllEven() {
        OddEven oe = new OddEven();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4, 6));
        assertNull(oe.getResult(input));
    }

    @Test
    void testAllOdd() {
        OddEven oe = new OddEven();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        assertNull(oe.getResult(input));
    }

    @Test
    void testEmptyList() {
        OddEven oe = new OddEven();
        ArrayList<Integer> input = new ArrayList<>();
        assertNull(oe.getResult(input));
    }

    @Test
    void testNullInput() {
        OddEven oe = new OddEven();
        assertNull(oe.getResult(null));
    }
}
