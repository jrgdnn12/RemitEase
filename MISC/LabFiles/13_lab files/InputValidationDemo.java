package edu.unlv.mis768.labwork13;


import java.util.Scanner;

public class InputValidationDemo {

	public static void main(String[] args) {
		// declare an integer variable to be entered by the user
		int number = 0;
		
		// Declare Scanner object for input from keyboard
		Scanner kb = new Scanner(System.in);

		// prompt for user input and get an integer number
		System.out.print("Pleae enter an integer number: ");
		number = kb.nextInt();
		
		// print the value
		System.out.println("The value entered is: "+number);
	}

}
