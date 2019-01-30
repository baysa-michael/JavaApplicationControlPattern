package cit360.applicationcontrollerpattern;

public class BankAccount {
    private int accountNumber;
    private String accountOwner;
    private float accountBalance;

    public BankAccount() {
        this.accountNumber = 0;
        this.accountOwner = "";
        this.accountBalance = 0f;
    }

    public BankAccount(int accountNumber, String accountOwner, float accountBalance) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return String.format("\nBank Account:" +
                "\nAccount Number:  %1$d" +
                "\nAccount Owner:  %2$s" +
                "\nAccount Balance:  %3$,.2f",
                accountNumber,
                accountOwner,
                accountBalance);
    }
}
