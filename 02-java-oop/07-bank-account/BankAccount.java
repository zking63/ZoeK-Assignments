import java.util.Random;
public class BankAccount {
    private String accountNumber;
    private double checkingBalance; 
    private double savingsBalance;
    private static int numberofAccounts = 0;
    private static int totalMoney = 0;

    private static String getAcctNumber(){
        String acct = "";
        Random x = new Random();
        for (int i = 0; i < 1; i++){
            acct += x.nextInt(4);
        }
        return acct;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.accountNumber = getAcctNumber();
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        totalMoney += this.checkingBalance + this.savingsBalance;
        System.out.println("Account number: " + accountNumber + "\nChecking Balance: " + checkingBalance + "\nSavings Balance: " + savingsBalance);
        numberofAccounts++;
    }
    public static int getnumberofAccounts(){
        return numberofAccounts;
    }
    public static int getTotalMoney(){
        return totalMoney;
    }
}