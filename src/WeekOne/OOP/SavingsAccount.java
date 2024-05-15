package WeekOne.OOP;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    // Add interest method
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a SavingsAccount object
        SavingsAccount mySavings = new SavingsAccount("987654321", 2000.0, 2.5);

        // Depositing money
        mySavings.deposit(500.0);

        // Withdrawing money
        mySavings.withdraw(200.0);

        // Checking balance
        System.out.println("Current Balance: " + mySavings.getBalance());

        // Adding interest
        mySavings.addInterest();

        // Checking balance after interest
        System.out.println("Balance after interest: " + mySavings.getBalance());
    }
}
