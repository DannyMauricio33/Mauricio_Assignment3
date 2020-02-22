public class SavingsAccount {
    //Set Balance and Interest Rate Variables
    private static double annualInterestRate = 0;
    private double savingsBalance;

    //Convert the Balance value to a String to format it easier
    public String convertBalanceString() {
        return String.format("$%.2f", savingsBalance);
    }

    //Set the savings account as an object for the Test file
    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }

    //Calculate the monthly interest that will be displayed in the test file
    public void calculateMonthlyInterest() {
        savingsBalance += savingsBalance * (annualInterestRate / 12);
    }

    //Change the interest rate when needed
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
}
