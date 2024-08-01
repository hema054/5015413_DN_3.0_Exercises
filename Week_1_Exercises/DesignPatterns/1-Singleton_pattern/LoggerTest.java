public class LoggerTest {
    public static void main(String[] args) {
        /*Get the single instance of Logger--> singleton ->
         where only one instance is created even when n number of objects is created for a class*/

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verifying that logger1 and logger2 are the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
