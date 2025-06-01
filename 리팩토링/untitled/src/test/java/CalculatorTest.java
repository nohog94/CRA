import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getsum() {
        //arrange
        Calculator cal = new Calculator();
        int expected = 3;

        //act
        int actual = cal.getsum(1,2);

        //assert
        assertEquals(expected, actual);


    }

    @BeforeEach
    void setUp() {
        System.out.println("hi");
    }

    @AfterEach
    void tearDown() {
        System.out.println("bye");
    }

    @Test
    @DisplayName("후후후")
    void name() {

    }
}