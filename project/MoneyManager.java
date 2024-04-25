package project;
import java.util.ArrayList;

public class MoneyManager {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative or zero.");
        }
        transactions.add(transaction);
    }

    public double calculateTotalBalance() {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                total += transaction.getAmount();
            } else if (transaction.getType().equalsIgnoreCase("expense")) {
                total -= transaction.getAmount();
            }
        }
        return total;
    }

    public void displayIncomeTransactions() {
        System.out.println("Income Transactions:");
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                transaction.display();
            }
        }
    }

    public void displayExpenseTransactions() {
        System.out.println("Expense Transactions:");
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense")) {
                transaction.display();
            }
        }
    }
}