package projectfiles.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projectfiles.Dao.CustomerDAOImpl;
import projectfiles.model.Customer;
import projectfiles.model.Recipient;
import projectfiles.Dao.UserDAOImpl;
import projectfiles.Dao.RecipientDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class RecipientController {

    @FXML
    private TextField firstNameTextField;
    
    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField cityTextField;
    
    @FXML
    private Label firstNameLabel;
    
    @FXML
    private Label lastNameLabel;
    
    @FXML
    private Label statusLabel;

    @FXML
    private TextField addressTextField;

	private int recipientId;

    @FXML
    void handleContinueButtonAction(ActionEvent event) {
        openTransaction();
        closeRecipientWindow();
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
        firstNameTextField.clear();
        lastNameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        countryTextField.clear();
        cityTextField.clear();
        addressTextField.clear();
    }

    private void openTransaction() {
        try {
        	
        	Continue();
        	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/Transaction.fxml"));
            Parent root = loader.load();

            // Get the controller instance
            TransactionController transactionController = loader.getController();

            // Pass the entered country to the TransactionController
            //DAO recipient
            RecipientDAOImpl recipientDAO = new RecipientDAOImpl();
            transactionController.setRecipient(recipientDAO.getRecipientById(recipientId));

            // Show the transaction view
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
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
    
    
    private void Continue() throws SQLException {
        String firstname = firstNameTextField.getText();      
        String lastname = lastNameTextField.getText();      
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String country = countryTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        
      //Create a new recipient object
        Recipient recipient = new Recipient(
        		0,
            firstname,
            lastname,
            email,
            phoneNumber,
            country,
            city,
            address
        );
        
        // Insert user data into the database
        insertUserData(recipient);
        


        
     // After successfully adding the recipient
        statusLabel.setText("Your recipient has been successfully added");
        resetFieldsExceptStatusLabel();
        
        
    }

    private void resetFieldsExceptStatusLabel() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        countryTextField.clear();
        cityTextField.clear();
        addressTextField.clear();
    }
    

	private int insertUserData(Recipient recipient) throws SQLException {
   
		    // Initialize DAO for recipient
		    RecipientDAOImpl recipientDAO = new RecipientDAOImpl();
		    // Add recipient
		    int recipientId = recipientDAO.addRecipient(recipient);
		    this.recipientId = recipientId;
			return recipientId;
		    
		}
		
		private boolean isFirstNameEmpty() {
	        return firstNameTextField.getText().isEmpty();
	    }

	    private void displayFirstNameEmptyError() {
	        statusLabel.setText("Error: First Name cannot be empty. Please enter your first name.");
	    }
	    
	    private boolean isLastNameEmpty() {
	    	return lastNameTextField.getText().isEmpty();
	    }
	    
	    private void displayLastNameEmptyError() {
	        statusLabel.setText("Error: First Name cannot be empty. Please enter your first name.");
	    }
	    
	    private boolean isEmailEmpty() {
	        return emailTextField.getText().isEmpty();
	    }

	    private void displayEmailEmptyError() {
	        statusLabel.setText("Error: Email cannot be empty. Please enter your email.");
	    }
	    
	    private boolean isPhoneNumberEmpty() {
	        return phoneNumberTextField.getText().isEmpty();
	    }

	    private void displayPhoneNumberEmptyError() {
	        statusLabel.setText("Error: Phone Number cannot be empty. Please enter your phone number.");
	    }
	    
	    private boolean isCountryEmpty() {
	        return countryTextField.getText().isEmpty();
	    }

	    private void displayCountryEmptyError() {
	        statusLabel.setText("Error: Country cannot be empty. Please enter your country.");
	    }
	    
	    private boolean isAddressEmpty() {
	        return addressTextField.getText().isEmpty();
	    }

	    private void displayAddressEmptyError() {
	        statusLabel.setText("Error: Address cannot be empty. Please enter your address.");
	    }
	    
	    private boolean isCityEmpty() {
	        return cityTextField.getText().isEmpty();
	    }

	    private void displayCityEmptyError() {
	        statusLabel.setText("Error: City cannot be empty. Please enter your city.");
	    }
        

	    private void closeRecipientWindow() {
	        Stage stage = (Stage) firstNameTextField.getScene().getWindow();
	        stage.close();
	    }
}