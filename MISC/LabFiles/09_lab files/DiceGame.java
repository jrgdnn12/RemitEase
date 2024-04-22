package edu.unlv.mis768.labwork9;

import javax.swing.JOptionPane;

/**
   This program allows the user to set the number of sides for the die, 
   and also how many dice he/she would like to roll.
   The computer would roll the same dice as well to get the results.
*/

public class DiceGame {
   public static void main(String[] args)    {
      int numOfSide=0; // number of sides for the die. Enter by the user
      int userTotal=0; // variable to hold the total value for the dice 
      int computerTotal=0; // variable to hold the total value for the dice by the computer
      
      // get the number of sides.
      // check whether the number is greater than 0.
      while (numOfSide<=0){
    	  // showInputDialog() returns a string 
    	  String input = JOptionPane.showInputDialog("What kind of dice would you like to roll? "
    			  		+ "\n (How many sides? Please enter a positive number)");
    	  // parse the string and convert it to integer
    	  numOfSide = Integer.parseInt(input);
      }
      
      
      // Create 2 dice.
      Die die1 =  ;
      Die die2 =  ;
      // prompt the user about his/her choice
      JOptionPane.showMessageDialog(null, "You choose to roll two "+numOfSide+"-sided dice."
     								+ "\n Click OK to roll the dice.");
      
      // Roll and get total
      userTotal =        ;
      
      // show the result to the user 
      JOptionPane.showMessageDialog(null, "The result is "+die1.getValue()
                                                  +" and "+die2.getValue()
                                                  +"\nThe total is "+userTotal
                                                  +"\n Click OK to let the computer roll the dice.");
      // computer's turn
      computerTotal =           ;
      // result of computer's roll
      JOptionPane.showMessageDialog(null, "The result is "+die1.getValue()
      											  +" and "+die2.getValue()
      											  +"\nThe total is "+computerTotal);
      
      if (userTotal>computerTotal)
    	  JOptionPane.showMessageDialog(null, "You won!");
      else if (userTotal<computerTotal)
    	  JOptionPane.showMessageDialog(null, "Sorry, better luck next time");
      else 
    	  JOptionPane.showMessageDialog(null, "It's a tie!");
   }
   

   /**
    * The method simulates the rolling of two dice.
    * @param d1 First Die
    * @param d2 Second Die
    * @return the total value;
    */
   public static int rollDice(                ) {
	   int total=0;
      
      // Roll die 1.
	   
	   
	  // Roll die 2.
       
      
       // calculate the total
       total =           ;
       
      return total;
      
   }
}