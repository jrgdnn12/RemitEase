package projectfiles.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class TransactionController {

    @FXML
    private Button backButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button continueButton;

    @FXML
    private TextField amountSendTextField;

    @FXML
    private ComboBox<String> partnerComboBox;

    // Other necessary fields and labels...

    // Method to handle back button action
    @FXML
    void handleBackButton(ActionEvent event) {
        openUpdateRecipient();
    }

    // Method to handle reset button action
    @FXML
    void handleResetButton(ActionEvent event) {
        // Clear all fields
        amountSendTextField.clear();
        partnerComboBox.getSelectionModel().clearSelection();
        // Clear other fields...
    }

    // Method to handle continue button action
    @FXML
    void handleContinueButton(ActionEvent event) {
        openConfirmation();
    }

    // Method to open the Update Recipient screen
    private void openUpdateRecipient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("updateRecipient.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to open the Confirmation screen
    private void openConfirmation() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) continueButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
