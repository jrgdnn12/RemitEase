package edu.unlv.mis768.labwork16;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.*;


public class PayrollManagementController {

	// add the FXML controls of Table view and TableColumn here








    @FXML
    private TextField nameTextField;
    @FXML
    private TextField rateTextField;
    @FXML
    private TextField hoursTextField;
    @FXML
    private Button addButton;
    @FXML
    private TextArea summaryTextArea;
    @FXML
    private Button generateButton;
    @FXML
    private Label totalLabel;
	
    /** 
     * For setting up initial values 
     */
	public void initialize() {
		// set up the columns in the table


			
	}

	/**
	 * Listener for addButton. It instantiate Payroll and set the filed values.
	 * Add the object to the TableView
	 */
	public void addButtonListener() {
		// create a Payroll object
		
		
		// set the values
		
		
		
		// get all the items from the table as a list, then add the new object to it
		// add it to the table
		
	}
	
	/**
	 * Listener of the deleteButton. Remove a selected object from the TableView
	 */
	public void deleteButtonListener() {
		// get the index of the item selected in the TableView
		
		
		// remove the row
		
	}
	
	/**
	 * Listener for generateButton. Print the Payroll objects in the TextArea
	 * Also add the wages to total
	 */
	public void generateButtonListener() {
		// The string to show the content of each Payroll object
		String str="";
		// variable for the total pay		
		double total =0;
		
		// a loop to traverse the loop
		// each row is an Payroll object
		/*
		for() {
			// use the toString() method to display the content of the object
			
			// use the calWage() method to get the pay
			
		}
		/*
		/* The following loop is the same as the above loop
	    for(int i =0;i<=tableView.getItems().size();i++) {
		// use the toString() method to display the content of the object
		str+= tableView.getItems().get(i).toString();
		// use the calWage() method to get the pay
		total+=tableView.getItems().get(i).calWage();
		}
		*/
		// display in the text area
		summaryTextArea.setText(str);
		// display the total in the label
		totalLabel.setText("Total payment: $"+total);
	}

}

