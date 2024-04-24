package edu.unlv.mis768.labwork16;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BurgerJoint extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		// load the fxml file
		Parent parent = FXMLLoader.load(getClass().getResource("SandwichMenu.fxml"));
		// set the scene
		Scene scene = new Scene(parent);
		
		// set the title of the window
		primaryStage.setTitle("Sandwich Menu");
		// set the scene for the stage
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}


