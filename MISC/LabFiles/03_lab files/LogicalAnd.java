package edu.unlv.mis768.labwork3;

import java.util.Scanner;

public class LogicalAnd {
	   public static void main(String[] args){
			String name; // name of the employee
			int hours; // number of hours worked
			int points; // points earned
			Employee anEmployee = new Employee();
			
		    Scanner keyboard = new Scanner(System.in);
		    
		    // get the name
		    System.out.print("Enter the name: ");
		    name = keyboard.nextLine();
		    anEmployee.setName(name);
		    
		    // get the hours
		    System.out.print("Enter the number of hours: ");
		    hours = keyboard.nextInt();
		    
		    // get the points
		    System.out.print("Enter the number of points: ");
		    points = keyboard.nextInt();
			// allow the employee to earn the point as designated
			anEmployee.earnExperiencePoint(points);		
	      // Determine whether the employee is qualified
	      if (                                    ) {
	      }
	      else {

	      }
	   }

}
