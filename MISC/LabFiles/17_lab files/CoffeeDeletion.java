package edu.unlv.mis768.labwork17;


import java.util.Scanner;
import java.sql.*;

public class CoffeeDeletion {

	public static void main(String[] args) {  
	    // Create named constants for the URL, user name and password
	    final String DB_URL = "jdbc:mysql://localhost:3306/CoffeeShopData";
	    final String USER_NAME = "root";
	    final String PASSWORD = "";
	    
		String prodNum;      // To hold the product number
	    double price;        // To hold the price
	    
	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	    try {
	    	// Create a connection to the database.
	        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

	        // Get the product number for the desired coffee.
	        System.out.print("Enter the product number: ");
	        prodNum = keyboard.nextLine();
	        
	        // Display the coffee's current data.
	        if (findProduct(conn, prodNum)) {
	            // Make sure the user wants to delete this product.
	            System.out.print("Are you sure you want to delete this item? (y/n): ");
	            String sure = keyboard.nextLine();

	            if (Character.toUpperCase(sure.charAt(0)) == 'Y') {
	               // Delete the specified coffee.
	               
	            }
	            else {
	               System.out.println("The item was not deleted.");
	            }

	          }
	          else  {
	        	// The specified product number was not found.
	            System.out.println("That product was not found.");
	          }

	          // Close the connection.
	          conn.close();
	       }
	       catch(Exception ex) {
	          System.out.println("ERROR: " + ex.getMessage());
	       }
	    }



		/**
	      The findAndDisplayProduct method finds a specified coffee
	      @param conn A Connection object to the database.
	      @param prodNum The product number for the desired coffee.
	      @return true or false to indicate whether the product was found.
	    */

	    public static boolean findProduct(Connection conn, String prodNum) throws SQLException {
	    	boolean productFound; // Flag

	        // Create a SELECT statement to get the specified row from the Coffee table.
	        String sqlStatement = "SELECT * FROM Coffee WHERE ProdNum = ?";

	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // provide the values for query.
	        prepStmt.setString(1, prodNum);
	        
	       // Send the SELECT statement to the DBMS.
	       ResultSet result = prepStmt.executeQuery();

	       // If the result is not empty (i.e., have data to be read)
	       if (result.next()) {
	             // Set the flag to indicate the product was found.
	             productFound = true;
	       }
	       else {
	          // Indicate the product was not found.
	          productFound = false;
	       }

	       return productFound;
	    }
   
		
}
