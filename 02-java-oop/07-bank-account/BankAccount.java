import java.util.Random;
public class BankAccount {
    private String accountNumber;
    private double checkingBalance; 
    private double savingsBalance;
    private static int numberofAccounts = 0;
    private static int totalMoney = 0;

    private static String getAcctNumber(){ //why static?, what if we wanted to make sure no repeats?
        String acct = "";
        Random x = new Random();
        for (int i = 0; i < 10; i++){
            acct += x.nextInt(10);
        }
        return acct;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.accountNumber = getAcctNumber();
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        totalMoney += this.checkingBalance + this.savingsBalance;
        System.out.println("Account number: " + accountNumber + "\n Checking Balance: " + checkingBalance + "\n Savings Balance: " + savingsBalance);
        numberofAccounts++;
    }
    public static int getnumberofAccounts(){
        return numberofAccounts;
    }
    public static int getTotalMoney(){
        return totalMoney;
    }
    public double getChecking(){
        return this.checkingBalance;
    }
    public double getSavings(){
        return this.savingsBalance;
    }
    public void DepositMoney(double deposit, String choice){ //Why didn't I need to write (BankAccount, double deposit, String choice) like in the human assignment?
        if (choice == "checking"){
            this.checkingBalance += deposit;
            System.out.println("Account number: " + accountNumber + "\n Checking Balance: " + checkingBalance + "\n Savings Balance: " + savingsBalance);
        }
        if (choice == "savings"){
            this.savingsBalance += deposit;
            System.out.println("Account number: " + accountNumber + "\n Checking Balance: " + checkingBalance + "\n Savings Balance: " + savingsBalance);
        }
        totalMoney += deposit;
    }
    public void WithdrawMoney(double withdraw, String choice){
        if (choice == "checking"){
            if (this.checkingBalance >= withdraw){
                this.checkingBalance -= withdraw;
                System.out.println("Account number: " + accountNumber + "\n Checking Balance: " + checkingBalance + "\n Savings Balance: " + savingsBalance);
                totalMoney -= withdraw;
            }
            else {
                System.out.println("Insufficient funds");
            }
        }
        if (choice == "savings"){
            if (this.savingsBalance >= withdraw){
                this.savingsBalance -= withdraw;
                System.out.println("Account number: " + accountNumber + "\n Checking Balance: " + checkingBalance + "\n Savings Balance: " + savingsBalance);
                totalMoney -= withdraw;
            }
            else {
                System.out.println("Insufficient funds");
            }
        }
    }
}