package edu.unlv.mis768.labwork18;

import java.sql.*;
import java.util.*;

/**
 * This class implements the Interface CustomerDAO.
 * @author Han-fen Hu
 * @version 1.0
 */
public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public List<Customer> getAllCustomers() {
		// Create a array list for the data.
        
        
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			String sql = "SELECT * from " + CoffeeDBConstants.CUSTOMER_TABLE_NAME;
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            
            
            //Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();                // Move to first row

            for (int row = 0; row < numRows; row++) {
            	// create a new object and fill the field with the values from the result set.

            	
            	
            	
            	//Add the object to the list



               // Go to the next row in the ResultSet.
               result.next();
            }
            // close the database connection
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		// return the result
		return customerList;
	}

	@Override
	public Customer getCustomerById(String CNo) {
		Customer aCustomer =  new Customer();
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			String sql = "SELECT * from " + CoffeeDBConstants.CUSTOMER_TABLE_NAME+
					     "WHERE "+CoffeeDBConstants.CUSTOMER_PK_NAME+" = "+CNo;
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            // create a new object and fill the field with the values from the result set.
            aCustomer  = new Customer(result.getString(0), result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));

            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return aCustomer;
	}


	public boolean insertCustomer(Customer aCustomer) {
		boolean flag=false;
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			
			String sql = "INSERT INTO " + CoffeeDBConstants.CUSTOMER_TABLE_NAME+
					     " VALUES ('"+
					     aCustomer.getCusNo()+"', '"+
					     aCustomer.getCusName()+"', '"+
					     aCustomer.getCusAddress()+"', '"+
					     aCustomer.getCusCity()+"', '"+
					     aCustomer.getCusState()+"', '"+
					     aCustomer.getCusZip()+"')";
			System.out.println(sql);
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}
	@Override
	public boolean updateCustomer(Customer aCustomer) {
		boolean flag=false;
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			
			String sql = "UPDATE " + CoffeeDBConstants.CUSTOMER_TABLE_NAME+
					     " SET Name = '"+ aCustomer.getCusName()+"', "+
					     " Address = '"+  aCustomer.getCusAddress()+"', "+
					     " City = '"+ aCustomer.getCusCity()+"', "+
					     " State = '"+ aCustomer.getCusState()+"', "+
					     " Zip = '"+aCustomer.getCusZip()+"'"+
					     " WHERE CustomerNumber = '"+ aCustomer.getCusNo()+"'";
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

		return flag;

	}

	@Override
	public boolean deleteCustomer(String CNo) {
		boolean flag=false;
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			
			String sql = "Delete FROM " + CoffeeDBConstants.CUSTOMER_TABLE_NAME+
					     " WHERE CustomerNumber = '"+ CNo +"'";
			
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

		return flag;

	}

	@Override
	public List<Customer> getCustomersByState(String state) {
		// Create a array list for the data.
		
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			String sql = "SELECT * from " + CoffeeDBConstants.CUSTOMER_TABLE_NAME
					+" where State = '"+state+"'";
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            
            
            //Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();                // Move to first row           
            
            for (int row = 0; row < numRows; row++) {
            	// create a new object and fill the field with the values from the result set.

            	
            	//Add the object to the list



               // Go to the next row in the ResultSet.
               result.next();
            }
            //close the database connection
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		// return the result
		return customerList;
	}
}
