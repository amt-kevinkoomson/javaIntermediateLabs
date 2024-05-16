package WeekOne.Multithreading;

public class BankAccountSynchronized {
    private double balance;

    public BankAccountSynchronized(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit funds into the account
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    // Synchronized method to withdraw funds from the account
    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Main method for testing
    public static void main(String[] args) {
        BankAccountSynchronized account = new BankAccountSynchronized(1000);

        // Create and start threads for deposit and withdrawal
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                account.deposit(10); // Deposit $10, 100 times
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                account.withdraw(10); // Withdraw $10, 100 times
            }
        });

        depositThread.start();
        withdrawThread.start();

        // Wait for both threads to complete
        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}

