package project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MoneyManager manager = new MoneyManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMoney Manager Menu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. Display Total Balance");
            System.out.println("3. Display Income Transactions");
            System.out.println("4. Display Expense Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTransaction(manager, scanner);
                    break;
                case 2:
                    System.out.println("Total Balance: $" + manager.calculateTotalBalance());
                    break;
                case 3:
                    manager.displayIncomeTransactions();
                    break;
                case 4:
                    manager.displayExpenseTransactions();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTransaction(MoneyManager manager, Scanner scanner) {
        String type;
        double amount;
        do {
            System.out.print("Enter transaction type income/expense): ");
            type = scanner.next();
            System.out.print("Enter transaction amount: ");
            amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount cannot be negative. Please enter a non-negative amount.");
            }
        } while (amount <= 0);
        manager.addTransaction(new Transaction(type, amount));
    }
}