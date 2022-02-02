package Lab3;

public class Lab3 {

	public static void main(String[] args) {
		
		// Testing part A and B
			
		
		Bank dummyBank = new Bank();
		dummyBank.addCustomer("Harry");
		dummyBank.addCurrentAccount("Harry", 200.0);
		dummyBank.addCurrentAccount("Harry", 300.0);		
		dummyBank.addCustomer("Sally");
		dummyBank.addCurrentAccount("Sally", 400.0);
		System.out.println();
		System.out.println(dummyBank);
		System.out.println();
		CurrentAccount dummyAccount = new CurrentAccount(new Customer("Jim"), dummyBank, 500.0);
		System.out.println("Testing current account :\n"+ dummyAccount);
		dummyAccount.payIn(400);
		System.out.println(dummyAccount.hasSavingsAccount());
		System.out.println("Testing savings account :\n" + dummyAccount.createSavingsAccount());
		dummyAccount.createSavingsAccount();
		System.out.println(dummyAccount.getCustomer());
		System.out.println("Savings account : " + dummyAccount.getSavingsAccount());
		dummyAccount = null; dummyBank = null;
		System.out.println();
		
	
		// Testing part C
		
		System.out.println(new Transaction(7,400.0,800));
		System.out.println();
		CurrentAccount dummy2Account = new CurrentAccount(new Customer("Harry"), new Bank(), 200.0);
		System.out.println(dummy2Account.listTransactions());
		dummy2Account.createSavingsAccount();
		dummy2Account.payIn(100);
		dummy2Account.save(100.0);
		dummy2Account.save(1000.0);
		dummy2Account.withdraw(150);
		dummy2Account.withdraw(150);
		System.out.println(dummy2Account.listTransactions());
		System.out.println(dummyAccount);
		dummy2Account = null;
		
		
		// Testing part D
		
		Bank theBank = new Bank();
		theBank.addCustomer("Harry"); 
		theBank.addCurrentAccount("Harry", 400.0); 
		theBank.addSavingsAccount("Harry");
		
		theBank.addCustomer("Sally"); theBank.addCurrentAccount("Sally", 500.0); 
		
		theBank.transfer("Harry", "external", 3000.0);
		theBank.transfer("Harry", "save", 1500.0);
		theBank.transfer("Harry", "withdraw", 500.0);
		
		theBank.transfer("Sally", "save", 500.0);
		
		theBank.transfer("Harry", "Sally", 800.0);
	
		theBank.transactions("Harry");
		theBank.transactions("Sally");
		
	}

}
