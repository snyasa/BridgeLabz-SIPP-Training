interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showDetails() {
        System.out.println("Account: " + accountNumber + ", Holder: " + holderName + ", Balance: ₹" + balance);
    }

    // Abstract method
    public abstract double calculateInterest();
}
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4% interest
    private double requestedLoan = 0;

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        requestedLoan = amount;
        System.out.println("Loan requested: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        boolean eligible = getBalance() >= 10000;
        System.out.println("Loan Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));
        return eligible;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.01; // 1% interest
    private double requestedLoan = 0;

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        requestedLoan = amount;
        System.out.println("Loan requested: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        boolean eligible = getBalance() >= 50000;
        System.out.println("Loan Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));
        return eligible;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV123", "Alice", 15000);
        BankAccount acc2 = new CurrentAccount("CUR456", "Bob", 60000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount acc : accounts) {
            acc.showDetails();
            System.out.println("Interest: ₹" + acc.calculateInterest());

            // Cast to Loanable and check loan eligibility
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(20000);
                loanAcc.calculateLoanEligibility();
            }

           
        }
    }
}
