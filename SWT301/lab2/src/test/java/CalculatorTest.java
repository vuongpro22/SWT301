import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import binhvuong.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();
//    @Test
//    void testAddition() {
//        assertEquals(5, calculator.add(2, 3), "Addition should return 5");
//    }
//
//    @Test
//    void testDivide() {
//        assertEquals(2, calculator.divide(6, 3));
//    }
//
//    @Test
//    void testDivideByZero() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            calculator.divide(10, 0);
//        });
//
//        assertEquals("Cannot divide by zero", exception.getMessage());
//    }
//    @ParameterizedTest(name = "Test {index} => {0} * {1} = {2}")
//    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
//    void testMultiplyFromFile(int a, int b, int expected) {
//        int result = calculator.multiply(a, b);
//        assertEquals(expected, result, () -> a + " * " + b + " should be " + expected);
//    }
    static Calculator calculators;

    @BeforeAll
    static void initAll() {
        calculators = new Calculator();
    }

    @AfterAll
    static void cleanupAll() {
        calculators = null;
    }
    //Calculator calculator = new Calculator();
    @DisplayName("Kiểm tra phép cộng với hai số dương")
    @Test
    void testAdditions() {
        assertEquals(5, calculators.add(2, 3), "Addition should return 5");
    }


}


