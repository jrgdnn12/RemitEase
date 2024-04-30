package projectfiles.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import projectfiles.Dao.CustomerDAOImpl;
import projectfiles.Dao.UserDAOImpl;
import projectfiles.model.Customer;

public class SignUpController {
	
    
	private Stage primaryStage;



    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
	
    @FXML
    private TextField addressTextField;

    @FXML
    private Button backButton;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label errorAddress;

    @FXML
    private Label errorCity;

    @FXML
    private Label errorCountry;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorFirstName;

    @FXML
    private Label errorLastName;

    @FXML
    private Label errorPassword;

    @FXML
    private Label errorPhoneNumber;

    @FXML
    private Label errorRepeatPassword;

    @FXML
    private Label errorUserID;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField repeatPasswordTextField;

    @FXML
    private Button resetButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField userIDTextField;

   
    @FXML
    void resetFields(ActionEvent event) {

    }
    
    @FXML
    private void openWelcomePage(ActionEvent event) {
        try {

           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/WelcomePage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("WelcomePage");
            stage.show();
            
         // Close the current sign-up window
            Stage signUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            signUpStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openLoginPage(ActionEvent event) {
        try {
        	signUp(); // Call the signUp method
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projectfiles/view/Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
            
         // Close the current sign-up window
            Stage signUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            signUpStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    private void initialize() {
        // Add action listeners for buttons
        resetButton.setOnAction(event -> resetFields());
    }

    private boolean isFieldEmpty(TextField field, String errorMessage) {
        if (field.getText().isEmpty()) {
            statusLabel.setText(errorMessage);
            return true;
        }
        return false;
    }
    
    private void signUp() {
        // Consolidated field empty checks
        if (isFieldEmpty(firstNameTextField, "Error: First Name cannot be empty. Please enter your first name.") ||
            isFieldEmpty(lastNameTextField, "Error: Last Name cannot be empty. Please enter your last name.") ||
            isFieldEmpty(userIDTextField, "Error: User ID cannot be empty. Please enter your user ID.") ||
            isFieldEmpty(passwordTextField, "Error: Password cannot be empty. Please enter your password.") ||
            isFieldEmpty(repeatPasswordTextField, "Error: Repeat your password.") ||
            isFieldEmpty(emailTextField, "Error: Email cannot be empty. Please enter your email.") ||
            isFieldEmpty(phoneNumberTextField, "Error: Phone Number cannot be empty. Please enter your phone number.") ||
            isFieldEmpty(countryTextField, "Error: Country cannot be empty. Please enter your country.") ||
            isFieldEmpty(addressTextField, "Error: Address cannot be empty. Please enter your address.") ||
            isFieldEmpty(cityTextField, "Error: City cannot be empty. Please enter your city.")) {
            return; // Exit if any field is empty
        }

        //does suwer exist
        
    
        // Validate password match
        if (!passwordTextField.getText().equals(repeatPasswordTextField.getText())) {
            statusLabel.setText("Error: The passwords you entered do not match");
            return;
        }
    
        // Create a new customer object
        Customer customer = new Customer(
            userIDTextField.getText(),
            passwordTextField.getText(),
            1,
            emailTextField.getText(),
            firstNameTextField.getText(),
            lastNameTextField.getText(),
            phoneNumberTextField.getText(),
            0.0,
            countryTextField.getText(),
            cityTextField.getText(),
            addressTextField.getText()
        );

        if (userIDExists(customer)) {
            statusLabel.setText("Error: The user ID you entered already exists. Please enter a different user ID.");
            return;
        }
    
        if (insertUserData(customer)) {
            statusLabel.setText("Your account has been successfully created");
            resetFieldsExceptStatusLabel();
        } else {
            statusLabel.setText("Error occurred while creating your account. Please try again.");
        }
    }
    

   private boolean userIDExists(Customer customer) {
       
       try {
          //dao for user
          UserDAOImpl userDAO = new UserDAOImpl(); 
          userDAO.doesUserExist(customer.getId());
          
       } catch (SQLException e) {
           e.printStackTrace(); // Handle the exception appropriately
           
       }

       // Return false by default or if an exception occurred
       return false;
   }
    
    
    
    private void resetFieldsExceptStatusLabel() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        userIDTextField.clear();
        passwordTextField.clear();
        repeatPasswordTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        countryTextField.clear();
        addressTextField.clear();
        cityTextField.clear();
    }
    
    private boolean insertUserData(Customer customer) {
        
        try {
    
            //intialize dao for custome
            CustomerDAOImpl customerDAO = new CustomerDAOImpl();
            //add customer
            boolean test = customerDAO.addCustomer(customer);
            return test;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    	
    	@FXML
        private void resetFields() {
            // Clear all text fields
            firstNameTextField.clear();
            lastNameTextField.clear();
            userIDTextField.clear();
            passwordTextField.clear();
            repeatPasswordTextField.clear();
            emailTextField.clear();
            phoneNumberTextField.clear();
            countryTextField.clear();
            addressTextField.clear();
            cityTextField.clear();
            statusLabel.setText("");
        }
       
}