package bankSystem;

public class Bank {
	String name;
	int actNo;
	double bal;
	String actType;
	
	public Bank(String name, int actno, double bal, String actType) throws MinBalanceException {
		this.name = name;
		this.actNo = actNo;
		this.bal = bal;
		this.actType = actType;
		
		checkMinBalance(bal);
		
	}

	public void checkMinBalance(double bal) throws MinBalanceException {

		if(bal<1000) {
			throw new MinBalanceException();
		}
	}
	
	public void withdrawMoney(double sum) {
		if(bal - sum < 0) System.out.println("Insufficient balance");
		else if(bal - sum < 1000) System.out.println("Minimum balance rules vioalted");
		else {
			bal-=sum;
			System.out.println("Updated balance is "+ bal);
		}
	}
	
	
}
