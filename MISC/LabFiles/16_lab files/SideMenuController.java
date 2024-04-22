package edu.unlv.mis768.labwork16;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SideMenuController {

    @FXML
    private Label totalLabel;
    
    @FXML
    private CheckBox friesCheckBox;

    @FXML
    private TextArea selectionTextArea;

    @FXML
    private Button calculateButton;
    
    @FXML
    private Button startOverButton;

    @FXML
    private CheckBox friedZucchiniCheckBox;

    @FXML
    private CheckBox saladCheckBox;
    
    // Declare a field for saving the sandwich selected in the previous window
    
   
	/**
    * the method for receiving values passed from the previous scene
    */





     /**
     * Move back to the first scene.
     * @param e
     */
    public void startOverButtonListener(ActionEvent e){
    	// the FXML loader object to load the UI design
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location
    	loader.setLocation(getClass().getResource("SandwichMenu.fxml"));
    	
		// try-catch for possible errors in reading the FXML file.
    	try {
    		// the object representing the root node of the scene; load the UI
    		Parent parent = loader.load();
   	
			// set the scene
			Scene scene = new Scene(parent);
    	   	
	    	// get the current window; i.e. the stage
	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	    	// change the title of the window
	    	stage.setTitle("Sandwich Menu");
	    	// set the scene for the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
			} catch (IOException e1) {
				
				System.out.print(e1.getMessage());
			}
    }
    
    /**
     * Calculating the total and display the result at a label
     */
    public void calculateButtonListener() {
    	double total = 0; // variable representing the total
    	
    	// get the price for sandwich
    	switch(orderItem) {
    	case "Cheese Burger":
    		total += 4.99;
    		break;
    	case "Chicken Sandwich":
    		total += 4.49;
    		break;
    	case "Tofu Burger":
    		total += 4.79;
    		break;    		
    	}
    	
    	//get the price for the sides
    	if(friesCheckBox.isSelected())
    		total+=0.99;
    	if(saladCheckBox.isSelected())
    		total+=3.99;
    	if(friedZucchiniCheckBox.isSelected())
    		total+=4.99;
    	
    	totalLabel.setText("The total is: "+total);
    }
    
    /**
     * Listener for the the check boxes
     * This method checks what are the sides selected and add them to the TextArea
     */
    public void checkBoxListener() {
    	String items = orderItem;
    	
    	if(friesCheckBox.isSelected())
    		items+="\nFries";
    	if(saladCheckBox.isSelected())
    		items+="\nSalad";
    	if(friedZucchiniCheckBox.isSelected())
    		items+="\n Fried Zucchini";
    	
    	selectionTextArea.setText(items);
    	
    }
}

