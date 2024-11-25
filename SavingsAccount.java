import java.util.Scanner;

public class SavingsAccount {
    private String accountNumber;
    private double balance;
    private static double annualInterestRate;
    public static double calculateMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public static void modifyAnnualInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public SavingsAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void calculateAndAddInterest() {
        double monthlyInterest = balance * calculateMonthlyInterestRate();
        balance += monthlyInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	 System.out.println("Enter account number.");
	String s=scanner.next();
	System.out.println("Enter the balance");
	double b=scanner.nextDouble();
        SavingsAccount account = new SavingsAccount(s,b);
        System.out.print("Enter the initial annual interest rate: ");
        double initialRate = scanner.nextDouble();
        modifyAnnualInterestRate(initialRate);

        for (int i = 1; i <= 3; i++) {
            account.calculateAndAddInterest();
            System.out.println("Month " + i + ": Balance =" + account.getBalance());
        }

        System.out.print("Enter the new annual interest rate: ");
        double newRate = scanner.nextDouble();
        modifyAnnualInterestRate(newRate);

        account.calculateAndAddInterest();
        System.out.println("Month 4: Balance = " + account.getBalance());
    }
}