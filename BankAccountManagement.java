import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the account
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with balance: " + initialBalance);
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new bank account
        System.out.println("Enter your name:");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountHolderName, initialBalance);

        // Menu for performing transactions
        int choice;
        do {
            System.out.println("\n-----Bank Account Menu-----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.checkBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
