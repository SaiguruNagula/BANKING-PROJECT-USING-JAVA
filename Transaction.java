import java.util.*;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + ": $" + amount;
    }
}

class Account {
    private int accountNumber;
    private String name;
    private double balance;
    private String pin;
    private ArrayList<Transaction> transactions;

    // Constructor to initialize account
    public Account(int accountNumber, String name, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialBalance;
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    // Method to check balance
    public void checkBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.printf("Successfully deposited $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.printf("Successfully withdrew $%.2f%n", amount);
        }
    }

    // Method to change PIN
    public void changePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN successfully changed.");
        } else {
            System.out.println("Incorrect old PIN.");
        }
    }

    // Method to display mini-statement (last 5 transactions)
    public void displayMiniStatement() {
        System.out.println("Mini Statement (Last 5 Transactions):");
        int start = Math.max(0, transactions.size() - 5);
        for (int i = start; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    // Method to transfer money to another account
    public void transfer(Account targetAccount, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for transfer.");
        } else if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
        } else {
            balance -= amount;
            targetAccount.balance += amount;
            transactions.add(new Transaction("Transfer to " + targetAccount.accountNumber, amount));
            targetAccount.transactions.add(new Transaction("Received from " + this.accountNumber, amount));
            System.out.printf("Successfully transferred $%.2f to account %d%n", amount, targetAccount.accountNumber);
        }
    }

    // Method to validate PIN
    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }
    
    // Method to display account info
    public void displayAccountInfo() {
        System.out.printf("Account Number: %d%n", accountNumber);
        System.out.printf("Account Holder: %s%n", name);
    }
}


