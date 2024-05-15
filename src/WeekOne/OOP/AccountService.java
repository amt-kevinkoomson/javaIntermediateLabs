package WeekOne.OOP;

public interface AccountService {
    // Method to deposit money into the account
    void deposit(double amount);

    // Method to withdraw money from the account
    void withdraw(double amount);

    // Method to get the current balance of the account
    double getBalance();
}

