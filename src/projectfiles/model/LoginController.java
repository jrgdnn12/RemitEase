package projectfiles.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Label loginLabel;

    @FXML
    private Label userIDlabel;

    @FXML
    private TextField userIDTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button forgotPasswordButton;

    @FXML
    void handleReset(ActionEvent event) {
        // Handle reset functionality here
        userIDTextField.clear();
        passwordTextField.clear();
    }

    @FXML
    void handleLogin(ActionEvent event) {
        // Handle login functionality here
        String userID = userIDTextField.getText();
        String password = passwordTextField.getText();
        
        // You can add further logic here, such as validation and authentication
        System.out.println("User ID: " + userID);
        System.out.println("Password: " + password);
    }

    @FXML
    void handleForgotPassword(ActionEvent event) {
        // Handle forgot password functionality here
        // This could open a new window or display a dialog for password recovery
    }
}