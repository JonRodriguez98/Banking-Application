
public class Checking extends Account {
	//list attributes specific to checkings
	private long debitCardNumber;
	private int debitCardPin;
	//create constructor including local attributes and super class attributes
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNum = "2" + accountNum;
		
		setDebitCard();
	}
	
	
	//list methods specific to checkings
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
		
	}
	
	private void setDebitCard() {
			debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
			debitCardPin = (int) (Math.random() * Math.pow(10, 4));
		
	}
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println("Your Checkings Account Features" + 
		"\nDebit Card Number: " + debitCardNumber + 
		"\nDebit Card Pin: " + debitCardPin);
	}


	
}
