public class BankAccountTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("1111", 20.20, 21.21);

        BankAccount account2 = new BankAccount("2222", 30.20, 41.21);

        //System.out.println(account1);
        System.out.println(BankAccount.getnumberofAccounts());
    }
}