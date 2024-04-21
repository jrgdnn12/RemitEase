package edu.unlv.mis768.labwork9;

import java.text.DecimalFormat;

public class TwoCoinTossing {
	public static void main(String[] args) {
		//Define the format of the numbers
		DecimalFormat formatter = new DecimalFormat("           ");
		
		//Starting balance
		double balance = 0.0;
		//Create the two coins
		Coin quarter = new Coin();
		Coin dime = new Coin();
		
		//Toss the quarter
		//If it lands heads-up, add 25 cents to the balance
		quarter.toss();
		System.out.println(quarter.getSideUp());
		if (                                 )
			balance = balance + 0.25;
		//If the dime lands heads-up, add 10 cents to the balance
		dime.toss();
		System.out.println(dime.getSideUp());
		if (                                 )
			balance = balance + 0.10;
			
		System.out.print("The ending balance is: ");
		//Print the balance using the formatter
		System.out.println(                          );
	}
}
