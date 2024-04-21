package edu.unlv.mis768.labwork5;

import java.util.Scanner;

public class CreditCardApproval {

	public static void main(String[] args) {
		// variables for user input and result
	    double salary;    // Annual salary
	    int creditRating; // Credit rating
	      // whether the user is qualified.
	    
	    // Scanner object for keyboard input
	    Scanner kb = new Scanner(System.in);
	    
	    // Get the user's annual salary.
	    System.out.print("What is your annual salary?");
	    salary = kb.nextDouble();

	    // Get the user's credit rating (1 through 10).
	    System.out.print("On a scale of 1 through 10, what is your credit rating?\n" +
	             "(10 = excellent, 1 = very bad)");
	    creditRating = kb.nextInt();
	      
	    // call a method to determine whether the user qualifies.
	    
	    
	    if(isQualified)
	    	System.out.println("Congratulations! You can get the credit card.");
	    else
	    	System.out.println("Sorry, you cannot get the credit card.");
	         
	}


	
	
	
	
	
	
	
	

}
