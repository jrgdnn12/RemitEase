package edu.unlv.mis768.labwork16;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

	public class ReadFileController {

	    @FXML
	    private Label fileNameLabel;

	    @FXML
	    private Button browseButton;

	    @FXML
	    private Button calculateButton;

	    @FXML
	    private Label resultLabel;
		
		// method for initializing the window
		public void initialize() {
    	
		}
	    
	    public void browseButtonListener() {
	    	// Instantiate the object of FileChoose
	    	
	    	// Set the title 
	    	
	    	
	    	// The showOpenDialog() method need to know which window it belongs to
	    	
	    	
	    	// if a file is selected
	    	if( ) {
	    		// get the file path
	    		
	    		// show the file path at the label
	    		
	    	}
	    }
	    
	    public void calcButtonListener() {
	    	// Formatter definition
	    	DecimalFormat ft = new DecimalFormat("###,##0.00");
	    	
	    	// total sales
			double total=0;
			// average sales
			double avg=0;
			// count how many days
			int dayCount = 0;
			
			// file object for the scanner
			
			// a Scanner object for reading the file
			
			
			
			// read the entire file
			while(inputfile.hasNext()) {
				// read a number, add it to the total
				
				// increase the day count
				
			}
			// close the file
			inputfile.close();
			
			// if more than 0 days
			if(dayCount !=0)
				// calculate the average
				avg = total/dayCount;
			
			// display the result.
			resultLabel.setText("The avarage sales per day is $"+ft.format(avg));
			
	    }

	}

