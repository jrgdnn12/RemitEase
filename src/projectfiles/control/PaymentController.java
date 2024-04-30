package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {

    @FXML
    private void handleBackButtonAction(ActionEvent event) {
        openTransaction(event);
    }

    @FXML
    private void handleContinueButtonAction(ActionEvent event) {
        openConfirmation(event);
    }

    private void openTransaction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Transaction.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConfirmation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Confirmation.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
	         
        // Close the current Payment.fxml window
	        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        currentStage.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
}