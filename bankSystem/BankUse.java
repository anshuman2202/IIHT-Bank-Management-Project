package bankSystem;
import java.util.*;

import importantConcepts.Hash_Set;
public class BankUse {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Bank> array = new ArrayList<Bank>();
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws MinBalanceException {
		
		int ch;
		
		do {
			System.out.println("1. Create a new account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. View Balance");
			System.out.println("5. Display all customers");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			
			viewOptions(ch);
		}while(ch!=0);
	}

	private static void viewOptions(int ch) throws MinBalanceException {
		
		switch(ch) {
		case 1: 
			enterDetail();
			break;
		case 2:
			depositMoney();
			break;
		case 3:
			withdrawMoney();
			break;
		case 4:
			viewBal();
			break;
		case 5:
			displayCustomers();
			break;
		default:
			System.out.println("Enter a valid choice: ");
		}
		
	}

	
	private static void displayCustomers() {
		
		for(int i=0;i<array.size();i++) {
			Bank user = array.get(i);
			System.out.println(user.name + " "+ user.bal);
		}
		
	}

	private static void withdrawMoney() {
		System.out.println("Enter you account number: ");
		int num = sc.nextInt();
		if(set.contains(num)) {
			Bank user =  array.get(num-1000);
			System.out.println("Enter the amount you want to withdraw: ");
			double sum = sc.nextDouble();
			/*if(user.bal - sum < 0) System.out.println("Insufficient balance");
			else if(user.bal - sum < 1000) System.out.println("Minimum balance rules violated");
			else {
				user.bal-=sum;
				System.out.println("Updated balance is "+ user.bal);
			}*/
			user.withdrawMoney(sum);
			
		}else System.out.println("Account number "+num+ " doesn't exist");
		
	}

	private static void viewBal() {
		System.out.println("Enter you account number: ");
		int num = sc.nextInt();
		if(set.contains(num)) {
			Bank user =  array.get(num-1000);
			System.out.println("Available Balance is: "+ user.bal);
			
		}else System.out.println("Account number "+num+ " doesn't exist");
	}
	

	private static void depositMoney() {
		System.out.println("Enter you account number: ");
		int num = sc.nextInt();
		if(set.contains(num)) {
			Bank user =  array.get(num-1000);
			System.out.println("Enter the amount you want to depoist: ");
			double sum = sc.nextDouble();
			user.bal+=sum;
			System.out.println("Updated balance is "+ user.bal);
		}else System.out.println("Account number "+num+ " doesn't exist");
	}

	private static void enterDetail() throws MinBalanceException {
		
		System.out.println("Enter your Name, Type of account and money you want to deposit: ");
		String name = sc.next();
		String actType = sc.next();
		double bal = sc.nextDouble();
		int accNo = 1000+array.size();
		Bank newUser = new Bank(name, accNo, bal, actType);
		array.add(newUser);
		set.add(accNo);
		System.out.println("Congratulations! Your account with number "+accNo+" has been succesfully created!");
	}


}
