package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    // Initialize an Array with 1000 in size that stores Double called 'transactions'
    Double[] transactions = new Double[1000];
    int transactionCount = 0; // Tracks the current index for new transactions

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        // Ensures that only valid deposits (positive numbers) are added to the account
        if (amount > 0) {
            currentBalance += amount;
            // Record the transaction as a positive value in the transactions Array
            transactions[transactionCount++] = amount;
            // Prints a message including the depositor's name, the deposited amount, and the new balance
            System.out.println(name + " deposited: " + amount + ". New balance: " + currentBalance);
        } else {
            // Error messages are printed for unsuccessful deposits
            System.out.println("Error: Unsuccessful deposit. Amount must be positive.");
        }
    }

    public void withdraw(double amount){
        // Ensures that withdrawals are within the available balance (and positive)
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            // Valid withdrawals are recorded as a negative value in the transactions Array
            transactions[transactionCount++] = -amount;
            System.out.println(name + " withdrew: " + amount + ". New balance: " + currentBalance);
        } else {
            // If the conditions are not met, print an error message indicating the withdrawal was unsuccessful
            System.out.println("Error: Unsuccessful withdrawal. Insufficient funds or invalid amount.");
        }
    }

    public void displayTransactions(){
        System.out.print("Transactions: ");
        // Prints all the transactions (deposits and withdrawals) recorded
        for (int i = 0; i < transactionCount; i++) {
            System.out.print(transactions[i] + (i < transactionCount - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public void displayBalance(){
        // Prints the current balance of the account
        System.out.println("Current balance for " + name + ": $" + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }
}