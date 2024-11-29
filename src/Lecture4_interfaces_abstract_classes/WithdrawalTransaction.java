// File: WithdrawalTransaction.java
package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    // Constructor
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Method to print transaction details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    // Apply withdrawal with exception handling
    public void apply(BankAccount ba) throws InsufficeintFundsError {
        double currentBalance = ba.getBalance();
        double withdrawalAmount = getAmount();

        try {
            // Check if sufficient funds are available
            if (withdrawalAmount > currentBalance) {
                // If withdrawal amount is more than balance, throw exception
                throw new InsufficeintFundsError(
                        "Insufficient funds for withdrawal",
                        currentBalance,
                        withdrawalAmount
                );
            }

            // Perform withdrawal
            double newBalance = currentBalance - withdrawalAmount;
            ba.setBalance(newBalance);
        } catch (InsufficeintFundsError e) {
            // Partial withdrawal scenario
            if (currentBalance > 0) {
                // Withdraw all available balance
                ba.setBalance(0);
                System.out.println("Partial withdrawal: " + currentBalance +
                        " withdrawn out of " + withdrawalAmount);
            }

            // Re-throw the exception for further handling
            throw e;
        } finally {
            // Optional: Log the transaction attempt
            System.out.println("Withdrawal attempt completed.");
        }
    }

    // Method to reverse the transaction (specific to withdrawal)
    public boolean reverse(BankAccount ba) {
        // Since withdrawals can be reversed (per assignment requirements)
        // This method would restore the original balance
        return false; // Placeholder - you'd implement actual reversal logic
    }
}