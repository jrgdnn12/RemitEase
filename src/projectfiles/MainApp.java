package projectfiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Adjust the path below to the correct location of your FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/LoginScreen.fxml"));
        
        Scene scene = new Scene(root, 700, 500); // Set the preferred width and height

        primaryStage.setTitle("Login - My Application"); // Set the title of the window
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the primary stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
