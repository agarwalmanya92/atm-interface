

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00; 
    private static ArrayList<String> transactionHistory = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    transactionHistory(); 
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    
    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            String transaction = "Deposit of $" + depositAmount; 
            transactionHistory.add(transaction); 
            System.out.println("You have successfully deposited: $" + depositAmount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    
    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            String transaction = "Withdrawal of $" + withdrawAmount; 
            transactionHistory.add(transaction); 
            System.out.println("You have successfully withdrawn: $" + withdrawAmount);
            checkBalance();
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    public static void transactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
