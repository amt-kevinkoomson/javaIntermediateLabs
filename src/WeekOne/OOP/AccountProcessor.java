package WeekOne.OOP;

public class AccountProcessor {
    // Method to process deposit for any type of account
    public static void processDeposit(BankAccount account, double amount) {
        account.deposit(amount);
        System.out.println("Deposit of " + amount + " processed for account " + account.getAccountNumber());
    }

    // Method to process withdrawal for any type of account
    public static void processWithdrawal(BankAccount account, double amount) {
        account.withdraw(amount);
        System.out.println("Withdrawal of " + amount + " processed for account " + account.getAccountNumber());
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating instances of different account types
        BankAccount checkingAccount = new CheckingAccount("111111", 1000.0);
        BankAccount savingsAccount = new SavingsAccount("222222", 2000.0, 2.5);

        // Processing deposits
        processDeposit(checkingAccount, 500.0);
        processDeposit(savingsAccount, 800.0);

        // Processing withdrawals
        processWithdrawal(checkingAccount, 200.0);
        processWithdrawal(savingsAccount, 300.0);

        // Checking balances after transactions
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
    }
}
