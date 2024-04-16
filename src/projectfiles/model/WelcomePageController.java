package projectfiles.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    void handleLoginButtonClick(ActionEvent event) {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Login.fxml"));
            // Get the stage from the loginButton and set the scene with the loaded fxml
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleSignUpButtonClick(ActionEvent event) {
        try {
            // Load the SignUp.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/SignUp.fxml"));
            // Get the stage from the signUpButton and set the scene with the loaded fxml
            Stage stage = (Stage) signUpButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}