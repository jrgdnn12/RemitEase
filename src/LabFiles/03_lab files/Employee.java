package edu.unlv.mis768.labwork3;

public class Employee {
	// Fields
	private String name; // name of the employee
	private int experiencePoint; // experience value of the employee
	
	// constants
	final double BASE_PAY = 25;  // the base pay rate
	final double REGULAR_HOURS = 40; // the regular working hours
	
	/* Constructor 
	 * set the default value for experience point*/
	public Employee() {
		experiencePoint = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperiencePoint() {
		return experiencePoint;
	}

	// add a certain number of points to the experience point
	public void earnExperiencePoint(int numOfPoints) {
		experiencePoint+= numOfPoints;
	}
	
	// calculate salary based on the number of hours given.
	public double calcSalary(int numOfHours) {
		// a simplified formula. We will revise it when we talk about if-else statement
		double salary = REGULAR_HOURS * BASE_PAY + (numOfHours-REGULAR_HOURS)*BASE_PAY*1.5;
		return salary;
	}

}
