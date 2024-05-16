package WeekOne.Multithreading;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        // Simulate some processing time
        try {
            Thread.sleep(1); // Simulate 1 millisecond of processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) {
        // Simulate some processing time
        try {
            Thread.sleep(1); // Simulate 1 millisecond of processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            for (int i = 0; i < 1000; i++) {
                account.deposit(10); // Deposit $10, 1000 times
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(10); // Withdraw $10, 1000 times
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
