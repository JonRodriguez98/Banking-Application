
public abstract class Account implements IBaseRate {
	//list common properties for savings and checkings accounts
	private String name;
	private String ssn;
	private  double balance;
	protected double rate;
	protected String accountNum;
	private static int index = 10000;

	//constructors to set base properties and initialize account
	public Account(String name, String ssn, double initDeposit) {
		//common properties between Checking and Saving
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		
		/*Set Account Number With 1 or 2 Depending on account type, last 2 of ssn, unique 5 digit number, 
		and a random 3 numbers*/
		
		//Unique 5 digit num
		index++;
		
		this.accountNum = setAccountNumber();
		
		setRate();

	}
	
	//list common methods shared between savings and checkings
	
	
	 // Base Interest rate is 2.5. Checkings will use .25 less than the base rate and checking 15% of the base.

	public abstract void setRate();
	
	/*
	 * This Method first gets the last two digits of the user's SSN using the substring method.
	 * Initializes the uniqueID variable with the current index (starts at 10000 and increments by 1 on every
	 * instantiation of a checking/saving account). Finally gets random numbers using the Math Class methods 
	 * and returns it in the proper order to assign an account number.
	 */
	private String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length()-2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10,3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	//compound interest
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	

	//transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() { 
		System.out.println("Your balance is now: " + balance);
	}
	public void showInfo() {
		System.out.println(
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + accountNum + 
				"\nBALANCE: " + balance + 
				"\nRATE: " + rate + "%");
	}
	
}
