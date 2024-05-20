package WeekTwo.CreationalDesignPatterns;

public class Logger {
    // Private static instance variable to hold the single instance of Logger
    // marked as volatile for the case where a thread tries to access the instance when it hasn't been fully formed
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from outside the class
    private Logger() {
        // Constructor implementation
    }

    // Public static method to provide global access point to the Logger instance
    public static Logger getInstance() {
        Logger result = instance; // use local variable to prevent multiple direct reads to memory since instance is marked as volatile

        // double-checked locking idiom - only obtain access to logger class if it hasn't already been instantiated
        if (result == null) { // obtain lock to Logger class only if it hasn't been instantiated
            // improves performance by limiting synchronization to the rare case of new instantiation
            synchronized (Logger.class) {
                // Lazy initialization: create the instance only when it's accessed for the first time
                result = new Logger();
            }
        }
        return result;
    }

    // Public method to write log messages
    public void log(String message) {
        // Log message implementation
        System.out.println("[INFO] " + message);
    }

    // Other methods for logging errors, warnings, etc. can be added here
}

