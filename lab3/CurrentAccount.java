package Lab3;

import java.util.ArrayList;

public class CurrentAccount extends Account {
	
	private SavingsAccount theSavingsAccount;
	protected String accountType; 
	
	private ArrayList<Transaction> theTransaction;

	public CurrentAccount(Customer arg1, Bank arg2, double arg3) {
		super(arg1,arg2, arg3);
		theSavingsAccount = null;
		accountType = "Current";
		theTransaction = new ArrayList<Transaction>();	
		
	}
	
	public boolean hasSavingsAccount() {
		if(theSavingsAccount == null) {
			
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public SavingsAccount createSavingsAccount() {
		if(hasSavingsAccount()) {
			System.out.println("A savings account exists already");
			return null;
		}
		else
		{
		
	theSavingsAccount = new SavingsAccount(this);
	System.out.println("Added a savings account to the current account: " + getAccountNumber());
	return theSavingsAccount;	
		}
		
	}
	
	public Bank getBank() {
		return this.theBank;
	}
	
	public Customer getCustomer() {
		
		return theCustomer;
	}
	
	public SavingsAccount getSavingsAccount() {
		return this.theSavingsAccount;		
	}
	
	public void save(double arg) {
		if(!hasSavingsAccount()) {
			System.out.println("No savings account exists");
		}
		else {
			if( arg > theBalance) {
				double res = theBalance;
				theSavingsAccount.payIn(theBalance);
				theBalance = 0;
				System.out.println("No money");
				theTransaction.add(new Transaction(theSavingsAccount.accountNumber, -res, this.theBalance));

			}
			
			else {
				theBalance -= arg;
				theSavingsAccount.payIn(arg);
				theTransaction.add(new Transaction(theSavingsAccount.accountNumber, -arg, this.theBalance));
			}
			
		}
	
	}
	
	public void withdraw(double arg) {
		
		theBalance += theSavingsAccount.payOut(arg);
		
		theTransaction.add(new Transaction(this.getAccountNumber(), arg, this.theBalance));
		
	}
	
	public void payIn(double arg) {
		theBalance += arg;
		theTransaction.add(new Transaction(this.accountNumber, arg, this.theBalance));
		
	}
	
	public void PayIn(int arg1, double arg2) {
		this.theBalance += arg2;
		
		theTransaction.add(new Transaction(arg1, arg2, this.theBalance));
				
	}
	
	public void payOut(int arg1, double arg2) {
		
		
		if(theBank.getAccount(arg1) == null) {
			System.out.println("No such account exists");
		}
		
		else if (theBank.getAccount(arg1).equals(theSavingsAccount)){
			System.out.println("That is no a current account");
		}
		else {
			double  amountpayed = arg2;
			if( arg2>theBalance) {
				amountpayed = arg2;
			}
			theBalance -= amountpayed;
			CurrentAccount dummy = (CurrentAccount) theBank.getAccount(arg1);
			dummy.PayIn(accountNumber,arg2);
			theTransaction.add(new Transaction(arg1, -amountpayed,theBalance));
		}	
	}
	
	public String listTransactions() {
		String result =  "This account belongs to " + getCustomer() + " and the account number is " + getAccountNumber();
		
		for(int i = 0; i < theTransaction.size(); i++) {
			result += "\n" + theTransaction.get(i).toString(); 		
		}
		return result;
	}
		
	public String toString() {
		String result = "\n******************************"; 
		result=result + "\nvia subclass : \n" + super.toString();
		result= result + "\n******************************"; 
		return result;
	}
}
