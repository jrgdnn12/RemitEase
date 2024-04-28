package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TransactionController {

    @FXML
    private TextField amountSendTextField;

    @FXML
    private Label sendCurrency;

    @FXML
    private Label amountSendLabel;

    @FXML
    private Label amountReceiveLabel;

    @FXML
    private Label localCurrencyLabel;

    @FXML
    private TextField amountReceiveTextField;

    @FXML
    private ComboBox<?> partnerComboBox;

    @FXML
    private Label partnerLabel;

    @FXML
    private Label selectedPartnerLabel;

    @FXML
    private Label amountToBeSentLabel;

    @FXML
    private Label amountToBeSentTextField;

    @FXML
    private Label amountToBeReceivedLabel;

    @FXML
    private Label amountToBeReceivedTextField;

    @FXML
    private Label extraChargeLabel;

    @FXML
    private Label extraChargeTextField;

    @FXML
    private Label totalChargeLabel;

    @FXML
    private Label totalChargeTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button continueButton;

    @FXML
    void handleBackButtonAction(ActionEvent event) {
        openRecipient(event);
    }

    @FXML
    void handleResetButtonAction(ActionEvent event) {
        resetFields();
    }

    @FXML
    void handleContinueButtonAction(ActionEvent event) {
        openConfirmation(event);
    }

    private void openRecipient(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Recipient.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetFields() {
        amountSendTextField.clear();
        amountReceiveTextField.clear();
        partnerComboBox.getSelectionModel().clearSelection();
        selectedPartnerLabel.setText("");
        amountToBeSentTextField.setText("");
        amountToBeReceivedTextField.setText("");
        extraChargeTextField.setText("");
        totalChargeTextField.setText("");
    }

    private void openConfirmation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Confirmation.fxml"));
            Stage stage = (Stage) continueButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
