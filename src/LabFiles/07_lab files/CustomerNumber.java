package edu.unlv.mis768.labwork7;

import javax.swing.*;

public class CustomerNumber {
	/**
	   This program tests a customer number to
	   verify that it is in the proper format.
	*/
	public static void main(String[] args) {
		String input;  // To hold the user's input
		
		// Get a customer number.
	      input = JOptionPane.showInputDialog("Enter " +
	         "a customer number in the form LLLNNNN\n" +
	         "(LLL = letters and NNNN = numbers)");

	      // Validate the input.
	      if (isValid(input)) {
	         JOptionPane.showMessageDialog(null,
	                 "That's a valid customer number.");
	      }
	      else  {
	         JOptionPane.showMessageDialog(null,
	             "That is not the proper format of a " +
	             "customer number.\nHere is an " +
	             "example: ABC1234");
	      }
	      
	      System.exit(0);
	   }

	   /**
	    * The isValid method determines whether a String is a valid customer number. 
	    * If so, it returns true.
	    * @param custNumber The String to test.
	    * @return true if valid, otherwise false.
	    */
		private static boolean isValid(String custNumber) {
			boolean goodSoFar = true;  // Flag
			int i = 0;                 // Control variable indexing the char

			// Test the length.
			if (custNumber.length() != 7)
				// set the flag to false if the length isn't right
				goodSoFar = false;
			
			// if it passes the length test
			if (goodSoFar){
				// Test the first three characters for letters.
				for (i=0; i<3; i++){
					// get one char
					char d =custNumber.charAt(i);
					// if the char is not a letter
					if (!Character.isLetter(d))
						// set the flag to false
						goodSoFar = false;
				}
				
				// Test the last four characters for digits.
				for (                ){
					// get one char
					
					// if the char is not a digit
					
						// set the flag to false
						
				}
			}

			return goodSoFar;
		}
}
