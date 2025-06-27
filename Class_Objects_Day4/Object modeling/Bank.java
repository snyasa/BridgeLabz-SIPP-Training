import java.util.*;

// Bank class
class Bank {
    private String bankName;
    private ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    // Method to open a new account for a customer
    public void openAccount(Customer customer, double initialBalance) {
        Account account = new Account(customer, this, initialBalance);
        accounts.add(account);
        customer.addAccount(account);
        System.out.println("Account opened for " + customer.getName() + " in " + bankName);
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to view balances
    public void viewBalances() {
        System.out.println("Accounts of " + name + ":");
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getBankName() +
                               ", Account No: " + account.getAccountNumber() +
                               ", Balance: ₹" + account.getBalance());
        }
    }
}

// Account class
class Account {
    private String accountNumber;
    private Customer customer;
    private Bank bank;
    private double balance;

    public Account(Customer customer, Bank bank, double balance) {
        this.accountNumber = UUID.randomUUID().toString(); // Generate a unique account number
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}
