public class SingletonTest {

    public static void main(String[] args) {
        // Try to get the Logger instance for the first time
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Try to get the Logger instance a second time
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verify that both variables point to the exact same memory instance
        System.out.println("\n--- Verification ---");
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 point to the same instance.");
            System.out.println("Logger1 HashCode: " + logger1.hashCode());
            System.out.println("Logger2 HashCode: " + logger2.hashCode());
        } else {
            System.out.println("Failure: Multiple instances exist!");
        }
    }
}