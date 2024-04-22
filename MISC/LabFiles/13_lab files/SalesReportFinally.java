package edu.unlv.mis768.labwork13;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesReportFinally {
	public static void main(String[] args) {
	      String filename = "SalesData.txt"; // File name
	      
	      try { // the try block mainly deals with exception in opening a file
	    	  //open the file.
	    	  File file = new File(filename);
	    	  Scanner inputFile = new Scanner(file);
	    	  
	    	  try { // this try block deals with reading double numbers
	    		  //Read and display the file's contents.
	    		  while (inputFile.hasNext()){
	    			  System.out.println(inputFile.nextDouble());
	    		  }
	    	  } catch (InputMismatchException e) {
	    		  System.out.println("Invalid data found.");
	    		  
	    	  } 
	    	  // need to close the file no matter what happened
	    	  
	    	  
	      } catch (FileNotFoundException e) {
	    	  System.out.println("File not found.");
	      }
	}      

}
