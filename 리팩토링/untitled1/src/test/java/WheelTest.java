import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class WheelTest {

    @Test
    void getPrice() {
        List<StringBuilder> strs = new ArrayList<>();
        strs.add(new StringBuilder("BUILDLEV"));
        strs.add(new StringBuilder("EATREALROBOT"));
        String userdata = "ERABCDFGHIJKLMNOPQSTUVWXYZ";
        Wheel app = new Wheel();
        int expected = 6500;

        int actual = app.getPrice(strs, userdata);

        assertEquals(expected, actual);

    }

    @Test
    void getPrice2() {
        List<StringBuilder> strs = new ArrayList<>();
        strs.add(new StringBuilder("ABS"));
        strs.add(new StringBuilder("ABS"));
        strs.add(new StringBuilder("AAAAAKBA"));
        String userdata = "XASBKQDJHMNPTLVUCGEWFORIYZ";
        Wheel app = new Wheel();
        int expected = 9500;

        int actual = app.getPrice(strs, userdata);

        assertEquals(expected, actual);

    }
}