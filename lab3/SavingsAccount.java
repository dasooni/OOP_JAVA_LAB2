package Lab3;

public class SavingsAccount extends Account {

	private CurrentAccount theCurrentAccount; 
	
	public SavingsAccount(CurrentAccount arg) {
		super(arg.theCustomer, arg.getBank(),0);
		theCurrentAccount = arg;
		
	}
	
	public void payIn(double arg) {
		theBalance += arg;
	}
	
	public double payOut(double arg) {
		if( arg > theBalance) {
			theBalance = 0;
		}
		
		
		else {
			theBalance = arg;
		}
		return theBalance;
	}
}

