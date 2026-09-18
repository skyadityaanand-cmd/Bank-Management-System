import java.util.Scanner;
import java.util.HashMap;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: " + balance);
        }
    }

    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagementSystem2 {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static int nextAccountNumber = 1001;

    public static void main(String[] args) {

        int choice;

        System.out.println("===== Welcome to Bank App =====");

        do {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // Clear the newline buffer

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial deposit: ");
                    double balance = sc.nextDouble();

                    if (balance < 0) {
                        System.out.println("Initial deposit cannot be negative.");
                        break;
                    }

                    Account newAccount = new Account(nextAccountNumber, name, balance);
                    accounts.put(nextAccountNumber, newAccount);

                    System.out.println("Account created successfully!");
                    System.out.println("Your account number is: " + nextAccountNumber);

                    nextAccountNumber++;
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccount = sc.nextInt();

                    if (accounts.containsKey(depositAccount)) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        accounts.get(depositAccount).deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccount = sc.nextInt();

                    if (accounts.containsKey(withdrawAccount)) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        accounts.get(withdrawAccount).withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int checkAccount = sc.nextInt();

                    if (accounts.containsKey(checkAccount)) {
                        System.out.println("\n--- Account Details ---");
                        accounts.get(checkAccount).displayAccount();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank App!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
