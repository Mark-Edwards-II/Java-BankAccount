import java.util.Random;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	public static int totalNumberOfAccounts = 0;
	public static double totalAmountInBank = 0;

	private static String generateAccountNumber() {
		Random rand = new Random();
		String accountNumber = "";
		for(int i = 0; i < 10;i++ ) {
			accountNumber += rand.nextInt(10);
		}
		return accountNumber;
	}

	public BankAccount() {
		BankAccount.totalNumberOfAccounts++;
		this.accountNumber = BankAccount.generateAccountNumber();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
	}
	
	public double getCheckingAccountBalance() {
		return this.checkingBalance;
	}

	public double getSavingsAccountBalance() {
		return this.savingsBalance;
	}
	
	public void deposit(double amount, String accountType) {
		if(accountType == "checking") this.checkingBalance += amount;
		else if(accountType == "saving") this.savingsBalance += amount;
		BankAccount.totalAmountInBank += amount;
	}

	public void withdraw(double amount, String accountType) {
		if(accountType == "checking" && this.checkingBalance - amount >= 0) {
			this.checkingBalance -= amount;
			BankAccount.totalAmountInBank -= amount;
		}

		if(accountType == "saving" && this.savingsBalance - amount >0) {
			this.savingsBalance -= amount;
			BankAccount.totalAmountInBank -= amount;
		}
	}
	
	public void displayBalance() {
		String accountEndingIn = "******"+ this.accountNumber.charAt(6) +this.accountNumber.charAt(7) + this.accountNumber.charAt(8) + this.accountNumber.charAt(9);
		System.out.println("Account ending in");
		System.out.println(accountEndingIn);
		System.out.println("Savings: " + this.savingsBalance + ", Checking: " + this.checkingBalance);
		System.out.println("Accounts totaling: "+(this.checkingBalance+ this.savingsBalance));
	}

}
