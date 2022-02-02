package Lab3;

public class Account {

	public static double CURRENTACCOUNTFEE = 10.0;
	public static double SAVINGSINTEREST = 0.01; 
	protected String accountType = "Savings"; 
	protected Customer theCustomer;
	protected Bank theBank; 
	protected int accountNumber;
	protected double theBalance;
	private static int availableNumbers = 0;
	
	public Account(Customer arg1, Bank arg2, double arg3) {
		theCustomer = arg1;
		theBalance = arg3;
		availableNumbers = availableNumbers + 1;
		accountNumber = availableNumbers;
		theBank = arg2;
	}
		
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return theBalance;
	}
	
	public void annualChange() {
		if(accountType.equals("Current")){
			theBalance -= CURRENTACCOUNTFEE;
		}
		
		else {
			theBalance += SAVINGSINTEREST;
		}
	}
	
	public String toString() {
		String result = "\n******************************"; 
		result = result + "\nAccount number : " + accountNumber;
		result = result + "\nCustomer : " + theCustomer.getName();
		result = result + "\nBalance : " + theBalance;
		result = result + "\n******************************";
		return result;
	}
}
