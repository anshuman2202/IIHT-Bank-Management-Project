package bankSystem;

public class MinBalanceException extends Exception{
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Minimum balance should be Rs. 1000";
	}
	
}
