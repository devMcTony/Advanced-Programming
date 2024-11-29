package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Method to check if a deposit amount is valid (utility method)
    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    /**
     * Reverse method - unique to the WithdrawalTransaction Class
     * Restores the amount withdrawn back to the BankAccount balance.
     *
     * @param ba - The BankAccount object the transaction was applied to.
     * @return true if the reversal is successful, false otherwise.
     */
    public boolean reverse(BankAccount ba) {
        if (ba == null) {
            System.err.println("Error: Bank account is null. Cannot reverse transaction.");
            return false;
        }

        double curr_balance = ba.getBalance();
        ba.setBalance(curr_balance + getAmount());
        System.out.println("WithdrawalTransaction: Reversed transaction. Restored balance: " + ba.getBalance());
        return true; // Indicate reversal was successful
    }

    // Method to print transaction details
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: ID " + getTransactionID() + ", Amount: " + getAmount() + ", Date: " + getDate().getTime());
    }

    // Apply method: Withdraws an amount from the BankAccount if funds are sufficient
    @Override
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
            System.out.println("WithdrawalTransaction: Withdrew " + getAmount() + ". New balance: " + new_balance);
        } else {
            System.err.println("Error: Insufficient funds. Withdrawal failed.");
        }
    }
}

