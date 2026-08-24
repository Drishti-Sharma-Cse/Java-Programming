import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        // Initialize balance, hardcoded PIN, and scanner for user input
        double balance = 5000.00; 
        final int CORRECT_PIN = 1234;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to the Java ATM System ===");
        
        // Step 1: PIN Authentication
        System.out.print("Please enter your 4-digit PIN: ");
        int enteredPin = scanner.nextInt();
        
        if (enteredPin != CORRECT_PIN) {
            System.out.println("Invalid PIN. Access Denied. Exiting...");
            scanner.close();
            return; // Terminate program execution
        }
        
        // Step 2: ATM Menu Loop
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n--- ATM Main Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Check Balance
                    System.out.printf("Your current balance is: $%.2f%n", balance);
                    break;
                    
                case 2:
                    // Deposit Money
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("$%.2f successfully deposited.%n", depositAmount);
                        System.out.printf("New balance: $%.2f%n", balance);
                    } else {
                        System.out.println("Invalid amount. Deposit must be greater than zero.");
                    }
                    break;
                    
                case 3:
                    // Withdraw Money
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount. Withdrawal must be greater than zero.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance! Transaction canceled.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("$%.2f successfully withdrawn.%n", withdrawAmount);
                        System.out.printf("Remaining balance: $%.2f%n", balance);
                    }
                    break;
                    
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    isRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please pick an option between 1 and 4.");
            }
        }
        
        scanner.close();
    }
}
