package edu.unlv.mis768.assignments;


/**
 * Name: Philip Mensah
 * Purpose: To provide a user-friendly interface for managing customer orders at Joe's Automotive shop.
 * This class initializes and launches the JavaFX application, setting up the GUI defined in the associated FXML file 
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JoeAutomotive extends Application {

	// Entry point of the JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
    	// load the fxml file
        Parent parent = FXMLLoader.load(getClass().getResource("JoeAutomotive.fxml"));
        
        // set the scene
        Scene scene = new Scene(parent);
        
        // set the title of the window
        primaryStage.setTitle("Joe Automotive");
        
        // set the scene for the stage
        primaryStage.setScene(scene);
        
        // show the stage
        primaryStage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}