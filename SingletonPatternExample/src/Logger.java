public class Logger {

    // 1. Private static instance of the class (initially null)
    private static Logger instance;

    // 2. Private constructor to prevent instantiation from other classes
    private Logger() {
        // Optional: Initialization code (e.g., opening a log file)
        System.out.println("Logger Instance Created.");
    }

    // 3. Public static method to provide the global point of access
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Created only when needed
        }
        return instance;
    }

    // A simple method to simulate logging functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}