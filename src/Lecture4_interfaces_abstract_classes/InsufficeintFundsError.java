package Lecture4_interfaces_abstract_classes;

public class InsufficeintFundsError extends Exception {
    private double availableBalance;
    private double withdrawalAmount;

    // Constructor with detailed error message
    public InsufficeintFundsError(String message, double availableBalance, double withdrawalAmount) {
        super(message);
        this.availableBalance = availableBalance;
        this.withdrawalAmount = withdrawalAmount;
    }

    // Getter methods for additional information
    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }
}
