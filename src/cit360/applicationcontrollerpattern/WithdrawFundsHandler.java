package cit360.applicationcontrollerpattern;

import java.util.HashMap;

public class WithdrawFundsHandler implements Handler {
    @Override
    public void execute(HashMap<String, Object> data) {
        // Extract the two variables affecting the account balance
        float currentBalance = ((BankAccount) data.get("account")).getAccountBalance();
        float withdrawalAmount = (Float) data.get("amount");
        float newBalance = currentBalance - withdrawalAmount;

        // Update the account balance
        ((BankAccount) data.get("account")).setAccountBalance(newBalance);

        System.out.println("\n------------------------------\n");
        System.out.format("\nWithdrawn:  %1$,.2f\nCurrent Balance:  %2$,.2f", withdrawalAmount, newBalance);
        System.out.println("\n------------------------------\n");
    }
}
