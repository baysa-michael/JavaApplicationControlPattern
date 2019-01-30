package cit360.applicationcontrollerpattern;

import java.util.HashMap;
import java.util.Scanner;

public class BankTransaction {
    private static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
            Bank Transactions
            -Deposit
            -Withdraw
            -Check Funds
            -Exit
         */
        BankAccount userAccount = new BankAccount(158532, "Sasaki", 150f);
        boolean exitBank = false;

        do {
            exitBank = startBankTransaction(userAccount);
        } while (!exitBank);
    }

    public static boolean startBankTransaction(BankAccount userAccount) {
        boolean endTransaction = false;
        ApplicationController bankController = new ApplicationController();

        // Add Application Actions
        bankController.addCommand("D", new DepositFundsHandler());
        bankController.addCommand("W", new WithdrawFundsHandler());
        bankController.addCommand("C", new CheckFundsHandler());

        // Display valid actions to user
        System.out.println("\nWelcome to the bank!  Please select from the following valid transactions:" +
                "\n(D)eposit Funds" +
                "\n(W)ithdraw Funds" +
                "\n(C)heck Funds" +
                "\n(E)xit\n\n");

        // Prompt the user for an action
        System.out.print("Please select a valid action (D, W, C, E):  ");
        String response = myScanner.nextLine();

        // Implement the Application Controller
        if (response.compareTo("E") == 0) {
            // End the application
            return true;
        } else if(response != null) {
            // Wrap the data to pass as a HashMap
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("account", userAccount);

            // If the user is looking to deposit or withdraw funds, prompt for the amount
            if (response.compareTo("D") == 0 || response.compareTo("W") == 0) {
                System.out.print("Please enter an amount greater than 0.00:  ");
                float amount = myScanner.nextFloat();

                // Test amount for validity
                if (amount <= 0) {
                    System.out.println("ERROR:  Cannot input a negative amount for deposits/withdrawals");
                    return false;
                } else {
                    data.put("amount", (Float) amount);
                }
            }

            // Call the Application Controller
            bankController.handleRequest(response, data);
        }

        return false;
    }
}
