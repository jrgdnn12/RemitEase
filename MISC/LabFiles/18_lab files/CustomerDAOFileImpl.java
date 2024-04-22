package edu.unlv.mis768.labwork18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDAOFileImpl implements CustomerDAO {

	@Override
	/**
	 * Retrieve all the customer from the file storage. Return all the customers' data in an list
	 */
	public List<Customer> getAllCustomers() {
		// declare a list for storing the result
		List<Customer> cList = new ArrayList<Customer>();
		
		// instantiate a file object for the data file
		File file = new File("CustomerData.csv");

		try {
			// Scanner object the use the file as the input
			Scanner inputFile =new Scanner(file);
			
			// variable to store a customer's record as a string
			String str="";
			
			// iterate through the file.
			while(inputFile.hasNext()) {
				// instantiate a customer object
				Customer c = new Customer();
				
				// read a line/record
				str = inputFile.nextLine();
				// split the string by comma
				String[] array = str.split(",");
				
				// The elements are number, name, address, city, state, and zip code, respectively.
				c.setCusNo(array[0]);
				c.setCusName(array[1]);
				c.setCusAddress(array[2]);
				c.setCusCity(array[3]);
				c.setCusState(array[4]);
				c.setCusZip(array[5]);
				
				// add the customer object to the list
				cList.add(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		
		return cList;
		
		
	}

	@Override
	/**
	 * The method finds a customer by the customer number
	 * @param The customer number
	 * @return The customer found
	 */
	public Customer getCustomerById(String CNo) {
		// a variable to indicate the position of the customer record in the file
		int position=0;
		
		// get all the customer records
		List<Customer> cList = this.getAllCustomers();
		
		// iterate through the list to find the position
		for(int i=0; i< cList.size();i++) {
			// compare the customer number of each record to the given CNo
			if(cList.get(i).getCusNo()==CNo)
				// save the index/position
				position= i;
		}
		
		// return the found customer record
		return cList.get(position);
	}

	@Override
	/**
	 * The method inserts a customer record ot the file
	 * @return Insertion successful or not
	 */
	public boolean insertCustomer(Customer aCustomer) {
		// instantiate the file writer object
		FileWriter fw;
		try {
			// open the file in append mode
			fw = new FileWriter("CustomerData.csv", true);
			PrintWriter outputFile = new PrintWriter(fw);
			
			// write each field to the file, using comma to separate the values.
			outputFile.println(aCustomer.getCusNo()+","
					+aCustomer.getCusName()+","
					+aCustomer.getCusAddress()+","
					+aCustomer.getCusCity()+","
					+aCustomer.getCusState()+","
					+aCustomer.getCusZip());
			// close the file
			outputFile.close();
			
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
			// return fail
			return false;
		}
		
		// result seccessful
		return true;
	}

	@Override
	/**
	 * the method update a customer record
	 * @param A customer object
	 * @return update successful or not
	 */
	public boolean updateCustomer(Customer aCustomer) {
		// get all the customer from the file
		List<Customer> cList = this.getAllCustomers();
		// indicating whether the customer can be found.
		boolean flag = false;
		
		// iterater through the list
		for(int i=0; i<cList.size();i++) {
			// if the customer number matches
			if(cList.get(i).getCusNo().equals(aCustomer.getCusNo())) {
				// set the new value to the found record
				cList.get(i).setCusName(aCustomer.getCusName());
				cList.get(i).setCusAddress(aCustomer.getCusAddress());
				cList.get(i).setCusCity(aCustomer.getCusCity());
				cList.get(i).setCusState(aCustomer.getCusState());
				cList.get(i).setCusZip(aCustomer.getCusZip());
				// indicating found and updated
				flag = true;
			}
		}
		
		// if found and updated, write the list back to file
		if(flag) {
			// instantiate the FileWrite
			FileWriter fw;
			// erase the file content
			try {
				fw = new FileWriter("CustomerData.csv", true);
				PrintWriter outputFile = new PrintWriter(fw);
				outputFile.write("");
				outputFile.close();
			} catch (IOException e) {
				System.out.println("ERROR: "+e.getMessage());
				// indicating failure
				flag = false;
			}
			
			// iterate through the list to write them to the file
			for(int i=0;i<cList.size(); i++) {
				this.insertCustomer(cList.get(i));
			}
		}
		
		
		return flag;
	}

	@Override
	/**
	 * The method removes a customer record
	 * @param The customer number
	 * @return deletion sucessful or not
	 */
	public boolean deleteCustomer(String CNo) {
		// get all the customer from the file
		List<Customer> cList = this.getAllCustomers();
		// indicating whether record found and removed.
		boolean flag = false;
		
		// iterate through the list
		for(int i=0; i<cList.size();i++) {
			// if the record found
			if(cList.get(i).getCusNo().equals(CNo)) {
				// remove it from the list
				cList.remove(i);
				// indicating found and removed.
				flag = true;
			}
		}
		
		// if found and removed, write the list back to file
		if(flag) {
			// instantiate the file writer
			FileWriter fw;
			try {
				// erase the file content
				fw = new FileWriter("CustomerData.csv", true);
				PrintWriter outputFile = new PrintWriter(fw);
				outputFile.write("");
				outputFile.close();
			} catch (IOException e) {
				System.out.println("ERROR: "+e.getMessage());
				// indicating failure
				flag = false;
			}
			
			// iterate through the list to write them to the file
			for(int i=0;i<cList.size(); i++) {
				this.insertCustomer(cList.get(i));
			}
		}
		
		
		return flag;
	}

	@Override
	/**
	 * The methods finds all the customers for a specific state
	 * @param The state name
	 * @return the list of customer from the state
	 */
	public List<Customer> getCustomersByState(String state) {
		// Get all customers from the file
		List<Customer> cList = this.getAllCustomers();
		// the result list
		List<Customer> resultList = new ArrayList<Customer>();
		
		// iterate through the list
		for(int i=0; i<cList.size();i++) {
			// if the state matches
			if(cList.get(i).getCusState().equals(state)) {
				// add to the result list
				resultList.add(cList.get(i));
			}
		}
		
		return resultList;
		
	}

}
