package projectfiles.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class WelcomePageController {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


	    @FXML
	    private void handleLoginButtonAction(ActionEvent event) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
	            Parent root = loader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Login");
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @FXML
	    private void handleSignUpButtonAction(ActionEvent event) {
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
	            Parent root = loader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Sign Up");
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
