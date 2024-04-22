package edu.unlv.mis768.labwork18;

import java.io.IOException;
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeBrowser extends Application {
	
	// Declare the Connection object
	Connection conn;
    // Declare the ResultSet object
    ResultSet result;
    

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Call the method to execute the query and generate the ResultSet
		

		// the FXMLLoader object to load the UI
		FXMLLoader loader = new FXMLLoader();
		//specify the file location
    	loader.setLocation(getClass().getResource("CoffeeBrowser.fxml"));  	
		// load the UI
		Parent parent = loader.load();
   	  	
    	// access the controller via the loader
    	// in the FXML file, the controller class is specified
    	CoffeeBrowserController controller = loader.getController();

    	// call the method in the controller class
    	// Pass the ResultSet object to the Scene
    	
		// set the title of the window
		primaryStage.setTitle("Coffee Information");
		
		// set the scene
		Scene scene = new Scene(parent);
		// set the scene for the stage
		primaryStage.setScene(scene);

		// show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * This method is used to establish the DB connection
	 * 
	 */
	private void getDBConnection(){
		// Create named constants for the URL, user name and password
	    final String DB_URL = "jdbc:mysql://localhost:3306/coffeeShopData";
	    final String USER_NAME = "root";
	    final String PASSWORD = "";
	    
	    try {
	    	// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		       
		    // Create a Statement object. It should allow scrolling.
		    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		         
		    // Create a string with a SELECT statement.
		    String sql = "SELECT ProdNum, Description, Price FROM Coffee";
		         
		    // Send the statement to the DBMS.
		    result = stmt.executeQuery(sql);
		 }
		 catch(Exception ex) {
			 System.out.println("ERROR: " + ex.getMessage());
		 }		
	}
	
	/**
	 * Override the default stop() method to close the database connection
	 */
	@Override
	public void stop(){
		
	}
	
}
