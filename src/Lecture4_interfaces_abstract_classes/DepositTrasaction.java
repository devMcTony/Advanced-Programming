package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(int amt){
        if (amt < 0){
           return false;
        }
        else{
            return  true;
        }
    }


public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

@Override
public void apply(BankAccount ba) throws InsufficientFundsException {
    double curr_balance = ba.getBalance();
    if (getAmount() > curr_balance) {
        throw new InsufficientFundsException("Insufficient funds for withdrawal.");
    }
    double new_balance = curr_balance - getAmount();
    ba.setBalance(new_balance);
    System.out.println("WithdrawalTransaction: Withdrew " + getAmount() + ". New balance: " + new_balance);
}

public boolean reverse(BankAccount ba) {
    double curr_balance = ba.getBalance();
    ba.setBalance(curr_balance + getAmount());
    System.out.println("WithdrawalTransaction: Reversed transaction. Restored balance: " + ba.getBalance());
    return true;
}

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction: "+this.toString());
    }
}
