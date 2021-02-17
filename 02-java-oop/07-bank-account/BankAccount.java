public class BankAccount {
    private String accountNumber;
    private double checkingBalance; 
    private double savingsBalance;
    private static int numberofAccounts = 0;
    public BankAccount(String accountNumber, double checkingBalance, double savingsBalance){
        this.accountNumber = accountNumber;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        System.out.println("Account number: " + accountNumber + "\nChecking Balance: " + checkingBalance + "\nSavings Balance: " + savingsBalance);
        numberofAccounts++;
    }
    public static int getnumberofAccounts(){
        return numberofAccounts;
    }
}