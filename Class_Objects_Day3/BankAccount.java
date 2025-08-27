class BankAccount {
    // Static variable shared by all accounts
    static String bankName = "National Bank";

    // Static variable to count total accounts
    private static int totalAccounts = 0;

    // Final variable to make accountNumber immutable
    private final int accountNumber;

    // Instance variable for account holder name
    private String accountHolderName;

    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    // Static method to get total number of accounts
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create two accounts
        BankAccount acc1 = new BankAccount("Alice", 1001);
        BankAccount acc2 = new BankAccount("Bob", 1002);

        // Use instanceof to verify object before displaying details
        if (acc1 instanceof BankAccount) {
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            acc2.displayDetails();
        }

        // Call static method
        BankAccount.getTotalAccounts();
    }
}
