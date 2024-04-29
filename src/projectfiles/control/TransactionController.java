package projectfiles.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import projectfiles.Dao.CustomerDAO;
import projectfiles.Dao.CustomerDAOImpl;
import projectfiles.Dao.PartnerDAOImpl;
import projectfiles.Dao.RecipientDAOImpl;
import projectfiles.Dao.RemittanceDAOImpl;
import projectfiles.app.SessionManager;
import projectfiles.model.Partner;
import projectfiles.model.Recipient;
import projectfiles.model.Remittance;
import projectfiles.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private ComboBox<String> partnerComboBox;

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

	Recipient newRecipient = null ;

    User user = SessionManager.getInstance().getCurrentUser();

    @FXML
    void handleBackButtonAction(ActionEvent event) {
        openRecipient(event);
    }

    @FXML
    void handleResetButtonAction(ActionEvent event) {
        resetFields();
    }

    @FXML
    void handleContinueButtonAction(ActionEvent event) throws SQLException{
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
    
    @FXML
    void initialize() throws SQLException{
        // Populate the partner combo box
        populatePartnerComboBox();

        // Add event listener to the partner combo box
        partnerComboBox.setOnAction(event -> handlePartnerComboBoxChanged());
    }

    private void populatePartnerComboBox() throws SQLException {
    	 if (newRecipient == null) {
    	        System.out.println("Recipient data is not available.");
    	        return; // or handle this case appropriately
    	    }
        //Dao Partner by ID
        PartnerDAOImpl partnerDAO = new PartnerDAOImpl();
        //partner array list
        List<Partner> partners = partnerDAO.getPartnerByCountry(newRecipient.getCountry());

        // Convert the list of partners to a list of strings
        List<String> partnerNames = new ArrayList<>();
        for (Partner partner : partners) {
            partnerNames.add(partner.getName());
        }

        //Observable list of partners
        ObservableList<String> obspartners = FXCollections.observableArrayList(partnerNames);

        partnerComboBox.setItems(obspartners);
    }

    private void handlePartnerComboBoxChanged() {
        String selectedPartner = partnerComboBox.getValue();
        selectedPartnerLabel.setText(selectedPartner);
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

    private void openConfirmation(ActionEvent event) throws SQLException {
        try {

            //partner DAO 
            PartnerDAOImpl partnerDAO = new PartnerDAOImpl();
            CustomerDAOImpl customerDAO = new CustomerDAOImpl();
            //Remittance object
            Remittance SendRemittance = new Remittance(
            0,
            customerDAO.getCustomerById(user.getId()),
            newRecipient,
            partnerDAO.getPartnerByNameAndCountry(selectedPartnerLabel.getText(),newRecipient.getCountry()),
            Double.parseDouble(amountSendTextField.getText()),
            Double.parseDouble(amountReceiveTextField.getText()),
            "USD",
            "USD",
            "Pending",
            null,
            null,
            "None",
            "None"

        );

        //send remiitance
        RemittanceDAOImpl remittanceDAO = new RemittanceDAOImpl();
        int RemittanceID = remittanceDAO.addRemittance(SendRemittance);
        
        //set new remittance id
        SendRemittance.setTransactionId(RemittanceID);
        
        

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/Confirmation.fxml"));
            Parent root = loader.load();
        //get the controller isntance
         // Get the controller instance
         ConfirmationController transactionController = loader.getController();
        
         // Pass the entered Remittance to the confirmation
         
         transactionController.setRemittance(SendRemittance);
        
            Stage stage = (Stage) continueButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public void setRecipient(Recipient recipient) {
		this.newRecipient = recipient;
		
	}

    public void postInitialize() {
        // Set the labels
        sendCurrency.setText("USD");
        localCurrencyLabel.setText(newRecipient.getCountry());
        amountSendLabel.setText("Amount to send in USD");
        amountReceiveLabel.setText("Amount to receive in " + newRecipient.getCountry());
        partnerLabel.setText("Select a partner to send money to");

        // Set the text fields
        amountToBeSentTextField.setText(amountSendTextField.getText());
        amountToBeReceivedTextField.setText(amountReceiveTextField.getText());
        extraChargeTextField.setText("0.00");
        totalChargeTextField.setText(amountSendTextField.getText());
    }


}
