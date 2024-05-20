import WeekTwo.CreationalDesignPatterns.Logger;

public class Main {
    public static void main(String[] args) {
        // Get the Logger instance
        Logger logger = Logger.getInstance();

        // Log messages using the Logger instance
        logger.log("This is a log message.");
        logger.log("Another log message.");
    }
}
