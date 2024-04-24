package edu.unlv.mis768.labwork5;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalesReports {
	/**
	This program opens a file containing the sales
	amounts for 30 days. It calculates and displays
	the total sales and average daily sales.
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException  {
	      final int NUM_DAYS = 30; // Number of days of sales
	      String filename;         // The name of the file to open
	      double totalSales;       // Total sales for period
	      double averageSales;     // Average daily sales
	      		
		  // declare a Scanner object for keyboard input
		  Scanner kb = new Scanner(System.in);
		  // prompt the user to enter the file name
		  System.out.print("File name please?");
		  // get the string from the user 
		  filename = kb.nextLine();			
	      
	      // Get the total sales from the file.
	      totalSales = getTotalSales(filename);
	      
	      // Calculate the average.
	      averageSales = totalSales / NUM_DAYS;
	      
	      // Display the total and average.
	      System.out.println("The total sales for the period is $"+totalSales);
	      System.out.println("The average daily sales were $"+ averageSales);
	}
	
	public static double getTotalSales(String filename) {

	
	
	
	
	
	
	
	
	}

}
