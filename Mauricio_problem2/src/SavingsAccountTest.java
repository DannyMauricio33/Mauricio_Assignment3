public class SavingsAccountTest {
    public static void main(String[] args) {
        //Set starting dollar values for how much money is in each bank account
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        //Set the interest rate to 4% initially
        SavingsAccount.modifyInterestRate(0.04);

        //Print out the Starting values for each saver account
        System.out.println("Monthly Balances for both savers at 4% interest rate:");
        System.out.printf("\n%19s%10s\n","saver1", "saver2");
        System.out.printf("%-10s%11s%10s\n", "Start", saver1.convertBalanceString(), saver2.convertBalanceString());

        //Make a loop that will loop 12 times for interest to be calculated on both savings accounts
        for(int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month %d:%13s%10s\n", i, saver1.convertBalanceString(), saver2.convertBalanceString());
        }

        //Set the interest rate to 5% and calculate the interest on the 13th month
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        //Display values
        System.out.println("\nNext month with Interest Rate set to 5%");
        System.out.printf("%-10s%10s\n", "saver1", "saver2");
        System.out.printf("%-10s%12s\n", saver1.convertBalanceString(), saver2.convertBalanceString());
    }
}
