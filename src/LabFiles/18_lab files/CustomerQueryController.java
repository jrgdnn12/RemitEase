package edu.unlv.mis768.labwork18;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerQueryController {

    @FXML
    private TableView<Customer> tableView;
	@FXML
    private TableColumn<Customer, String> nameTableColumn;
    @FXML
    private TableColumn<Customer, String> addressTableColumn;
    @FXML
    private TableColumn<Customer, String> cityTableColumn;
    @FXML
    private TableColumn<Customer, String> stateTableColumn;
    @FXML
    private TextField stateTextField;

	public void initialize() {
		// set up the columns in the table
		nameTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("cusName"));
		addressTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("cusAddress"));
		cityTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("cusCity"));
		stateTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("cusState"));
			
	}
	
	public void queryButtonListern() {
		// Instantiate an DAO object
		CustomerDAOImpl cDAO = new CustomerDAOImpl();
		// Declare the List for the result data
		List<Customer> customerList =  new ArrayList<Customer>();
		
		// call the getCustomersByState() method of the DAO class to get the result.
		// use the TextField as the query string
		
		// Convert the ArrayList into an ObservableList
		
		
		// Display at the TableView
		tableView.setItems();
		
	}
}
