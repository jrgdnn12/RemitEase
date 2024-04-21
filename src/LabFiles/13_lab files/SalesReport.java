package edu.unlv.mis768.labwork13;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * This program demonstrates how exceptions can be caught with try statement.
 */

public class SalesReport {
	public static void main(String[] args) {
	      String filename = "SalesData1.txt"; // File name
	      int months = 0;                    // Month counter
	      double oneMonth;                   // One month's sales
	      double totalSales = 0.0;           // Total sales
	      double averageSales;               // Average sales


	         // Open the file.
	         File file = new File(filename);
	         Scanner inputFile = new Scanner(file);

	         // Process the contents of the file.
	         while (inputFile.hasNext()) {
	            // Get a month's sales amount.
	            oneMonth = inputFile.nextDouble();
	            
	            // Accumulate the amount.
	            totalSales += oneMonth;
	            
	            // Increment the month counter
	            months++;
			 }
	         // Close the file.
	         inputFile.close();

	         // Calculate the average.
	         averageSales = totalSales / months;

	         // Display the results.
	         System.out.println("Number of months: " + months +
	                            "\nTotal Sales: $" + totalSales +
	                            "\nAverage Sales: $" + averageSales);
	      
		  System.out.println("Done.");
	}
}
