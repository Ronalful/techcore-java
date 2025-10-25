package Task1;

public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName) {
        if (!isOwnerNameValid(ownerName)) {
            throw new IllegalArgumentException("Owner name is invalid");
        }
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount(String ownerName, double balance) {
        if (!isOwnerNameValid(ownerName)) {
            throw new IllegalArgumentException("Owner name is invalid");
        }
        if (!isBalanceValid(balance)) {
            throw new IllegalArgumentException("Balance is invalid");
        }
        this.ownerName = ownerName;
        this.balance = balance;
    }

    private boolean isOwnerNameValid(String ownerName) {
        return ownerName != null && !ownerName.isEmpty();
    }

    private boolean isBalanceValid(double balance) {
        return balance >= 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (!isOwnerNameValid(ownerName)) {
            throw new IllegalArgumentException("Owner name is invalid");
        }
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (!isBalanceValid(balance)) {
            throw new IllegalArgumentException("Balance is invalid");
        }
        this.balance = balance;
    }
}
