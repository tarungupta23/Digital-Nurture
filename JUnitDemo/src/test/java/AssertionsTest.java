import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest { 

    @Test 
    public void testAssertions() { 
        // Assert equals: 2 + 3 should equal 5
        assertEquals(5, 2 + 3); 
 
        // Assert true: 5 is greater than 3, so this passes
        assertTrue(5 > 3); 
 
        // Assert false: 5 is NOT less than 3, so this passes
        assertFalse(5 < 3); 
 
        // Assert null: The value is null, so this passes
        assertNull(null); 
 
        // Assert not null: A new Object is created, so it's not null; passes
        assertNotNull(new Object()); 
    } 
}