package projectfiles.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
	
	
	private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private TextField userIDTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private Button resetButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        // Add action listeners for buttons
        loginButton.setOnAction(event -> login());
        backButton.setOnAction(event -> openWelcomePage());
        resetButton.setOnAction(event -> resetFields());
    }

    private void login() {
        String userID = userIDTextField.getText();
        String password = passwordTextField.getText();

        // Here you would check if the userID and password match those in the database
        // For demonstration purposes, let's assume userID is "admin" and password is "password"
        if (userID.equals("admin") && password.equals("password")) {
            statusLabel.setText("Login successful");
            openTransactionInitiation();
        } else {
            statusLabel.setText("Error: User ID or Password is incorrect.");
        }
    }

    private void openWelcomePage() {
        // Write code to open WelcomePage.fxml
    }

    private void openTransactionInitiation() {
        // Write code to open TransactionInitiation.fxml
    }

    private void resetFields() {
        userIDTextField.clear();
        passwordTextField.clear();
        statusLabel.setText("");
    }
}