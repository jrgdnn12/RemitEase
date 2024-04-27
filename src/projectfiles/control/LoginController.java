package projectfiles.control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
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
    
    private Object resetFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@FXML
    void handleBackButtonAction(ActionEvent event) {
        openWelcomePage();
    }
    
    @FXML
    void handleResetButtonAction(ActionEvent event) {
        userIDTextField.setText("");
        passwordTextField.setText("");
    }
    
    @FXML
    void handleContinueButtonAction(ActionEvent event) {
        openMainMenu();
    }


    private void login() {
        String userID = userIDTextField.getText();
        String password = passwordTextField.getText();

        // Here you would check if the userID and password match those in the database
        // For demonstration purposes, let's assume userID is "admin" and password is "password"
        if (userID.equals("admin") && password.equals("password")) {
            statusLabel.setText("Login successful");
            openMainMenu();
        } else {
            statusLabel.setText("Error: User ID or Password is incorrect.");
        }
    }

    private void openWelcomePage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/WelcomePage.fxml"));
            Stage stage = (Stage) userIDTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openMainMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/MainMenu.fxml"));
            Stage stage = (Stage) userIDTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}