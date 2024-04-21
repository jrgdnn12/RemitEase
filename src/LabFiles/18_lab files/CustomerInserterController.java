package edu.unlv.mis768.labwork18;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class CustomerInserterController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField numTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField addreessTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private Button saveButton;
    
	
	public void cancleButtonListener() {
		numTextField.setText("");
		nameTextField.setText("");
		addreessTextField.setText("");
		cityTextField.setText("");
		stateTextField.setText("");
		zipTextField.setText("");
	}
	
	public void saveButtonListener() {
	    // Get the user input from text fields
	    String num=numTextField.getText();
    
	    // if the customer number is empty, show message.
	    if (num.length()<1){
	    	// use an Alert object to show an error message.
	    	Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Customer Inserter");
	    	alert.setContentText("The customer number cannot be empty.");

	    	alert.showAndWait();
	    }
	    
	    // if the customer number is good
	    else {
		    String name=nameTextField.getText();
		    String address=addreessTextField.getText();
		    String city=cityTextField.getText();
		    String state=stateTextField.getText();
		    String zip=zipTextField.getText();
		    
		    // Create a customer object, and fill the fields with the values
		    
		    
		    // Create a DAO object
		    
		    
		    // use the DAO object, insertCustomer() method to insert the record
		    if (       ) {
	    		// Message to the user, showing the end of execution
		    	// use an Alert object to show an error message.
		    	Alert confirm = new Alert(AlertType.INFORMATION);
		    	confirm.setTitle("Customer Inserter");
		    	confirm.setContentText("The record was inserted.");

		    	confirm.showAndWait();
		    }
		    else {
	    		// Message to the user, showing the failure of execution
		    	// use an Alert object to show an error message.
		    	Alert alert = new Alert(AlertType.WARNING);
		    	alert.setTitle("Customer Inserter");
		    	alert.setContentText("The record was not inserted. \\nPlease try again.");

		    	alert.showAndWait();
		    }
	    }
	}
}
