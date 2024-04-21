package edu.unlv.mis768.labwork11;

/**
   This program demonstrates the order in which
   superclass and subclass constructors are called.
*/

public class ConstructorDemo{
   public static void main(String[] args){
	   // instantiate an object of SubClass
	   // It should execute the SuperClass construct, then the SubClass constructor
      SubClass obj = new SubClass();
      
      // See the value of message afer executing the two constructors
      System.out.print(obj.getMessage());
   }
}
