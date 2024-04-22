package projectfiles.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projectfiles.control.LoginController;
import projectfiles.control.SignUpController;
import projectfiles.control.WelcomePageController;

import java.io.IOException;

public class RunApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load WelcomePage.fxml
        FXMLLoader welcomeLoader = new FXMLLoader(getClass().getResource("WelcomePage.fxml"));
        Parent welcomeRoot = welcomeLoader.load();
        WelcomePageController welcomeController = welcomeLoader.getController();
        welcomeController.setPrimaryStage(primaryStage);

        // Set up the scene with WelcomePage.fxml
        Scene scene = new Scene(welcomeRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome to RemitEase");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}