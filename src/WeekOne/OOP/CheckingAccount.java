package WeekOne.OOP;

public class CheckingAccount extends BankAccount{
    private double interestRate;
    public CheckingAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
}
