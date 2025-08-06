// Custom checked exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000.0);  // Initial balance

        try {
            double amountToWithdraw = 6000.0;  // Try different values to test
            account.withdraw(amountToWithdraw);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
