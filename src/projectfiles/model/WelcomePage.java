package projectfiles.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomePage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/WelcomePage.fxml"));
        
        // Set the scene
        primaryStage.setScene(new Scene(root));
        
        // Set the stage title
        primaryStage.setTitle("Welcome to RemitEase");
        
        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}