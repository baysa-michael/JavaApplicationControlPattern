package cit360.applicationcontrollerpattern;

import java.util.HashMap;

public class DepositFundsHandler implements Handler {
    @Override
    public void execute(HashMap<String, Object> data) {
        // Extract the two variables affecting the account balance
        float currentBalance = ((BankAccount) data.get("account")).getAccountBalance();
        float depositAmount = (Float) data.get("amount");
        float newBalance = currentBalance + depositAmount;

        // Update the account balance
        ((BankAccount) data.get("account")).setAccountBalance(newBalance);

        System.out.println("\n------------------------------\n");
        System.out.format("\nDeposited:  %1$,.2f\nCurrent Balance:  %2$,.2f", depositAmount, newBalance);
        System.out.println("\n------------------------------\n");
    }
}
