package edu.unlv.mis768.labwork13;

import java.io.*;
import java.util.Scanner;

/**
   This program serializes the objects in an array of
   BankAccount2 objects.
*/

public class SerializeObjects{
   public static void main(String[] args) throws IOException   {
      double balance;            // An account balance
      final int NUM_ITEMS = 3;   // Number of accounts
  
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
            
      // Create a BankAccount array
      BankAccount[] accounts = new BankAccount[NUM_ITEMS];
      
      // Populate the array.
      for (int i = 0; i < accounts.length; i++) {
         // Get an account balance.
         System.out.print("Enter the balance for account " + (i + 1) + ": ");
         balance = keyboard.nextDouble();

         // Create an object in the array.
         try {
			accounts[i]=new BankAccount(balance);
		} catch (NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		}
      }
      
      // Create the stream objects.
      
      
      // Write the serialized objects to the file.
      for (int i = 0; i < accounts.length; i++)      {
         
      }
      
      // Close the file.
      
      
      System.out.println("The serialized objects were written to the Objects.dat file.");
   }
}
