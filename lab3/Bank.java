package Lab3;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> theAccounts;
	private ArrayList<Customer> theCustomers;
	
	public Bank() {
		theAccounts = new ArrayList<Account>();
		theCustomers = new ArrayList<Customer>();
	}
	
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int i = 0; i < theCustomers.size(); i++) {
			if (theCustomers.get(i).getName().equals(arg)) {
				dummy = true;
			}
		}		
		return dummy;
	}
	
	public void addCustomer(String arg) {
		if (hasCustomer(arg)) {
			System.out.println("The customer already exists.");
		}
		else {
			theCustomers.add(new Customer(arg));
			System.out.println("Customer added.");
		}
	}
	
	public void addCurrentAccount(String arg1, double arg2) {
		if (hasCustomer(arg1)) {
			Customer dummy = getCustomer(arg1);
			if (dummy.hasCurrentAccount()) {
				System.out.println("The customer already has a current account.");
			}
			else {
				CurrentAccount newAccount = new CurrentAccount(dummy,this,arg2);
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("Added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("There is no customer with that name.");
		}
	}
	
	public Customer getCustomer(String arg) {
		if (!hasCustomer(arg)) return null;
		else {
			Customer dummy;
			int irun = 0;
			do {
				dummy = theCustomers.get(irun);
				irun++;
				
			} while (!dummy.getName().equals(arg));
			return dummy;
		}
	}
	
	public Account getAccount(int arg) {
		Account dummy = null;
		for(int i = 0; i < theAccounts.size(); i++) {
			
		if(theAccounts.get(i).accountNumber == arg) {
			dummy = theAccounts.get(i);
			return dummy;
		}
		}
		
		System.out.println("No such account exist");
		dummy = null;
		return dummy;
		
	}	
	
	public void addSavingsAccount(String arg) {
	
		if((!hasCustomer(arg))) {
			System.out.println("There is no customer with that name");
		}
		else {
			Customer dummy = getCustomer(arg);
			
			if((dummy.getCurrentAccount().hasSavingsAccount())) {
				System.out.println("The costumer already has a savings account");
			}
			else {
				theAccounts.add( dummy.getCurrentAccount().createSavingsAccount());
			}
		}
	  }
	
	public void computeAnnualChange() {
		for(int i = 0; i <theAccounts.size(); i++) {
			theAccounts.get(i).annualChange();
		}	
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
		Customer dummy = getCustomer(arg1);
		
		if(getCustomer(arg1)==null && getCustomer(arg1).hasCurrentAccount() == false) {
			
		}
		else {
			
			if(arg2.equals( "save")) {
				if(!dummy.getCurrentAccount().hasSavingsAccount() ) {
					dummy.getCurrentAccount().createSavingsAccount();
				}
				dummy.getCurrentAccount().save(arg3);
				
			}	
		if (arg2.equals("withdraw")) {
			
			
				dummy.getCurrentAccount().withdraw(arg3);
					
		}
	
		else if(arg2.equals("external")) {
			
			dummy.getCurrentAccount().payIn(arg3);
		}
			
		else if(!(getCustomer(arg2) == null)) {
			dummy.getCurrentAccount().payOut(getCustomer(arg2).getCurrentAccount().getAccountNumber(), arg3);
		}
	}
		}
				
	public void transactions(String arg) {
		Customer dummy = getCustomer(arg);
		if(dummy == null){
			System.out.println("nope");
		}
		else {
		String res = dummy.getCurrentAccount().listTransactions();
		System.out.println(res);
		}
	}
	
	public String toString() {
		String result = "Bank information : ";
		double totalValue = 0.0;
		for (int i = 0; i < theAccounts.size(); i++) {
			totalValue = totalValue + theAccounts.get(i).getBalance();
		}
		result = result + "\nNumber of customers : " + theCustomers.size();	
		result = result + "\nNumber of accounts : " + theAccounts.size();
		result = result + "\nIn controls a total of " + totalValue;
		return result;
	}
}

