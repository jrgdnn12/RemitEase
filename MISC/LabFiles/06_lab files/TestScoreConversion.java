package edu.unlv.mis768.labwork6;

import java.util.Scanner;

public class TestScoreConversion {
	   public static void main(String[] args)   {
		  //constants
	      final int ARRAY_SIZE = 4;  // Size of the array; number of scores
	      
	      // Create a Scanner objects for keyboard input.
	      Scanner keyboard = new Scanner(System.in);
	      
	      // Create an array for the scores
	      
	      // Create an array for the letter grades
	      

	      System.out.println("Enter a series of " + scores.length + " scores.");

	      // Read values into the array
	      for (int index = 0; index < scores.length; index++)      {
	         System.out.print("Enter score " + (index + 1) + ": ");
	         scores[index] = keyboard.nextInt();
	      }
	      
	      System.out.println("Here are the scores that you entered:");

	      // Pass the array to the showArray method.
	      
	      
	      // Pass the array to convert letters of the score to letter grade
	      
	      
	      // show the converted letter grades
	      System.out.println("Here are the corresponding letter grades:");
	      // use a for loop to show each element in the array


	   }



	/**
	      The showArray method accepts an array as
	      an argument and displays its contents.
	      @param array A reference to the array.
	   */

	   public static void showArray(int[] array)  {
	      // Display the array elements.
	      for (int index = 0; index < array.length; index++)
	         System.out.print(array[index] + " ");
	   }


}
