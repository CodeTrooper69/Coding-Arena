# Coding-Arena
This is a GitHub repository dedicated to coding, where you can find a collection of code samples, snippets, and projects designed to help you learn and develop your programming skills. Inside, you'll find a variety of programming languages, including Java, Python, C++, and more.
public class Account {
    private String accountNumber;
    private String firstName;
    private String lastName;


    public String getLastName() {
        return lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private int balance;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    // constructor and getters/setters omitted for brevity

    @Override
    public String toString() {
        return accountNumber + "," + firstName + "," + lastName + "," + balance;
    }
}
import java.io.*;
import java.util.ArrayList;

public class Main {

    // other methods and variables

    public ArrayList<Account> loadAccountsFromFile(String fileName) {
        ArrayList<Account> accounts = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            accounts = (ArrayList<Account>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public static void main(String[] args) {
        // create accounts
        Account account1 = new Account("John Doe", 1000);
        Account account2 = new Account("Jane Smith", 2000);

        // perform transactions
        account1.deposit(500);
        account2.withdraw(1000);

        // save accounts to file
        Main main = new Main();
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        main.saveAccountsToFile(accounts, "accounts.dat");

        // load accounts from file
        ArrayList<Account> loadedAccounts = main.loadAccountsFromFile("accounts.dat");

        // display account attributes
        for (int i = 0; i < loadedAccounts.size(); i++) {
            Account account = loadedAccounts.get(i);
            System.out.println(account.toString());
        }

    }
}

