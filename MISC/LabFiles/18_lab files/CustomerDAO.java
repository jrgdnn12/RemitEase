package edu.unlv.mis768.labwork18;

import java.util.List;

public interface CustomerDAO {
		/**
		 * This method gets all the customer records.
		 * @return An List with Customer objects
		 */
	   public List<Customer> getAllCustomers();
	   
	   /**
	    * This method retrieves a customer record based on the given customer number.
	    * @param CNo Represents the primary key, customer number.
	    * @return a customer object
	    */
	   public Customer getCustomerById(String CNo);
	   
	   /**
	    * This method inserts a customer record into the database
	    * @param aCustomer a customer object
	    * @return whether the insertion is successful or not
	    */
	   public boolean insertCustomer(Customer aCustomer);
	   
	   /**
	    * This method updates a customer record in the database
	    * @param aCustomer a customer object
	    * @return whether the update is successful or not
	    */
	   public boolean updateCustomer(Customer aCustomer);
	   
	   /**
	    * This method deletes a customer record based on the given customer number.
	    * @param CNo Represent the primary key, customer number.
	    * @return whether the deletion is successful or not.
	    */
	   public boolean deleteCustomer(String CNo);
	   
		/**
		 * This method gets some customer records.
		 * @param A string represents the state
		 * @return An List with Customer objects
		 */
	   public List<Customer> getCustomersByState(String state);
}
