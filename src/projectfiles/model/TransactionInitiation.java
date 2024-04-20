package projectfiles.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TransactionInitiation extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the TransactionInitiation.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/TransactionInitiation.fxml"));
            
            // Set the title of the window
            primaryStage.setTitle("Transaction Initiation");

            // Set the scene
            Scene scene = new Scene(root, 700, 500);
            primaryStage.setScene(scene);

            // Show the stage
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}