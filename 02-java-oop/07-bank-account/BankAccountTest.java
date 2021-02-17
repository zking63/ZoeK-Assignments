public class BankAccountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount(20, 10);

        BankAccount account2 = new BankAccount(10, 20);

        BankAccount account3 = new BankAccount(10, 20);

        BankAccount account4 = new BankAccount(10, 20);

        //System.out.println(account1);
        System.out.println(BankAccount.getnumberofAccounts());
        System.out.println(BankAccount.getTotalMoney());
    }
}