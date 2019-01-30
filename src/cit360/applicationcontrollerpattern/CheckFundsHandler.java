package cit360.applicationcontrollerpattern;

import java.util.HashMap;

public class CheckFundsHandler implements Handler {
    @Override
    public void execute(HashMap<String, Object> data) {
        // Extract the Bank Account Information
        BankAccount currentAccount = (BankAccount) data.get("account");

        // Display Bank Account Information
        System.out.println("\n------------------------------\n");
        System.out.println(currentAccount.toString());
        System.out.println("\n------------------------------\n");
    }
}
