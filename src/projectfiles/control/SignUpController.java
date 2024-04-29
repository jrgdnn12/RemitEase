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

    public Customer customer;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
	

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField userIDTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField repeatPasswordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button backButton;

    @FXML
    private Label statusLabel;
    
    @FXML
    private void openWelcomePage(ActionEvent event) {
        try {

            signUp(); // Call the signUp method
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

    private void signUp() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String userID = userIDTextField.getText();
        String password = passwordTextField.getText();
        String repeatPassword = repeatPasswordTextField.getText();
        String email = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String country = countryTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();

        //Create a new customer object
        Customer customer = new Customer (
            userID,
            password,
            1,
            email,
            firstName,
            lastName,
            phoneNumber,
            0.0,
            country,
            city,
            address
        );
        
        // Make the customer object available to other methods in the class
        this.customer = customer;
        

        // Validate password match
        if (!password.equals(repeatPassword)) {
            statusLabel.setText("Error: The passwords you entered do not match");
            return;
        }

        // Validate if userID already exists in the database
        if (userIDExists(customer)) {
            statusLabel.setText("Error: The User ID already exists");
            return;
        }
        
        
        // Insert user data into the database
        boolean success = insertUserData();

        if (success) {
            statusLabel.setText("Your account has been successfully created");
        } else {
            statusLabel.setText("Error occurred while creating your account. Please try again.");
        }
    
        
        // Check if First Name is empty
        if (isFirstNameEmpty()) {
            displayFirstNameEmptyError();
            return;
        }
        
        
        // Check if Last Name is empty
        if (isLastNameEmpty()) {
            displayLastNameEmptyError();
            return;
        }

        // Check if User ID is empty
        if (isUserIDEmpty()) {
            displayUserIDEmptyError();
            return;
        }
        
        // Check if Password is empty
        if (isPasswordEmpty()) {
            displayPasswordEmptyError();
            return;
        }
        
        
        // Check if Repeat Password is empty
        if (isRepeatPasswordEmpty()) {
            displayRepeatPasswordEmptyError();
            return;
        }
        
        // Check if Email is empty
        if (isEmailEmpty()) {
            displayEmailEmptyError();
            return;
        }
        
        // Check if Phone Number is empty
        if (isPhoneNumberEmpty()) {
            displayPhoneNumberEmptyError();
            return;
        }
        
        // Check if Country is empty
        if (isCountryEmpty()) {
            displayCountryEmptyError();
            return;
        }
        
        // Check if Address is empty
        if (isAddressEmpty()) {
            displayAddressEmptyError();
            return;
        }
        
        // Check if City is empty
        if (isCityEmpty()) {
            displayCityEmptyError();
            return;
        }
        
        

        // After successfully creating the account
        statusLabel.setText("Your account has been successfully created");
        resetFieldsExceptStatusLabel();

        
    }
    

    private boolean userIDExists(Customer customer) {
        
        try {
           //dao for user
           UserDAOImpl userDAO = new UserDAOImpl(); 
           boolean test = userDAO.doesUserExist(customer.getId());
              return test;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            
        }

        // Return false by default or if an exception occurred
        return false;
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
        statusLabel.setText("Error: Last Name cannot be empty. Please enter your last name.");
    }

    private boolean isUserIDEmpty() {
        return userIDTextField.getText().isEmpty();
    }

    private void displayUserIDEmptyError() {
        statusLabel.setText("Error: User ID cannot be empty. Please enter your user ID.");
    }
    
    private boolean isPasswordEmpty() {
        return passwordTextField.getText().isEmpty();
    }

    private void displayPasswordEmptyError() {
        statusLabel.setText("Error: Password cannot be empty. Please enter your password.");
    }
    
    private boolean isRepeatPasswordEmpty() {
        return repeatPasswordTextField.getText().isEmpty();
    }

    private void displayRepeatPasswordEmptyError() {
        statusLabel.setText("Error: Repeat your password.");
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
    
    private boolean insertUserData() {
        
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