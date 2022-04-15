
public class Savings extends Account {
	//list attributes specific to savings
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
		//create constructor including local attributes and super class attributes
		public Savings(String name, String ssn, double initDeposit) {
			super(name, ssn, initDeposit);
			accountNum = "1" + accountNum;
			setSafetyDepositBox();
			
		}
		//list methods specific to savings
		
		
		@Override
		public void setRate() {
			rate = getBaseRate() - 0.25;
			
		}
		
		private void setSafetyDepositBox() {
			safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
			safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
		}
		
		public void showInfo() {
			super.showInfo();
			System.out.println("Your Savings Account Features" + 
			"\nSafety Deposit Box ID: " + safetyDepositBoxID + 
			"\nSafety Deposit Box Key: " + safetyDepositBoxKey);
			
		}

}
