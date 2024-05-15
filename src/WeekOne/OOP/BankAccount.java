package WeekOne.OOP;

public class BankAccount implements AccountService{
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Please deposit a positive amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }
    public void withdraw(double min, double percentage ) {
        // method overloading demonstration. withdraw a percentage of balance, leaving a minimum amount
        double balance = getBalance() - min;
        double withdrawn = balance * percentage/100;
        setBalance(balance - withdrawn);
        System.out.println(withdrawn + " withdrawn as percentage successfully.");
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount myAccount = new BankAccount("123456789", 1000.0);

        // Depositing money
        myAccount.deposit(500.0);

        // Withdrawing money
        myAccount.withdraw(200.0);

        // Checking balance
        System.out.println("Current Balance: " + myAccount.getBalance());
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    private void setBalance(double amount) {
        balance = amount;
    }
}
