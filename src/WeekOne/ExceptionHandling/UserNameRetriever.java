package WeekOne.ExceptionHandling;

public class UserNameRetriever {
    // Method to retrieve user's name from a user object
    public static String getUserName(User user) {
        try {
            return user.getName();
        } catch (NullPointerException e) {
            return "Unknown"; // Return a default value if user object is null
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        User user = null; // Simulating a null user object
        User user1 = new User("Kevin");

        // Attempt to retrieve user's name
        String userName = getUserName(user);
        System.out.println("User's name: " + userName);

        String userName1 = getUserName(user1);
        System.out.println("User's name: " + userName1);
    }
}

class User {
    private String name;

    // Constructor
    public User(String name) {
        this.name = name;
    }

    // Getter method for name
    public String getName() {
        return name;
    }
}

