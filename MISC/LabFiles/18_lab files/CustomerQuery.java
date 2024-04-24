package edu.unlv.mis768.labwork18;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerQuery extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// the FXMLLoader object to load the UI
		FXMLLoader loader = new FXMLLoader();
		//specify the file location
    	loader.setLocation(getClass().getResource("CustomerQuery.fxml"));  	
		// load the UI
		Parent parent = loader.load();
   	  	
    	// call the method in the controller class
    	// Pass the ResultSet object to the Scene
    	
		// set the title of the window
		primaryStage.setTitle("Customer Information");
		
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
}
