import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionValidatorTest {

    @Test
    public void testPassSimple() {
        String input = "25+61=86";
        assertEquals("PASS", ExpressionValidator.getResult(input));
    }

    @Test
    public void testPassLargeNumbers() {
        String input = "12345+12345=24690";
        assertEquals("PASS", ExpressionValidator.getResult(input));
    }

    @Test
    public void testErrorSyntax() {
        String input = "5++5=10";
        assertEquals("ERROR", ExpressionValidator.getResult(input));
    }

    @Test
    public void testFailWrongSum() {
        String input = "10000+1=10002";
        assertEquals("FAIL", ExpressionValidator.getResult(input));
    }
}
