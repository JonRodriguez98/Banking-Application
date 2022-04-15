import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
		String file = "src\\utilities\\NewBankAccounts.csv";
		
		List<Account> accounts = new LinkedList<Account>();
		
		
		//Read a CSV file then create new accounts based on the information 
		
		List<String[]> newAccountHolder = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolder) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit =  Double.parseDouble(accountHolder[3]);
			System.out.println(name + " " + ssn + " " + accountType + " $" + initDeposit);
			
			if (accountType.equalsIgnoreCase("Saving")) {
				accounts.add(new Savings(name, ssn, initDeposit));
		}
			else if(accountType.equalsIgnoreCase("Checking")) {
				accounts.add(new Checking(name, ssn, initDeposit));
			}
			
			else {
				System.out.println("ERROR READING FILE");
			}
			
			for(Account acc : accounts) {
				System.out.println("\n*********************");
				acc.showInfo();
			}
}
}
}