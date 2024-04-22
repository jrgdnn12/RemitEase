package edu.unlv.mis768.labwork8;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class SavingsAccountDemo {

	public static void main(String[] args) {
		String startingBalance; 	//Starting balance
		String monthlyInterestRate; //Monthly interest rate
		int numOfMonth; 			//Number of months that have passed since the amount was established.
		String withdraw;			//The amount of withdraw for each month
		String deposit;				//The amount of deposit for each month
		DecimalFormat ft = new DecimalFormat("$###,###.00");
		
		//get the user input of starting balance
		startingBalance = JOptionPane.showInputDialog("Please enter the starting balance: ");
		
		//get  the user input of the interest rate
		monthlyInterestRate = JOptionPane.showInputDialog("Please enter the monthly interest rate: ");
		
		//get the user input of  numbers of months that have passed.
		// parse the string to integer
		numOfMonth = Integer.parseInt(JOptionPane.showInputDialog("How many months have passed by since the the account was established? "));
		
		//Create a SavingAccount object
		//At the same time set the starting balance and the interestRate
		SavingsAccount myAccount = new SavingsAccount(monthlyInterestRate,startingBalance);
		
		//User a for loop to loop through the months
		//Starts from 1, ends at the month specified by the user, with an increment of 1 
		for (int i =1; i <= numOfMonth; i++) {
			//get the user input of withdraw amount
			withdraw=JOptionPane.showInputDialog("Please enter the withdraw amount for month " + i +": ");
			
			//withdraw the amount using the object's withdraw method
			myAccount.withdraw(withdraw);
			
			//get the user input of withdraw amount
			deposit = JOptionPane.showInputDialog("Please enter the deposit amount for month " +i+": ");
			//deposit the amount using the object's deposit method
			myAccount.deposit(deposit);
			
			//add interest for this month using the object's addInterest method
			myAccount.addInterest();
		}
		
		//Print out the ending balance
		JOptionPane.showMessageDialog(null,"The ending balance is " + ft.format(myAccount.getBalance()));
	}
}
