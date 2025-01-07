import java.util.Scanner;

public class SimpleBankingApplication {
    // Variables to store account details
    private static double balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Simple Banking Application!");

        while (!exit) {
            // Display menu options
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            // Perform operations based on user choice
            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }

    // Method to handle deposits
    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f has been deposited successfully.%n", amount);
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        }
    }

    // Method to handle withdrawals
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f has been withdrawn successfully.%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
        }
    }

    // Method to check the account balance
    private static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }
}
