import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        
        // Assert that 2 + 3 equals 5
        assertEquals(5, calculator.add(2, 3));
    }
}