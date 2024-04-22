package edu.unlv.mis768.labwork3;

import java.util.Scanner;

public class EmployeeDemo2 {

	public static void main(String[] args) {
		String name; // the name of the employee.
		int points;  // the points earned.
		Employee newbie = new Employee();  // the Employee object

	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	    
	    // Get the first number.
	    System.out.print("Enter the name: ");
	    name = keyboard.nextLine();
	    // Set the name for the employee
	      newbie.setName(name);

	    // Get the exp points.
	    System.out.print("Enter the points earned: ");
	    points = keyboard.nextInt();

      if (                     )      {
         
      }
      else {
         
      }
	      // print the name and the exp
		  System.out.println("Name: "+ newbie.getName());
		  System.out.println("Exp: "+ newbie.getExperiencePoint());
   }

}
