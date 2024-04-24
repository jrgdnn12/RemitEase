package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RecipientController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    void handleContinueButtonAction(ActionEvent event) {
        openTransaction();
    }

    @FXML
    void handleResetButtonAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void handleBackButtonAction(ActionEvent event) {
        openSendMoney(event);
    }

    private void clearFields() {
        nameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        countryTextField.clear();
        cityTextField.clear();
        addressTextField.clear();
    }

    private void openTransaction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/Transaction.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openSendMoney(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/projectfiles/view/SendMoney.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
