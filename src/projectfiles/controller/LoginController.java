package projectfiles.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import projectfiles.model.User;

public class LoginController {

    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button forgotPasswordButton;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> handleLogin());
        resetButton.setOnAction(event -> handleReset());
        forgotPasswordButton.setOnAction(event -> handleForgotPassword());
    }

    /**
     * Attempt to log in the user when the Login button is pressed.
     */
    private void handleLogin() {
        String userId = userIDTextField.getText();
        String password = passwordTextField.getText();

        User user = new User(userId, password);
        if (user.authenticate(password)) {
            // Assuming authentication success
            showAlertDialog("Login Success", "You are now logged in!", Alert.AlertType.INFORMATION);
            // Continue to next part of the application
        } else {
            // Authentication failed
            showAlertDialog("Login Failed", "Incorrect username or password.", Alert.AlertType.ERROR);
        }
    }

    /**
     * Clear all input fields when the Reset button is pressed.
     */
    private void handleReset() {
        userIDTextField.clear();
        passwordTextField.clear();
    }

    /**
     * Handle forgotten password scenario when the Forgot Password button is pressed.
     */
    private void handleForgotPassword() {
        showAlertDialog("Password Recovery", "Please contact support to recover your password.", Alert.AlertType.INFORMATION);
        // Implement further steps for password recovery
    }

    /**
     * Display an alert dialog to the user.
     * @param title the title of the alert dialog
     * @param content the content text of the alert dialog
     * @param type the type of the alert dialog
     */
    private void showAlertDialog(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
