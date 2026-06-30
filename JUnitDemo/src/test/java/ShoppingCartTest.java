import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    // This is our test fixture variable
    private ShoppingCart cart;

    // 1. Setup Method: Executes automatically before EACH test
    @Before
    public void setUp() {
        cart = new ShoppingCart();
        System.out.println("Setup completed: Fresh ShoppingCart created.");
    }

    // 2. Teardown Method: Executes automatically after EACH test
    @After
    public void tearDown() {
        cart.clear(); // Ensure clean slate
        System.out.println("Teardown completed: ShoppingCart cleared.");
    }

    @Test
    public void testAddItem() {
        // --- ARRANGE ---
        String item = "Laptop";

        // --- ACT ---
        cart.addItem(item);

        // --- ASSERT ---
        assertEquals("The cart should contain exactly 1 item.", 1, cart.getItemCount());
    }

    @Test
    public void testEmptyCartCount() {
        // --- ARRANGE ---
        // Setup is already handled globally by the @Before method

        // --- ACT ---
        int finalCount = cart.getItemCount();

        // --- ASSERT ---
        assertEquals("A new cart should be empty.", 0, finalCount);
    }
}