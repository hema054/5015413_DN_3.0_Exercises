public class Logger {
    // Creating a private static instance of the Logger class
    private static Logger instance;

    // Ensuring the constructor of Logger is private
    private Logger() {
        // Private constructor to prevent instantiation
    }

    // Providing a public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A method to print messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
