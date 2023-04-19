import java.util.ArrayList;

// Interface: Account
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void calculateInterest();
    int getAccountNumber();
    String getType();
    double getBalance();
}

// Class: SavingsAccount
class SavingsAccount implements Account {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private int accountNumber;
    private double balance;
    private String type;
    private double interestRate;

    public SavingsAccount(String firstName, String lastName, String address, String phoneNumber, String email,
                          int accountNumber, double balance, String type, double interestRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.interestRate = interestRate;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    // Method to calculate interest
    @Override
    public void calculateInterest() {
        double interest = this.balance * (this.interestRate / 100);
        this.balance += interest;
        System.out.println("Interest calculated and added to the account: $" + interest);
    }

    // Method to deposit amount
    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Method to withdraw amount
    @Override
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Class: CheckingAccount
class CheckingAccount implements Account {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private int accountNumber;
    private double balance;
    private String type;
    private double overdraftLimit;

    public CheckingAccount(String firstName, String lastName, String address, String phoneNumber, String email,
                           int accountNumber, double balance, String type, double overdraftLimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Method to withdraw amount
    @Override
    public void withdraw(double amount) {
        if (amount <= this.balance + overdraftLimit) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method to calculate interest (not applicable for CheckingAccount)
    @Override
    public void calculateInterest() {
        System.out.println("Interest calculation not applicable for Checking Account.");
    }
}

// Class: LoanAccount
class LoanAccount implements Account {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private int accountNumber;
    private double balance;
    private String type;
    private double loanAmount;
    private double interestRate;

    public LoanAccount(String firstName, String lastName, String address, String phoneNumber, String email,
                       int accountNumber, double balance, String type, double loanAmount, double interestRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Method to withdraw amount (not applicable for LoanAccount)
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed for Loan Account.");
    }

    // Method to calculate interest
    @Override
    public void calculateInterest() {
        double interest = this.balance * (this.interestRate / 100);
        this.balance += interest;
        System.out.println("Interest calculated and added to the account: $" + interest);
    }
}

// Main class: BankingSystem
public class BankingSystem {
    public static void main(String[] args) {
        // Create SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("John", "Doe", "123 Main St", "123-456-7890", "john.doe@email.com",
                1001, 5000.0, "Savings", 2.5);

        // Create CheckingAccount object
        CheckingAccount checkingAccount = new CheckingAccount("Jane", "Smith", "456 Oak Ave", "987-654-3210", "jane.smith@email.com",
                2001, 3000.0, "Checking", 1000.0);

        // Create LoanAccount object
        LoanAccount loanAccount = new LoanAccount("David", "Brown", "789 Pine Rd", "456-789-1230", "david.brown@email.com",
                3001, 0.0, "Loan", 10000.0, 3.0);

        // Perform operations on SavingsAccount
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Account Type: " + savingsAccount.getType());
        System.out.println("Balance: $" + savingsAccount.getBalance());
        savingsAccount.deposit(1000.0);
        savingsAccount.withdraw(2000.0);
        savingsAccount.calculateInterest();
        System.out.println("Updated Balance: $" + savingsAccount.getBalance());

        // Perform operations on CheckingAccount
        System.out.println("\nChecking Account Details:");
        System.out.println("Account Number: " + checkingAccount.getAccountNumber());
        System.out.println("Account Type: " + checkingAccount.getType());
        System.out.println("Balance: $" + checkingAccount.getBalance());
        checkingAccount.deposit(500.0);
        checkingAccount.withdraw(3500.0);
        // Perform operations on CheckingAccount
        System.out.println("\nChecking Account Details:");
        System.out.println("Account Number: " + checkingAccount.getAccountNumber());
        System.out.println("Account Type: " + checkingAccount.getType());
        System.out.println("Balance: $" + checkingAccount.getBalance());
        checkingAccount.deposit(500.0);
        checkingAccount.withdraw(3500.0);
        checkingAccount.deductFees();
        System.out.println("Updated Balance: $" + checkingAccount.getBalance());

        // Perform operations on LoanAccount
        System.out.println("\nLoan Account Details:");
        System.out.println("Account Number: " + loanAccount.getAccountNumber());
        System.out.println("Account Type: " + loanAccount.getType());
        System.out.println("Balance: $" + loanAccount.getBalance());
        loanAccount.deposit(2000.0);
        loanAccount.calculateInterest();
        System.out.println("Updated Balance: $" + loanAccount.getBalance());
    }
}


