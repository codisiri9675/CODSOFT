import java.util.Scanner;

// Step 1: Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current balance: Rs." + balance);
    }
}

// Step 2: Create the ATM machine class
class ATM {
    private BankAccount account; // Step 5: Connect with the bank account

    // Constructor to link ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Option to perform deposit
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Option to perform withdrawal
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    // Option to check balance
    public void checkBalance() {
        account.checkBalance();
    }
}

// Main class to drive the ATM program
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 4: Create a user's account with an initial balance
        BankAccount userAccount = new BankAccount(1000); // Initial balance ₹1000
        ATM atm = new ATM(userAccount);

        // Step 2: Design the user interface
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();

            // Step 6 & 7: Handle user input and show messages
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs.");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1-4.");
            }
        }
    }
}