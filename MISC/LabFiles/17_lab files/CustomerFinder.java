package edu.unlv.mis768.labwork17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CustomerFinder {

	public static void main(String[] args) {
	    // Create named constants for the URL, user name and password
	    final String DB_URL = "jdbc:mysql://localhost:3306/CoffeeShopData";
	    final String USER_NAME = "root";
	    final String PASSWORD = "";
	    
		String customerNum;      // customerNumber to be entered
	    
	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	    
	    try {
	    	// Create a connection to the database.
	        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

	        // Get the customer number for the desired data
	        System.out.print("Enter the Customer number: ");
	        customerNum = keyboard.nextLine();
	        
	        // Create a SELECT statement to get the specific row from the Customer table.
	        

	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // provide the values for query.
	        
	        
	       // Send the SELECT statement to the DBMS.
	       ResultSet result = prepStmt.executeQuery();

	       // If the result is not empty (i.e., have data to be read)
	       if (   ) {
	             // Display the customer.
	             
	             
	             
	       }
	       else {
	    	   // show not found message
	    	   System.out.println("Customer not found");
	       }
	       
	       
	        // Close the connection.
	        conn.close();
	       }
	       catch(Exception ex) {
	          System.out.println("ERROR: " + ex.getMessage());
	       }
	}

}
