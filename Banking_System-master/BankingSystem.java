public class BankingSystem {
    public static void main(String[] args) {
        
        SavingsAccount sa = new SavingsAccount(1001, "Ram", 10000, 5);

        sa.displayAccount();

        System.out.println("--------------------");

        sa.deposit(3000);
        sa.withdraw(2000);

        System.out.println("--------------------");

        double interest = sa.calculateInterest();
        System.out.println("Interest Earned: "+interest);

        System.out.println("Final Balance: "+(sa.getBalance()+interest));
    }
}
