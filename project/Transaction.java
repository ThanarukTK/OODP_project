package project;

public class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative or zero.");
        }
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void display() {
        System.out.println("Type: " + type + ", Amount: " + amount);
    }
}