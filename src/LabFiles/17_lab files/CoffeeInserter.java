package edu.unlv.mis768.labwork17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CoffeeInserter {

		public static void main(String[] args) {
			String description;  // To hold the coffee description
		    String prodNum;      // To hold the product number
		    double price;        // To hold the price

		    // Create named constants for the URL, user name and password
		    final String DB_URL = "jdbc:mysql://localhost:3306/coffeeShopData";
		    final String USER_NAME = "root";
		    final String PASSWORD = "";

		    // Create a Scanner object for keyboard input.
		    Scanner keyboard = new Scanner(System.in);
		      
	        // Get the data for the new coffee.
	        System.out.print("Enter the coffee description: ");
	        description = keyboard.nextLine();
	        System.out.print("Enter the product number: ");
	        prodNum = keyboard.nextLine();
	        System.out.print("Enter the price: ");
	        price = keyboard.nextDouble();
	        
	        // The SQL statement to be executed
	        
	        
	        try {
	        	// create a connection object to the database
				Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	        
				// instantiate a PrepareStatement object using the SQL command
				
				
				// provide the values for insertion. The order should be the same as specifed in the sqlStatement
				
				
				
				
				// for debugging
				System.out.println(prepStmt);
				
				// execute the sql command, and get how many rows are affected.
				
				
				// show a confirmation mesage
				System.out.print(row+" row has been inserted.");
				
				// close the connection
				conn.close();
				
	        } catch (SQLException e) {
	        	System.out.println("ERROR: "+e.getMessage());
	        }
		}



}
